# Spring Boot

## O que � Spring Boot?

Se voc� gostou dessa ideia, continue comigo que eu vou te mostrar como criar esse tipo de aplica��o utilizando o Spring Boot.

Olha s� o que voc� ir� aprender nesse artigo:

:heavy_check_mark: O que � Spring Boot
:heavy_check_mark: Instalando o STS (Spring Tool Suite)
:heavy_check_mark: Desenvolver uma pequena aplica��o web para listagem de contatos
:heavy_check_mark: Que benef�cios tem o DevTools
:heavy_check_mark: Como publicar sua aplica��o no Heroku

O Spring Boot � um projeto da Spring que veio para facilitar o processo de configura��o e publica��o de nossas aplica��es. A inten��o � ter o seu projeto rodando o mais r�pido poss�vel e sem complica��o.

Ele consegue isso favorecendo a conven��o sobre a configura��o. Basta que voc� diga pra ele quais m�dulos deseja utilizar (WEB, Template, Persist�ncia, Seguran�a, etc.) que ele vai reconhecer e configurar.

Voc� escolhe os m�dulos que deseja atrav�s dos starters que inclui no pom.xml do seu projeto. Eles, basicamente, s�o depend�ncias que agrupam outras depend�ncias. Inclusive, como temos esse grupo de depend�ncias representadas pelo starter, nosso pom.xml acaba por ficar mais organizado.

Apesar do Spring Boot, atrav�s da conven��o, j� deixar tudo configurado, nada impede que voc� crie as suas customiza��es caso sejam necess�rias.

O maior benef�cio do Spring Boot � que ele nos deixa mais livres para pensarmos nas regras de neg�cio da nossa aplica��o.

## Instalando o Spring Tool Suite

O Spring Tool Suite � uma IDE baseada em Eclipse que d� algumas facilidades para trabalhos com o Spring no geral. Uma das coisas legais � que ele nos ajuda a criar projetos com Spring Boot.

Mas, o STS n�o � pr�-requisito para cria��o de projetos com Spring Boot. Voc� vai poder trabalhar com Spring Boot em qualquer IDE que d� suporte ao Maven. Inclusive um site interessante para aqueles que forem utilizar outras IDEs � o http://start.spring.io. Ele ajuda na cria��o de um novo projeto Spring Boot quase que da mesma forma que o STS.

Existem vers�es do STS para Linux, Mac e Windows. Voc� pode baixar em: http://spring.io/tools/sts/all.

Come�ar um projeto com Spring Boot no STS � bem simples. No menu File, selecione New e depois Spring Starter Project.

A primeira tela que voc� ver� ser� essa daqui:

New Spring Starter Project

Caso voc� j� tenha criado algum projeto Maven no Eclipse, ent�o voc� deve conhec�-la bem.

O segundo passo que � algo mais espec�fico do Spring Boot. Veja:

New Spring Starter Project - Dependencies

A tela acima � onde voc� escolhe as depend�ncias do seu projeto, ou seja, os m�dulos que voc� vai querer utilizar.

Para o projeto aqui do artigo, eu selecionei:

- DevTools (veremos mais a frente)
- JPA
- H2 (nosso banco de dados em mem�ria � n�o precisamos instalar)
- Web (Spring MVC)
- Thymeleaf (Motor para templates HTML)

Existem v�rios outros al�m desses a�. Voc� pode usar o campo de texto para fazer uma pesquisa e encontrar rapidamente os que desejar.

Basicamente, a �nica coisa que essa segunda tela faz � permitir a sele��o das depend�ncias que ficar�o no pom.xml do nosso projeto. Nada mais. Mas isso j� � de grande ajuda, pois, n�o precisamos ficar lembrando do groupId e do artifactId de cada uma.

Depois que fizer a sele��o das depend�ncias, voc� pode clicar em Finish. Voc� vai verificar a seguinte estrutura no seu projeto:

Projeto Spring Boot no Package Explorer

Repare, na imagem acima, que uma classe importante j� foi criada. � a classe ArtigoSpringBootApplication:

...

package com.algaworks.contatos;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class ArtigoSpringBootApplication {
 
  public static void main(String[] args) {
    SpringApplication.run(ArtigoSpringBootApplication.class, args);
  }
 
}
...

