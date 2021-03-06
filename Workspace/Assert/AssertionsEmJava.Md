# Assertions em Java

Enfim, as Assertions servem para testar se o seu c�digo esta de acordo com as regras que deve seguir (vamos dar exemplos melhores a frente), sem precisar fazer la�os enormes com �throw new� e mais outros recursos s� para testar se tudo est� certo. As Assertions s�o utilizadas SOMENTE e APENAS para o ambiente de desenvolvimento, quando o software for para produ��o, elas devem ser retiradas sem que o software seja afetado. Por isso ao implementar assert n�o deixe seu software �dependente� destes, de forma que depois voc� n�o consiga tirar sem mudar a l�gica do mesmo.

A sintaxe para uso de Assertions pode ser de duas formas: 

- assert Express�o�;
- assert Express�o� : Express�o�;

Acontece que o assert sempre dever� ter um valor Verdadeiro, caso contr�rio ele levantar� uma exce��o AssertionError. No primeiro caso de sintaxe � testado apenas se a express�o passada � True, caso contr�rio � �levantada� uma exce��o, j� no segundo caso al�m da express�o principal, uma segunda express�o serve como mensagem para que o programador veja o que esta ocorrendo.

## Usando Assertion na Pr�tica

Como sempre, vamos partir para a pr�tica e entender o uso dos Assertions, vamos utilizar exemplos da pr�pria documenta��o da Oracle, para facilitar o entendimento.

Imagine a seguinte situa��o: Voc� desenvolveu um software que calcula a velocidade de part�culas, e voc� sabe que essa velocidade deve ser menor que a velocidade da luz. Para efeito de conhecimento a velocidade da luz � aproximadamente: 300mil KM/s. Na listagem 1 vamos fazer um exemplo para testar se a velocidade da part�cula � menor que a velocidade da luz e parar a execu��o caso isso seja falso.

Um c�digo que consome muito espa�o apenas para testar uma simples proposi��o, que poder�amos simplificar em apenas 1 linha com assert. Afinal, se voc� parar para pensar a velocidade da part�cula tem que obrigatoriamente se menor que a velocidade da luz, e o usu�rio n�o precisa saber disso, o software apenas tem que certificar que o valor seja sempre exatamente menor que a velocidade da luz, por isso n�o podemos colocar o mesmo em produ��o se isso estiver errado, � uma regra de neg�cio.

Na listagem 2 vamos fazer a mesma compara��o, por�m usando assert, assim diminu�mos a complexidade do c�digo e facilitamos uma remo��o para quando a aplica��o for para produ��o.

V� at� Java -> Installed JREs. Voc� deve selecionar o JRE que voc� utiliza e clicar em Editar (Edit).

Regras Importantes

Antes de come�ar a usar assert tenha em mentes algumas regras que devem ser seguidas:

- N�o use Assert no lugar do IF/ELSE, pois ele deve ser retirado quando o software for para produ��o.
- O Assert n�o testa m�todos p�blicos, ou valores digitados diretamente pelo usu�rio, ou seja, passe vari�veis j� prontas para que ele possa testar.
- E um dos mais importantes: Jamais fa�a seu software depender do assert, isso significa que o assert n�o pode causar efeitos colaterais ao seu software, voc� deve poder habilitar e desabilit�-lo sem nenhum problema. Veja na listagem 3 um forma errada de usar o assert.

Perceba no c�digo acima que se comentarmos a linha �assert nullsRemoved;� o c�digo continuar� funcionando da mesma forma, sem nenhum efeito colateral. S� colocamos o assert para certificar que o valor � o que desejamos, e que o software esta funcionando como desejamos, ao por em produ��o, comentaremos ou removemos essa linha.

## Conclus�o

Assertivas ou Asserts � um recurso muito poderoso para aumentar a produtividade no desenvolvimento de sistemas, assim voc� n�o precisar� ficar debugando linhas e linhas de c�digo para descobrir 1 simples erro. Se utilizado da forma correta, com certeza ser� um forte aliado em grandes projetos.