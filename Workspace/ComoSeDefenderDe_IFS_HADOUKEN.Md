# Java

## COMO SE DEFENDER DE “IFS HADOUKEN”

O caso de muitos condicionais aninhados é um code smell relativamente comum. Programadores mais experientes não devem ter problema em refatorar esse tipo de código. Para muitos, a história é um pouco diferente e, se você olhou para a imagem deste post e já se viu em uma situação como essa sem saber o que fazer, ou se você não vê problema nenhum neste tipo de construção, então esse post definitivamente é pra você.

Ao longo do post, utilizaremos o código da imagem como base e veremos como melhorar a legibilidade, clareza e extensibilidade no uso de multiplos condicionais para o problema de validação de dados.

## FILHO FEIO NÃO TEM PAI

Para facilitar o nosso trabalho, abaixo temos o código da imagem em texto:

...
function register()
{
    if (!empty($_POST)) {
        $msg = '';
        if ($_POST['user_name']) {
            if ($_POST['user_password_new']) {
                if ($_POST['user_password_new'] === $_POST['user_password_repeat']) {
                    if (strlen($_POST['user_password_new']) > 5) {
                        if (strlen($_POST['user_name']) < 65 && strlen($_POST['user_name']) > 1) {
                            if (preg_match('/^[a-z\d]{2,64}$/i', $_POST['user_name'])) {
                                $user = read_user($_POST['user_name']);
                                if (!isset($user['user_name'])) {
                                    if ($_POST['user_email']) {
                                        if (strlen($_POST['user_email'] < 65)) {
                                            if (filter_var($_POST['user_email'], FILTER_VALIDATE_EMAIL)) {
                                                create_user();
                                                $_SESSION['msg'] = 'You are now registered so please login';
                                                header('Location: '.$_SERVER['PHP_SELF']);
                                                exit();
                                            } else $msg = 'You must provide a valid email address';
                                        } else $msg = 'Email must be less than 64 characters';
                                    } else $msg = 'Email cannot be empty';
                                } else $msg = 'Username already exists';
                            } else $msg = 'Username must be only a-z, A-Z, 0-9';
                        } else $msg = 'Username must be between 2 and 64 characters';
                    } else $msg = 'Password must be at least 6 characters';
                } else $msg = 'Passwords do not match';
            } else $msg = 'Empty Password';
        } else $msg = 'Empty Username';
        $_SESSION['msg'] = $msg;
    }
    return register_form();
}
...

Não me culpem se o código acima estiver horrível pra ler dentro da caixa de código do blog. Esse é só mais um dos problemas desse tipo de código :/

## PROBLEMA

O problema que o código se propõe a solucionar é o da validação de dados através de multiplas condições, em que a falha em atender uma delas, deve retornar uma mensagem de erro e um usuário não é criado.

### ENTRADA

Um array associativo (estrutura que em PHP correspondente a um hash map) cujas chaves (user_name, user_password_new, user_password_repeat e user_email) correspondem aos campos de um formulário de registro de usuário a ser validado.

### SAÍDA

Chama função create_user() caso todas os critérios de validação passem, ou uma mensagem de erro exceção é levantada, caso alguma condição de validação falhe.

#### CASOS DE TESTE

A função, apesar de ter o nome register (registrar), tem a função de validação de dados em 90% de duas linhas de código. Isso também é um problema mas, por enquanto, vamos nos focar somente na validação, que é onde está o nosso hadouken. Vamos ao comportamento esperado dos testes:

- Retorna “Empty Username” caso nenhum nome de usuário (user_name) seja fornecido
- Retorna “Empty Password” caso nenhuma senha (user_password_new) seja fornecida
- Retorna “Passwords no not match” caso o campo de senha (user_password_new) tenha valor diferente de repita sua senha (user_password_repeat)
- Retorna ‘Password must be at least 6 characters’ caso a senha tenha menos de 6 caracteres
- Retorna ‘Username must be between 2 and 64 characters’ caso o nome de usuário tenha menos de 2 ou mais de 64 caracteres.
- Retorna ‘Username must be only a-z, A-Z, 0-9’ caso o nome de usuário contenha caracteres não-alfanuméricos.
- Retorna ‘Username already exists’ caso já existe usuário cadastrado com mesmo nome
- Retorna ‘Email cannot be empty’ caso nenhum email (user_email) seja fornecido
- Retorna ‘Email must be less than 64 characters’ caso o email tenha mais de 64 caracteres
- Retorna ‘You must provide a valid email address’ caso um endereço de email válido não seja fornecido
- Retorna ‘You are now registered so please login’ caso um nome de usuário único seja fornecido, cujo tamanho seja entre 2 e 64 caracteres e não possua caracteres não-alfanuméricos; um email válido com menos de 64 caracteres; “senha” e “repita sua senha” idênticos e com pelo menos 6 caracteres.

## SOLUÇÃO

Tantos casos possíveis em um código com legibilidade tão ruim não pode dar em boa coisa, né? O grande problema enfrentado aqui é que o fluxo de execução do código não é óbvio. Não é nem um pouco claro o que cada condicional faz. Resolver isso é fácil:

...
class UserValidationException extends Exception{
//...
}
// ...
if (empty($_POST['user_name']))
      throw new UserValidationException('Empty Username');
if (empty($_POST['user_password_new']))
      throw new UserValidationException('Empty Password');
// ...
...

Esse tipo de solução faz com que as consequências sejam observadas logo após seus condicionais e isso é sempre uma boa coisa. Para atingir esse objetivo, basta substituir todas as condições por suas respectivas negações.

...
try {
    if (empty($_POST['user_name']))
        throw new UserValidationException('Empty Username');
    if (empty($_POST['user_password_new']))
        throw new UserValidationException('Empty Password');
    // ...
    create_user();
    $msg = 'You are now registered so please login';
 
    header('Location: '.$_SERVER['PHP_SELF']);
    return;
}
catch (UserValidationException $e){
    $msg = $e->getMessage();
}
finally{
    $_SESSION['msg'] = $msg;
}
return register_form();
...

## CONCLUSÃO

Com essas mudanças, melhoramos a legibilidade através do uso de exceções para controle de fluxo. Essa nem sempre é a solução adequada, mas é possível usar a máxima: Avoid else, return early.

A refatoração realizada ao longo do post não é o máximo que podemos fazer parar melhorar esse código, mas foi o suficiente para reduzir os níveis de indentação do código  e entender como se defender do hadouken. Como passos seguintes a ser tomados, podemos citar:

Encapsular as validações para not empty username, password e email em um único método, assim como outras validações. Lembre-se: Don`t Repeat Yourself (DRY). Ex:

...
function notEmpty(array $array, array $keys){
    foreach ($keys as $key){
        if (empty($array[$key]))
            return false;
    }
    return true;
}
>>> notEmpty($_POST, ["user_name", "user_password", "user_password_new"])
...

Ao invés de parar a validação a cada erro, uma solução mais inteligente verificaria todas as condições e retornaria um vetor de erros (condições que falharam), se fosse o caso.

A função não deveria manipular diretamente a variable global $_POST, e sim receber um array associativo (hash map) como entrada a ser validada. Manipulação de sessão e redirects também não deveriam acontecer nessa função e ferem o princípio de responsabilidade única, que sempre é uma boa prática e melhora muito a testabilidade do código.

[Artigo original](https://diogommartins.wordpress.com/2016/08/22/como-se-defender-de-ifs-hadouken/)