Ela cont�m o m�todo main que inicia a nossa aplica��o. Engra�ado isso, pois, a nossa aplica��o ser� uma aplica��o web.

Acontece que o Spring Boot usa um container embarcado (por padr�o � o Tomcat) para facilitar o desenvolvimento. Por isso, para iniciar a aplica��o, basta executar o m�todo main acima.

Nesse ponto, nosso projeto j� est� pronto para receber as regras de neg�cio.

Aplica��o para listagem de contatos
Vamos agora criar uma p�gina que vai utilizar o Spring Data JPA, o Spring MVC e o Thymeleaf para listar contatos vindos da base de dados.

Vou come�ar criando a entidade Contato que vai representar uma tabela do banco de dados:

...
@Entity
public class Contato implements Serializable {
 
  private static final long serialVersionUID = 1L;
   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
   
  private String nome;
   
  private String email;
 
  // getters e setters omitidos
}
...

Quanto a camada de persist�ncia, vou utilizar o Sprint Data JPA para criar o meu reposit�rio de contatos. Vou cham�-lo de Contatos:

...
public interface Contatos extends JpaRepository<Contato, Long> {
}
...

Detalhe: n�o precisamos dar uma implementa��o para a interface acima. Isso fica a cargo do Spring Data JPA.

A �ltima classe do projeto ser� o controlador. Chamarei de ContatosController:

...
@Controller
@RequestMapping("/contatos")
public class ContatosController {
   
  @Autowired
  private Contatos contatos;
   
  @GetMapping
  public ModelAndView listar() {
    List&lt;Contato&gt; lista = contatos.findAll();
     
    ModelAndView modelAndView = new ModelAndView("contatos");
    modelAndView.addObject("contatos", lista);
     
    return modelAndView;
  } 
}
...

Falta ainda nossa p�gina HTML que, com ajuda do Thymeleaf, vai exibir essa lista de contatos para o usu�rio. Os arquivos HTML s�o criados, por padr�o, dentro do diret�rio src/main/resources/templates. Ent�o clique com o direito nesse diret�rio e crie o arquivo contatos.html:

...
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Listagem de contatos utilizando o Spring Boot</title>
</head>
 
<body>
  <h1>Lista de contatos</h1>
  <table>
    <thead>
      <tr>
        <th>#</th>
        <th>Nome</th>
        <th>E-mail</th>
      </tr>
    </thead>
    <tbody>
      <tr th:each="contato: ${contatos}">  
        <td th:text="${contato.id}"></td>
        <td th:text="${contato.nome}"></td>
        <td th:text="${contato.email}"></td>
      </tr>
    </tbody>
  </table>
</body>
</html>
...

Agora basta voc� clicar com o direito em cima do projeto, selecionar Run As, depois Spring Boot App e pronto! J� temos uma aplica��o rodando. Acesse http://localhost:8080/contatos para conferir.

Caso voc� n�o esteja utilizando o STS, ent�o pode rodar o projeto executando o m�todo main da classe ArtigoSpringBootApplication ou ainda, atrav�s do terminal, executando o comando:

...
$ mvn clean package spring-boot:run
...

Ah! Para que voc� n�o se depare com uma tabela vazia, crie um arquivo SQL de nome import.sql no diret�rio src/main/resources com o seguinte conte�do:

...
insert into Contato (id, nome, email) values (1, 'William Douglas', 'williamdouglas@algaworks.com');
insert into Contato (id, nome, email) values (2, 'Al Ries', 'alries@algaworks.com');
insert into Contato (id, nome, email) values (3, 'Mortimer J. Adler', 'mortimeradler@algaworks.com');
insert into Contato (id, nome, email) values (4, 'Christian Barbosa', 'christianbarbosa@algaworks.com');
Rodar a aplica��o com dados de teste � bem melhor, n�o � mesmo? :)
...

### Benef�cios do DevTools

DevTools � um m�dulo do Spring Boot que adiciona algumas ferramentas que s�o interessantes em tempo de desenvolvimento. No momento da cria��o do projeto, o DevTools foi um dos m�dulos que selecionei.

Um primeiro benef�cio dele � quanto a configura��o de propriedades �teis para desenvolvimento.

