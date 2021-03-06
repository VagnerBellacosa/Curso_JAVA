# Java

## COMO SE DEFENDER DE �IFS HADOUKEN�

O caso de muitos condicionais aninhados � um code smell relativamente comum. Programadores mais experientes n�o devem ter problema em refatorar esse tipo de c�digo. Para muitos, a hist�ria � um pouco diferente e, se voc� olhou para a imagem deste post e j� se viu em uma situa��o como essa sem saber o que fazer, ou se voc� n�o v� problema nenhum neste tipo de constru��o, ent�o esse post definitivamente � pra voc�.

Ao longo do post, utilizaremos o c�digo da imagem como base e veremos como melhorar a legibilidade, clareza e extensibilidade no uso de multiplos condicionais para o problema de valida��o de dados.

## FILHO FEIO N�O TEM PAI

Para facilitar o nosso trabalho, abaixo temos o c�digo da imagem em texto:

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

N�o me culpem se o c�digo acima estiver horr�vel pra ler dentro da caixa de c�digo do blog. Esse � s� mais um dos problemas desse tipo de c�digo :/

## PROBLEMA

O problema que o c�digo se prop�e a solucionar � o da valida��o de dados atrav�s de multiplas condi��es, em que a falha em atender uma delas, deve retornar uma mensagem de erro e um usu�rio n�o � criado.

### ENTRADA

Um array associativo (estrutura que em PHP correspondente a um hash map) cujas chaves (user_name, user_password_new, user_password_repeat e user_email) correspondem aos campos de um formul�rio de registro de usu�rio a ser validado.

### SA�DA

Chama fun��o create_user() caso todas os crit�rios de valida��o passem, ou uma mensagem de erro exce��o � levantada, caso alguma condi��o de valida��o falhe.

#### CASOS DE TESTE

A fun��o, apesar de ter o nome register (registrar), tem a fun��o de valida��o de dados em 90% de duas linhas de c�digo. Isso tamb�m � um problema mas, por enquanto, vamos nos focar somente na valida��o, que � onde est� o nosso hadouken. Vamos ao comportamento esperado dos testes:

- Retorna �Empty Username� caso nenhum nome de usu�rio (user_name) seja fornecido
- Retorna �Empty Password� caso nenhuma senha (user_password_new) seja fornecida
- Retorna �Passwords no not match� caso o campo de senha (user_password_new) tenha valor diferente de repita sua senha (user_password_repeat)
- Retorna �Password must be at least 6 characters� caso a senha tenha menos de 6 caracteres
- Retorna �Username must be between 2 and 64 characters� caso o nome de usu�rio tenha menos de 2 ou mais de 64 caracteres.
- Retorna �Username must be only a-z, A-Z, 0-9� caso o nome de usu�rio contenha caracteres n�o-alfanum�ricos.
- Retorna �Username already exists� caso j� existe usu�rio cadastrado com mesmo nome
- Retorna �Email cannot be empty� caso nenhum email (user_email) seja fornecido
- Retorna �Email must be less than 64 characters� caso o email tenha mais de 64 caracteres
- Retorna �You must provide a valid email address� caso um endere�o de email v�lido n�o seja fornecido
- Retorna �You are now registered so please login� caso um nome de usu�rio �nico seja fornecido, cujo tamanho seja entre 2 e 64 caracteres e n�o possua caracteres n�o-alfanum�ricos; um email v�lido com menos de 64 caracteres; �senha� e �repita sua senha� id�nticos e com pelo menos 6 caracteres.

## SOLU��O

Tantos casos poss�veis em um c�digo com legibilidade t�o ruim n�o pode dar em boa coisa, n�? O grande problema enfrentado aqui � que o fluxo de execu��o do c�digo n�o � �bvio. N�o � nem um pouco claro o que cada condicional faz. Resolver isso � f�cil:

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

Esse tipo de solu��o faz com que as consequ�ncias sejam observadas logo ap�s seus condicionais e isso � sempre uma boa coisa. Para atingir esse objetivo, basta substituir todas as condi��es por suas respectivas nega��es.

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

## CONCLUS�O

Com essas mudan�as, melhoramos a legibilidade atrav�s do uso de exce��es para controle de fluxo. Essa nem sempre � a solu��o adequada, mas � poss�vel usar a m�xima: Avoid else, return early.

A refatora��o realizada ao longo do post n�o � o m�ximo que podemos fazer parar melhorar esse c�digo, mas foi o suficiente para reduzir os n�veis de indenta��o do c�digo  e entender como se defender do hadouken. Como passos seguintes a ser tomados, podemos citar:

Encapsular as valida��es para not empty username, password e email em um �nico m�todo, assim como outras valida��es. Lembre-se: Don`t Repeat Yourself (DRY). Ex:

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

Ao inv�s de parar a valida��o a cada erro, uma solu��o mais inteligente verificaria todas as condi��es e retornaria um vetor de erros (condi��es que falharam), se fosse o caso.

A fun��o n�o deveria manipular diretamente a variable global $_POST, e sim receber um array associativo (hash map) como entrada a ser validada. Manipula��o de sess�o e redirects tamb�m n�o deveriam acontecer nessa fun��o e ferem o princ�pio de responsabilidade �nica, que sempre � uma boa pr�tica e melhora muito a testabilidade do c�digo.

[Artigo original](https://diogommartins.wordpress.com/2016/08/22/como-se-defender-de-ifs-hadouken/)