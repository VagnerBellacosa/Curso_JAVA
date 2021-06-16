# Assertions em Java

Enfim, as Assertions servem para testar se o seu código esta de acordo com as regras que deve seguir (vamos dar exemplos melhores a frente), sem precisar fazer laços enormes com “throw new” e mais outros recursos só para testar se tudo está certo. As Assertions são utilizadas SOMENTE e APENAS para o ambiente de desenvolvimento, quando o software for para produção, elas devem ser retiradas sem que o software seja afetado. Por isso ao implementar assert não deixe seu software “dependente” destes, de forma que depois você não consiga tirar sem mudar a lógica do mesmo.

A sintaxe para uso de Assertions pode ser de duas formas:

- assert Expressão¹;
- assert Expressão¹ : Expressão²;

Acontece que o assert sempre deverá ter um valor Verdadeiro, caso contrário ele levantará uma exceção AssertionError. No primeiro caso de sintaxe é testado apenas se a expressão passada é True, caso contrário é “levantada” uma exceção, já no segundo caso além da expressão principal, uma segunda expressão serve como mensagem para que o programador veja o que esta ocorrendo.

## Usando Assertion na Prática

Como sempre, vamos partir para a prática e entender o uso dos Assertions, vamos utilizar exemplos da própria documentação da Oracle, para facilitar o entendimento.

Imagine a seguinte situação: Você desenvolveu um software que calcula a velocidade de partículas, e você sabe que essa velocidade deve ser menor que a velocidade da luz. Para efeito de conhecimento a velocidade da luz é aproximadamente: 300mil KM/s. Na listagem 1 vamos fazer um exemplo para testar se a velocidade da partícula é menor que a velocidade da luz e parar a execução caso isso seja falso.

Um código que consome muito espaço apenas para testar uma simples proposição, que poderíamos simplificar em apenas 1 linha com assert. Afinal, se você parar para pensar a velocidade da partícula tem que obrigatoriamente se menor que a velocidade da luz, e o usuário não precisa saber disso, o software apenas tem que certificar que o valor seja sempre exatamente menor que a velocidade da luz, por isso não podemos colocar o mesmo em produção se isso estiver errado, é uma regra de negócio.

Na listagem 2 vamos fazer a mesma comparação, porém usando assert, assim diminuímos a complexidade do código e facilitamos uma remoção para quando a aplicação for para produção.

Vá até Java -> Installed JREs. Você deve selecionar o JRE que você utiliza e clicar em Editar (Edit).

Regras Importantes

Antes de começar a usar assert tenha em mentes algumas regras que devem ser seguidas:

- Não use Assert no lugar do IF/ELSE, pois ele deve ser retirado quando o software for para produção.
- O Assert não testa métodos públicos, ou valores digitados diretamente pelo usuário, ou seja, passe variáveis já prontas para que ele possa testar.
- E um dos mais importantes: Jamais faça seu software depender do assert, isso significa que o assert não pode causar efeitos colaterais ao seu software, você deve poder habilitar e desabilitá-lo sem nenhum problema. Veja na listagem 3 um forma errada de usar o assert.

Perceba no código acima que se comentarmos a linha “assert nullsRemoved;” o código continuará funcionando da mesma forma, sem nenhum efeito colateral. Só colocamos o assert para certificar que o valor é o que desejamos, e que o software esta funcionando como desejamos, ao por em produção, comentaremos ou removemos essa linha.

## Conclusão

Assertivas ou Asserts é um recurso muito poderoso para aumentar a produtividade no desenvolvimento de sistemas, assim você não precisará ficar debugando linhas e linhas de código para descobrir 1 simples erro. Se utilizado da forma correta, com certeza será um forte aliado em grandes projetos.