Algumas bibliotecas suportadas pelo Spring Boot usam cache para melhorar sua performance. O Thymeleaf, por exemplo, faz o cache dos seus templates para n�o ter que recarreg�-los a toda vez que forem requisitados. Isso, claro, � muito bom em produ��o, mas pode atrapalhar em tempo de desenvolvimento.

Para ajudar nessa situa��o o DevTools configura algumas propriedades com valores que s�o convenientes em tempo de desenvolvimento. Uma delas, por exemplo, � a que avisa ao Thymeleaf para n�o fazer cache dos seus templates. Ele deixa spring.thymeleaf.cache como false.

O segundo benef�cio que gostaria de comentar � a reinicializa��o autom�tica. Cada arquivo criado nos diret�rios que fazem parte do seu classpath ser�o monitorados e qualquer altera��o neles acarretar� em uma reinicializa��o do Spring Boot. Esses diret�rios s�o, basicamente, os diret�rios src/main/java e src/main/resources.

Lembrando que altera��es em arquivos web est�ticos e nos de templates n�o ir�o causar uma reinicializa��o. Eles n�o precisam.

Um �ltimo benef�cio que quero comentar � o fato do DevTools conter um servidor embarcado do LiveReload. O que esse servidor faz � enviar um aviso para o navegador dizendo que os nossos arquivos est�ticos ou os de templates foram alterados. E com isso o navegador atualiza nossa p�gina sozinho.

Para que isso funcione, al�m do servidor embarcado, � preciso que voc� instale uma extens�o do LiveReload em seu navegador. Voc� pode encontr�-la no site livereload.com. Logo ap�s a instala��o da extens�o, voc� deve acessar a aplica��o e clicar no icone do LiveReload.

Spring Boot VS Spring MVC

Quem aprende Spring come�ando com Spring Boot pode pensar que ele � um framework web. Isso � porque muitos exemplos com o Spring Boot, como o nosso caso, s�o de aplica��es web.

Acontece que usar Spring Boot, sem o Spring MVC, n�o faz, do seu projeto, um projeto web.

Spring Boot e Spring MVC s�o frameworks diferentes. O primeiro nos ajuda com tarefas de infraestrutura do nosso projeto e o segundo nos ajuda a tratar requisi��es web.

Como publicar sua aplica��o feita com Spring Boot no Heroku
Para fechar com chave de outro, vamos publicar nossa aplica��o na internet. Vou dar algumas dicas de como fazer isso utilizando o Heroku.

O Heroku � um servi�o de hospedagem que j� nos fornece toda a plataforma � como, por exemplo, quest�es de seguran�a e o pr�prio JDK instalado � que precisamos para publicar nosso projeto.

Caso voc� nunca tenha utilizado o Heroku, ent�o vai precisar de tr�s coisas. A primeira � fazer a instala��o do Git (gerenciador de c�digo-fonte). A segunda � fazer o cadastro no site. Por �ltimo, voc� vai precisar instalar o Heroku CLI (para disponibilizar o comando heroku no seu terminal).

Depois, voc� pode rodar os seguintes comandos no seu terminal:

...
$ cd /pasta/do/projeto/gestao-contatos

$ git init; git add .; git commit -m "Vers�o conclu�da."

$ heroku login # login pelo terminal (utilize mesmo usu�rio e senha do cadastro)

$ heroku create # cria a sua aplica��o l� no Heroku

$ git push heroku master # envia sua aplica��o para o Heroku

$ heroku open # abre sua aplica��o no navegador
...

## Veja aplica��o rodando no Heroku:

Aplica��o com Spring Boot - Lista de contatos

### Conclus�o

O Spring Boot traz grandes benef�cios para quem trabalha com Spring e, nesse artigo, passei um pouco disso.

Vimos sobre o que � o Spring Boot, instalamos o STS e j� partimos para o desenvolvimento de uma pequena aplica��o para listagem de contatos. Depois, conversei com voc� sobre o DevTools, que s�o ferramentas que facilitam nosso trabalho em tempo de desenvolvimento.

Por �ltimo, ainda publicamos a aplica��o na internet atrav�s do Heroku.

Com pouco c�digo e nenhuma configura��o, j� foi poss�vel publicar uma aplica��o, com Spring Boot, na internet. Como voc� p�de comprovar, ele veio para nos deixar focados no que mais importa: as regras da nossa aplica��o.

[Artigo original](https://blog.algaworks.com/spring-boot/)