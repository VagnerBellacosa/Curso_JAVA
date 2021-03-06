# SOAP

## Simple Object Access Protocol (SOAP)

### Indice:

[1 � Defini��o](## 1. Defini��o)
[2 � SOAP e Web Services](## 2. SOAP e Web Services)
[3 � Estrutura do Protocolo](## 3. Estrutura do protocolo)
[4 � Remote Procedure Call (RPC)](## 4. RPC- Remote Procedure Call)
[5 � Web Service Description Language (WSDL)](## 5. Web Service Description Language)
[6 � Exemplos](## 6. � Exemplos)
[7 - SOAP em HTTP](## 7. SOAP em HTTP)

## 1. Defini��o
SOAP � um protocolo baseado em XML para troca de informa��es em um ambiente distribuido.

� utilizado para troca de mensagens entre aplicativos distribuidos pela rede.

Estes aplicativos, ou �Web services�, possuem uma interface de acesso simples e bem definida.

Os Web services s�o componentes que permitem �s aplica��es enviar e receber dados em formato XML Cada aplica��o pode ter a sua pr�pria "linguagem", que � traduzida para uma linguagem universal, o formato XML.

## 2. SOAP e Web Services

Web Services s�o usados para disponibilizar servi�os interativos na WEB, podendo ser acessados por outras aplica��es. SOAP (Simple Object Access Protocol) est� se tornando padr�o para a troca de mensagens entre aplica��es e Web Services, j� que � uma tecnologia constru�da com base em XML e HTTP.

As aplica��es atuais se comunicam usando Chamadas Remotas de Procedimento (RPC) entre objetos como DCOM e CORBA, mas HTTP n�o foi projetado para isso. RPC representa tanto um problema de compatibilidade como de seguran�a. Firewall�s e servidores proxy ir�o normalmente bloquear este tipo de tr�fego.

Uma melhor forma para a comunica��o entre aplica��es � fazendo-se atrav�s do protocolo HTTP. Este � protocolo "standard" em todos os navegadores e servidores de internet. SOAP foi criado para que este tipo de comunica��o se tornasse poss�vel.

SOAP � um procolo projetado para invocar aplica��es remotas atrav�s de RPC ou trocas de mensagens, em um ambiente independente de plataforma e linguagem de programa��o. SOAP �, portanto, um padr�o normalmente aceito para utilizar-se com Web Services. Desta forma, pretende-se garantir a interoperabilidade e intercomunica��o entre diferentes sistemas, atrav�s da utiliza��o de uma linguagem (XML) e mecanismo de transporte (HTTP) padr�es.

Concluindo, o SOAP � o elemento principal da infra-estrutura dos Web Services e um fator fundamental para o funcionamento dos mesmos, independente de plataformas, sistemas operacionais, modelos de objetos e linguagens de programa��o, auxiliando muito a interoperabilidade entre objetos e componentes distribu�dos. Este tem um papel muito importante e acaba com a disputa entre linguagens, garantindo que o programador possa desenvolver no ambiente que seja mais adequado �s suas necessidades. Al�m de todas essas qualidades, o fato tamb�m de n�o ser preciso o seu conhecimento para sua utiliza��o fazem do SOAP uma excelente escolha para o desenvolvimento de Web Services.

O fato de n�o ser preciso o seu conhecimento para a manipula��o dos Web Services facilita a vida de qualquer programador. Visto que a maioria das linguagens j� trazem classes implementadas deste protocolo, facilitando ainda mais a sua utiliza��o.

## 3. Estrutura do protocolo

- **Envelope:** Toda mensagem SOAP deve cont�- lo. � o elemento raiz do documento XML. O Envelope pode conter declara��es de namespaces e tamb�m atributos adicionais como o que define o estilo de codifica��o (encoding style).Um "encoding style" define como os dados s�o representados no documento XML.
- **Header:** � um cabe�alho opcional. Ele carrega informa��es adicionais, como por exemplo, se a mensagem deve ser processada por um determinado n� intermedi�rio (� importante lembrar que, ao trafegar pela rede, a mensagem normalmente passa por diversos pontos intermedi�rios, at� alcan�ar o destino final). Quando utilizado, o Header deve ser o primeiro elemento do Envelope.
- **Body:** Este elemento � obrigat�rio e cont�m o payload, ou a informa��o a ser transportada para o seu destino final. O elemento Body pode conter um elemento opcional Fault, usado para carregar mensagens de status e erros retornadas pelos "n�s" ao processarem a mensagem.

De acordo com o W3Schools, a estrutura da mensagem SOAP � definida em um documento XML que cont�m os seguintes elementos:

...
<SOAP-ENV:envelope>
<!� Elemento raiz do SOAP e define que essa � uma mensagem SOAP-->
<SOAP-ENV:header>
<!�Especifica informa��es especificas como autentica��o (opcional)-->
</SOAP-ENV:header>
<SOAP-ENV:body>
<!�O elemento BODY cont�m o corpo da mensagem-->
<SOAP-ENV:fault>
<!�O elemento FAULT cont�m os erros que podem ocorrer-->
</SOAP-ENV:fault>
</SOAP-ENV:body>
</SOAP-ENV:envelope>
...

** Envelope (obrigat�rio):** � respons�vel por definir o conte�do da mensagem;

- encodingStyle: atributo que tem como objetivo especificar como as informa��es devem ser codificadas.

---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
...
</SOAP-ENV:Header>
<SOAP-ENV:Body>
�
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
Header (opcional): cont�m os dados do cabe�alho;
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
</SOAP-ENV:Header>
<SOAP-ENV:Body>
�
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
- actor: especifica o receptor que deve processar o elemento do cabe�alho.
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�
SOAP- ENV:actor=�http://www.mauricioreckziegel.com/soap/authenticator�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
- musUnderstand: especifica se uma entrada de cabe�alho � obrigat�ria ou opcional (booleano).
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�
SOAP-ENV:mustUndestrand=�1�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---

. Body (obrigat�rio): cont�m a codifica��o atual de uma chamada a um m�todo e todos os argumentos de entrada ou uma resposta codificada que cont�m o resultado de uma chamada de um m�todo.
. Fault: cont�m as informa��es dos erros ocorridos no envio da mensagem. Apenas nas mensagens de resposta do servidor.

O envelope SOAP � a parte obrigat�ria de uma mensagem SOAP. Ele funciona como um recipiente de todos os outros elementos da mensagem, possivelmente o cabe�alho e o corpo, assim como os namespaces de cada um. Assim como o nome e o endere�o de uma carta entregue pelo correio, o envelope SOAP precisa das informa��es espec�ficas do protocolo de transporte que est� ligado a ele, com o intuito de garantir a chegada ao local certo. Especificamente no HTTP, temos um cabe�alho que se chama SOAPAction, indicador do endere�o de entrega da mensagem. Um dos principais motivos de implementarmos o cabe�alho desta maneira � porque administradores de sistemas podem configurar seus firewalls para filtrar as mensagens baseadas nas informa��es dos cabe�alhos, sem consultar o XML.

 | Elemento | Namespace / URI |
 | Envelope | http://schemas.xmlsoap.org/soap/envelope |
 | Serializador | http://schemas.xmlsoap.org/soap/encoding |
 | SOAP-ENV | http://schemas.xmlsoap.org/soap/envelope |
 | SOAP-ENC | http://schemas.xmlsoap.org/soap/encoding |
 | Xsi | http://www.w3.org/1999/XMLSchema-instance |
 | Xsd | http://www.w3.org/1999/XMLSchema |

### Tabela. Namespaces / URI padr�es do SOAP

De acordo com o W3Schools, a estrutura da mensagem SOAP � definida em um documento XML que cont�m os seguintes elementos:
...
<SOAP-ENV:envelope>
<!� Elemento raiz do SOAP e define que essa � uma mensagem SOAP-->
<SOAP-ENV:header>
<!�Especifica informa��es especificas como autentica��o (opcional)-->
</SOAP-ENV:header>
<SOAP-ENV:body>
<!�O elemento BODY cont�m o corpo da mensagem-->
<SOAP-ENV:fault>
<!�O elemento FAULT cont�m os erros que podem ocorrer-->
</SOAP-ENV:fault>
</SOAP-ENV:body>
</SOAP-ENV:envelope>
...

Envelope (obrigat�rio): � respons�vel por definir o conte�do da mensagem;
- encodingStyle: atributo que tem como objetivo especificar como as informa��es devem ser codificadas.
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
...
</SOAP-ENV:Header>
<SOAP-ENV:Body>
�
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
---

Header (opcional): cont�m os dados do cabe�alho;
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
</SOAP-ENV:Header>
<SOAP-ENV:Body>
�
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
- actor: especifica o receptor que deve processar o elemento do cabe�alho.
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�
SOAP- ENV:actor=�http://www.mauricioreckziegel.com/soap/authenticator�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
- musUnderstand: especifica se uma entrada de cabe�alho � obrigat�ria ou opcional (booleano).
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�
SOAP-ENV:mustUndestrand=�1�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
. Body (obrigat�rio): cont�m a codifica��o atual de uma chamada a um m�todo e todos os argumentos de entrada ou uma resposta codificada que cont�m o resultado de uma chamada de um m�todo.
. Fault: cont�m as informa��es dos erros ocorridos no envio da mensagem. Apenas nas mensagens de resposta do servidor.

O envelope SOAP � a parte obrigat�ria de uma mensagem SOAP. Ele funciona como um recipiente de todos os outros elementos da mensagem, possivelmente o cabe�alho e o corpo, assim como os namespaces de cada um. Assim como o nome e o endere�o de uma carta entregue pelo correio, o envelope SOAP precisa das informa��es espec�ficas do protocolo de transporte que est� ligado a ele, com o intuito de garantir a chegada ao local certo. Especificamente no HTTP, temos um cabe�alho que se chama SOAPAction, indicador do endere�o de entrega da mensagem. Um dos principais motivos de implementarmos o cabe�alho desta maneira � porque administradores de sistemas podem configurar seus firewalls para filtrar as mensagens baseadas nas informa��es dos cabe�alhos, sem consultar o XML.

 | Elemento | Namespace / URI | 
 | Envelope | http://schemas.xmlsoap.org/soap/envelope | 
 | Serializador | http://schemas.xmlsoap.org/soap/encoding | 
 | SOAP-ENV | http://schemas.xmlsoap.org/soap/envelope | 
 | SOAP-ENC | http://schemas.xmlsoap.org/soap/encoding | 
 | Xsi | http://www.w3.org/1999/XMLSchema-instance | 
 | Xsd | http://www.w3.org/1999/XMLSchema | 

Tabela. Namespaces / URI padr�es do SOAP

De acordo com o W3Schools, a estrutura da mensagem SOAP � definida em um documento XML que cont�m os seguintes elementos:

...
<SOAP-ENV:envelope>
<!� Elemento raiz do SOAP e define que essa � uma mensagem SOAP-->
<SOAP-ENV:header>
<!�Especifica informa��es especificas como autentica��o (opcional)-->
</SOAP-ENV:header>
<SOAP-ENV:body>
<!�O elemento BODY cont�m o corpo da mensagem-->
<SOAP-ENV:fault>
<!�O elemento FAULT cont�m os erros que podem ocorrer-->
</SOAP-ENV:fault>
</SOAP-ENV:body>
</SOAP-ENV:envelope>
...

Envelope (obrigat�rio): � respons�vel por definir o conte�do da mensagem;
- encodingStyle: atributo que tem como objetivo especificar como as informa��es devem ser codificadas.
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
...
</SOAP-ENV:Header>
<SOAP-ENV:Body>
�
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
Header (opcional): cont�m os dados do cabe�alho;
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
</SOAP-ENV:Header>
<SOAP-ENV:Body>
�
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
---

- actor: especifica o receptor que deve processar o elemento do cabe�alho.
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�
SOAP- ENV:actor=�http://www.mauricioreckziegel.com/soap/authenticator�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
- musUnderstand: especifica se uma entrada de cabe�alho � obrigat�ria ou opcional (booleano).
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=�http://schemas.xmlsoap.org/soap/envelope/�
SOAP-ENV:encodingStyle=�http://schemas.xmlsoap.org/soap/encoding/�>
<SOAP-ENV:Header>
<a:authentication xmlns:a=�http://www.mauricioreckziegel.com/soap/authentication�
SOAP-ENV:mustUndestrand=�1�>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---

. Body (obrigat�rio): cont�m a codifica��o atual de uma chamada a um m�todo e todos os argumentos de entrada ou uma resposta codificada que cont�m o resultado de uma chamada de um m�todo.
. Fault: cont�m as informa��es dos erros ocorridos no envio da mensagem. Apenas nas mensagens de resposta do servidor.

O envelope SOAP � a parte obrigat�ria de uma mensagem SOAP. Ele funciona como um recipiente de todos os outros elementos da mensagem, possivelmente o cabe�alho e o corpo, assim como os namespaces de cada um. Assim como o nome e o endere�o de uma carta entregue pelo correio, o envelope SOAP precisa das informa��es espec�ficas do protocolo de transporte que est� ligado a ele, com o intuito de garantir a chegada ao local certo. Especificamente no HTTP, temos um cabe�alho que se chama SOAPAction, indicador do endere�o de entrega da mensagem. Um dos principais motivos de implementarmos o cabe�alho desta maneira � porque administradores de sistemas podem configurar seus firewalls para filtrar as mensagens baseadas nas informa��es dos cabe�alhos, sem consultar o XML.

 | Elemento | Namespace / URI | 
 | Envelope | http://schemas.xmlsoap.org/soap/envelope | 
 | Serializador | http://schemas.xmlsoap.org/soap/encoding | 
 | SOAP-ENV | http://schemas.xmlsoap.org/soap/envelope | 
 | SOAP-ENC | http://schemas.xmlsoap.org/soap/encoding | 
 | Xsi | http://www.w3.org/1999/XMLSchema-instance | 
 | Xsd | http://www.w3.org/1999/XMLSchema | 

Tabela. Namespaces / URI padr�es do SOAP

## 4. RPC (Remote Procedure Call)

Entre outras utiliza��es, SOAP foi desenhado para encapsular e transportar chamadas de RPC, e para isto utiliza-se dos recursos e flexibilidade do XML, sob HTTP.

RPCs ou chamadas remotas de procedimento, s�o chamadas locais a m�todos de objetos (ou servi�os) remotos. Portanto, podemos acessar os servi�os de um objeto localizado em um outro ponto da rede, atrav�s de uma chamada local a este objeto. Cada chamada ou requisi��o exige uma resposta.

Processo de uma chamada RPC: Antes de serem enviadas pela rede, as chamadas de RPC (emitidas pela aplica��o cliente) s�o encapsuladas (ou serializadas) segundo o padr�o SOAP. O servi�o remoto, ao receber a mensagem faz o processo contr�rio, desencapsulando-a e extraindo as chamadas de m�todo. A aplica��o servidora ent�o processa esta chamada, e envia uma resposta ao cliente. O processo ent�o se repete: a resposta � tamb�m serializada e enviada pela rede. Na m�quina cliente, esta resposta � desencapsulada e � repassada para a aplica��o cliente.

## 5. Web Service Description Language (WSDL)

### Documento WSDL

De que forma um cliente de um Web Service sabe qual formato dos m�todos a serem chamados e quais par�metros a serem passados? Como cliente e servi�o sabem como processar uma requisi��o?

Para solucionar estes tipos de perguntas foi criado um documento, que utiliza uma linguagem chamada WSDL. WSDL ou Web Service Description Language � uma linguagem baseada em XML, utilizada para descrever um Web Service. Um Web Service deve, portanto, definir todas as suas interfaces, opera��es, esquemas de codifica��o, entre outros neste documento.

Um documento WSDL define um XML Schema para descrever um Web Service.

T�o logo o cliente tenha acesso � descri��o do servi�o a ser utilizado, a implementa��o do Web Service pode ser feita em qualquer linguagem de programa��o. Normalmente s�o utilizadas linguagem constru�das para intera��o com a WEB, como por exemplo Java Servlets ou ASP, que, em seguida, chamam um outro programa ou objeto.

Basicamente, quando o cliente deseja enviar uma mensagem para um determinado Web Service, ele obt�m a descri��o do servi�o (atrav�s da localiza��o do respectivo documento WSDL), e em seguida constr�i a mensagem, passando todos os parametros de acordo com a defini��o encontrada no documento. Em seguida, a mensagem � enviada para o endere�o onde o servi�o est� localizado, a fim de que possa ser processada. O Web Service, quando recebe esta mensagem valida-a conforme as informa��es contidas no documento WSDL. � partir de ent�o, o servi�o remoto sabe como tratar a mensagem, sabe como process�-la (possivelmente enviando-a para outro programa) e como montar a resposta ao cliente.

## 6. Exemplos

#### SOAP sobre HTTP (POST) (Pedido)

...
POST /StockQuote HTTP/1.1
Host: www.stockquoteserver.com
Content-Type: text/xml; charset="utf-8"
Content-Length: nnnn
SOAPAction: "Some-URI"
<SOAP-ENV:Envelope
xmlns:SOAP- ENV="http://schemas.xmlsoap.org/soap/envelope/�
SOAP- ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">
<SOAP-ENV:Body>
<m:GetLastTradePrice xmlns:m="Some-URI">
<symbol>DIS</symbol>
</m:GetLastTradePrice>
</SOAP-ENV:Body>

</SOAP-ENV:Envelope>
...

#### SOAP sobre HTTP (Resposta)

...
HTTP/1.1 200 OK
Content-Type: text/xml; charset="utf-8"
Content-Length: nnnn
<SOAP-ENV:Envelope
xmlns:SOAP- ENV="http://schemas.xmlsoap.org/soap/envelope/�
SOAP- ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
<SOAP-ENV:Body>
<m:GetLastTradePriceResponse xmlns:m="Some-URI">
<Price>34.5</Price>
</m:GetLastTradePriceResponse>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
...

## 7. SOAP em HTTP

SOAP em HTTP

O SOAP teoricamente atua sobre qualquer protocolo de transporte, mas, sem d�vida nenhuma o http � o protocolo mais utilizado para a utiliza��o de Web Services. Atrav�s do comando Post do HTTP � poss�vel o envio das mensagens SOAP, utilizando-se da URI requisitora que especifica um destino ID. No cabe�alho do http, tamb�m temos um campo com o nome do m�todo a ser chamado.

...
POST /rpcrouter HTTP/1.1
Host: 127.0.0.1
Content-Type: text/xml; charset=utf-8
Content-Length: 559
SOAPAction: �http://mauricio.com�
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope
xmlns:xsi="Schema-Instance"
xmlns:xsd="Schema"
xmlns:soap="Envelope">
<soap:Body>
<Converte xmlns="http://conv.com.br">
<Valor>5</Valor>
<De>DEC</De>
<Para>BIN</Para>
</Converte>
</soap:Body>
</soap:Envelope>
...

Atrav�s do HTTP Response � que obtemos uma resposta da solicita��o SOAP. Note que alguns itens j� n�o s�o mais necess�rios.

...
HTTP/1.1 200 OK
Content-Type: text/xml; charset=utf-8
Content-Length: length
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope
xmlns:xsi="Schema-Instance"
xmlns:xsd="Schema"
xmlns:soap="Envelope">
<soap:Body>
<ConverteResponse xmlns="http://mauricio.com">
<ValorResult>101</ValorResult>
</ConverteResponse>
</soap:Body>
</soap:Envelope>
...
