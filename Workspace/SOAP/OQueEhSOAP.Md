# SOAP

## Simple Object Access Protocol (SOAP)

### Indice:

[1 – Definição](## 1. Definição)
[2 – SOAP e Web Services](## 2. SOAP e Web Services)
[3 – Estrutura do Protocolo](## 3. Estrutura do protocolo)
[4 – Remote Procedure Call (RPC)](## 4. RPC- Remote Procedure Call)
[5 – Web Service Description Language (WSDL)](## 5. Web Service Description Language)
[6 – Exemplos](## 6. – Exemplos)
[7 - SOAP em HTTP](## 7. SOAP em HTTP)

## 1. Definição
SOAP é um protocolo baseado em XML para troca de informações em um ambiente distribuido.

É utilizado para troca de mensagens entre aplicativos distribuidos pela rede.

Estes aplicativos, ou “Web services”, possuem uma interface de acesso simples e bem definida.

Os Web services são componentes que permitem às aplicações enviar e receber dados em formato XML Cada aplicação pode ter a sua própria "linguagem", que é traduzida para uma linguagem universal, o formato XML.

## 2. SOAP e Web Services

Web Services são usados para disponibilizar serviços interativos na WEB, podendo ser acessados por outras aplicações. SOAP (Simple Object Access Protocol) está se tornando padrão para a troca de mensagens entre aplicações e Web Services, já que é uma tecnologia construída com base em XML e HTTP.

As aplicações atuais se comunicam usando Chamadas Remotas de Procedimento (RPC) entre objetos como DCOM e CORBA, mas HTTP não foi projetado para isso. RPC representa tanto um problema de compatibilidade como de segurança. Firewall’s e servidores proxy irão normalmente bloquear este tipo de tráfego.

Uma melhor forma para a comunicação entre aplicações é fazendo-se através do protocolo HTTP. Este é protocolo "standard" em todos os navegadores e servidores de internet. SOAP foi criado para que este tipo de comunicação se tornasse possível.

SOAP é um procolo projetado para invocar aplicações remotas através de RPC ou trocas de mensagens, em um ambiente independente de plataforma e linguagem de programação. SOAP é, portanto, um padrão normalmente aceito para utilizar-se com Web Services. Desta forma, pretende-se garantir a interoperabilidade e intercomunicação entre diferentes sistemas, através da utilização de uma linguagem (XML) e mecanismo de transporte (HTTP) padrões.

Concluindo, o SOAP é o elemento principal da infra-estrutura dos Web Services e um fator fundamental para o funcionamento dos mesmos, independente de plataformas, sistemas operacionais, modelos de objetos e linguagens de programação, auxiliando muito a interoperabilidade entre objetos e componentes distribuídos. Este tem um papel muito importante e acaba com a disputa entre linguagens, garantindo que o programador possa desenvolver no ambiente que seja mais adequado às suas necessidades. Além de todas essas qualidades, o fato também de não ser preciso o seu conhecimento para sua utilização fazem do SOAP uma excelente escolha para o desenvolvimento de Web Services.

O fato de não ser preciso o seu conhecimento para a manipulação dos Web Services facilita a vida de qualquer programador. Visto que a maioria das linguagens já trazem classes implementadas deste protocolo, facilitando ainda mais a sua utilização.

## 3. Estrutura do protocolo

- **Envelope:** Toda mensagem SOAP deve contê- lo. É o elemento raiz do documento XML. O Envelope pode conter declarações de namespaces e também atributos adicionais como o que define o estilo de codificação (encoding style).Um "encoding style" define como os dados são representados no documento XML.
- **Header:** É um cabeçalho opcional. Ele carrega informações adicionais, como por exemplo, se a mensagem deve ser processada por um determinado nó intermediário (É importante lembrar que, ao trafegar pela rede, a mensagem normalmente passa por diversos pontos intermediários, até alcançar o destino final). Quando utilizado, o Header deve ser o primeiro elemento do Envelope.
- **Body:** Este elemento é obrigatório e contém o payload, ou a informação a ser transportada para o seu destino final. O elemento Body pode conter um elemento opcional Fault, usado para carregar mensagens de status e erros retornadas pelos "nós" ao processarem a mensagem.

De acordo com o W3Schools, a estrutura da mensagem SOAP é definida em um documento XML que contém os seguintes elementos:

...
<SOAP-ENV:envelope>
<!— Elemento raiz do SOAP e define que essa é uma mensagem SOAP-->
<SOAP-ENV:header>
<!—Especifica informações especificas como autenticação (opcional)-->
</SOAP-ENV:header>
<SOAP-ENV:body>
<!—O elemento BODY contém o corpo da mensagem-->
<SOAP-ENV:fault>
<!—O elemento FAULT contém os erros que podem ocorrer-->
</SOAP-ENV:fault>
</SOAP-ENV:body>
</SOAP-ENV:envelope>
...

** Envelope (obrigatório):** é responsável por definir o conteúdo da mensagem;

- encodingStyle: atributo que tem como objetivo especificar como as informações devem ser codificadas.

---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
...
</SOAP-ENV:Header>
<SOAP-ENV:Body>
…
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
Header (opcional): contém os dados do cabeçalho;
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
</SOAP-ENV:Header>
<SOAP-ENV:Body>
…
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
- actor: especifica o receptor que deve processar o elemento do cabeçalho.
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”
SOAP- ENV:actor=”http://www.mauricioreckziegel.com/soap/authenticator”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
- musUnderstand: especifica se uma entrada de cabeçalho é obrigatória ou opcional (booleano).
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”
SOAP-ENV:mustUndestrand=”1”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---

. Body (obrigatório): contém a codificação atual de uma chamada a um método e todos os argumentos de entrada ou uma resposta codificada que contém o resultado de uma chamada de um método.
. Fault: contém as informações dos erros ocorridos no envio da mensagem. Apenas nas mensagens de resposta do servidor.

O envelope SOAP é a parte obrigatória de uma mensagem SOAP. Ele funciona como um recipiente de todos os outros elementos da mensagem, possivelmente o cabeçalho e o corpo, assim como os namespaces de cada um. Assim como o nome e o endereço de uma carta entregue pelo correio, o envelope SOAP precisa das informações específicas do protocolo de transporte que está ligado a ele, com o intuito de garantir a chegada ao local certo. Especificamente no HTTP, temos um cabeçalho que se chama SOAPAction, indicador do endereço de entrega da mensagem. Um dos principais motivos de implementarmos o cabeçalho desta maneira é porque administradores de sistemas podem configurar seus firewalls para filtrar as mensagens baseadas nas informações dos cabeçalhos, sem consultar o XML.

 | Elemento | Namespace / URI |
 | Envelope | http://schemas.xmlsoap.org/soap/envelope |
 | Serializador | http://schemas.xmlsoap.org/soap/encoding |
 | SOAP-ENV | http://schemas.xmlsoap.org/soap/envelope |
 | SOAP-ENC | http://schemas.xmlsoap.org/soap/encoding |
 | Xsi | http://www.w3.org/1999/XMLSchema-instance |
 | Xsd | http://www.w3.org/1999/XMLSchema |

### Tabela. Namespaces / URI padrões do SOAP

De acordo com o W3Schools, a estrutura da mensagem SOAP é definida em um documento XML que contém os seguintes elementos:
...
<SOAP-ENV:envelope>
<!— Elemento raiz do SOAP e define que essa é uma mensagem SOAP-->
<SOAP-ENV:header>
<!—Especifica informações especificas como autenticação (opcional)-->
</SOAP-ENV:header>
<SOAP-ENV:body>
<!—O elemento BODY contém o corpo da mensagem-->
<SOAP-ENV:fault>
<!—O elemento FAULT contém os erros que podem ocorrer-->
</SOAP-ENV:fault>
</SOAP-ENV:body>
</SOAP-ENV:envelope>
...

Envelope (obrigatório): é responsável por definir o conteúdo da mensagem;
- encodingStyle: atributo que tem como objetivo especificar como as informações devem ser codificadas.
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
...
</SOAP-ENV:Header>
<SOAP-ENV:Body>
…
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
---

Header (opcional): contém os dados do cabeçalho;
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
</SOAP-ENV:Header>
<SOAP-ENV:Body>
…
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
- actor: especifica o receptor que deve processar o elemento do cabeçalho.
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”
SOAP- ENV:actor=”http://www.mauricioreckziegel.com/soap/authenticator”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
- musUnderstand: especifica se uma entrada de cabeçalho é obrigatória ou opcional (booleano).
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”
SOAP-ENV:mustUndestrand=”1”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
. Body (obrigatório): contém a codificação atual de uma chamada a um método e todos os argumentos de entrada ou uma resposta codificada que contém o resultado de uma chamada de um método.
. Fault: contém as informações dos erros ocorridos no envio da mensagem. Apenas nas mensagens de resposta do servidor.

O envelope SOAP é a parte obrigatória de uma mensagem SOAP. Ele funciona como um recipiente de todos os outros elementos da mensagem, possivelmente o cabeçalho e o corpo, assim como os namespaces de cada um. Assim como o nome e o endereço de uma carta entregue pelo correio, o envelope SOAP precisa das informações específicas do protocolo de transporte que está ligado a ele, com o intuito de garantir a chegada ao local certo. Especificamente no HTTP, temos um cabeçalho que se chama SOAPAction, indicador do endereço de entrega da mensagem. Um dos principais motivos de implementarmos o cabeçalho desta maneira é porque administradores de sistemas podem configurar seus firewalls para filtrar as mensagens baseadas nas informações dos cabeçalhos, sem consultar o XML.

 | Elemento | Namespace / URI | 
 | Envelope | http://schemas.xmlsoap.org/soap/envelope | 
 | Serializador | http://schemas.xmlsoap.org/soap/encoding | 
 | SOAP-ENV | http://schemas.xmlsoap.org/soap/envelope | 
 | SOAP-ENC | http://schemas.xmlsoap.org/soap/encoding | 
 | Xsi | http://www.w3.org/1999/XMLSchema-instance | 
 | Xsd | http://www.w3.org/1999/XMLSchema | 

Tabela. Namespaces / URI padrões do SOAP

De acordo com o W3Schools, a estrutura da mensagem SOAP é definida em um documento XML que contém os seguintes elementos:

...
<SOAP-ENV:envelope>
<!— Elemento raiz do SOAP e define que essa é uma mensagem SOAP-->
<SOAP-ENV:header>
<!—Especifica informações especificas como autenticação (opcional)-->
</SOAP-ENV:header>
<SOAP-ENV:body>
<!—O elemento BODY contém o corpo da mensagem-->
<SOAP-ENV:fault>
<!—O elemento FAULT contém os erros que podem ocorrer-->
</SOAP-ENV:fault>
</SOAP-ENV:body>
</SOAP-ENV:envelope>
...

Envelope (obrigatório): é responsável por definir o conteúdo da mensagem;
- encodingStyle: atributo que tem como objetivo especificar como as informações devem ser codificadas.
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
...
</SOAP-ENV:Header>
<SOAP-ENV:Body>
…
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
Header (opcional): contém os dados do cabeçalho;
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
</SOAP-ENV:Header>
<SOAP-ENV:Body>
…
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
---

- actor: especifica o receptor que deve processar o elemento do cabeçalho.
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”
SOAP- ENV:actor=”http://www.mauricioreckziegel.com/soap/authenticator”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---
- musUnderstand: especifica se uma entrada de cabeçalho é obrigatória ou opcional (booleano).
---
<SOAP-ENV:Envelope xmlns:SOAP ENV=”http://schemas.xmlsoap.org/soap/envelope/”
SOAP-ENV:encodingStyle=”http://schemas.xmlsoap.org/soap/encoding/”>
<SOAP-ENV:Header>
<a:authentication xmlns:a=”http://www.mauricioreckziegel.com/soap/authentication”
SOAP-ENV:mustUndestrand=”1”>
<a:username>Mauricio</a:username>
<a:password>Reckziegel</a:password>
</a:authentication>
---

. Body (obrigatório): contém a codificação atual de uma chamada a um método e todos os argumentos de entrada ou uma resposta codificada que contém o resultado de uma chamada de um método.
. Fault: contém as informações dos erros ocorridos no envio da mensagem. Apenas nas mensagens de resposta do servidor.

O envelope SOAP é a parte obrigatória de uma mensagem SOAP. Ele funciona como um recipiente de todos os outros elementos da mensagem, possivelmente o cabeçalho e o corpo, assim como os namespaces de cada um. Assim como o nome e o endereço de uma carta entregue pelo correio, o envelope SOAP precisa das informações específicas do protocolo de transporte que está ligado a ele, com o intuito de garantir a chegada ao local certo. Especificamente no HTTP, temos um cabeçalho que se chama SOAPAction, indicador do endereço de entrega da mensagem. Um dos principais motivos de implementarmos o cabeçalho desta maneira é porque administradores de sistemas podem configurar seus firewalls para filtrar as mensagens baseadas nas informações dos cabeçalhos, sem consultar o XML.

 | Elemento | Namespace / URI | 
 | Envelope | http://schemas.xmlsoap.org/soap/envelope | 
 | Serializador | http://schemas.xmlsoap.org/soap/encoding | 
 | SOAP-ENV | http://schemas.xmlsoap.org/soap/envelope | 
 | SOAP-ENC | http://schemas.xmlsoap.org/soap/encoding | 
 | Xsi | http://www.w3.org/1999/XMLSchema-instance | 
 | Xsd | http://www.w3.org/1999/XMLSchema | 

Tabela. Namespaces / URI padrões do SOAP

## 4. RPC (Remote Procedure Call)

Entre outras utilizações, SOAP foi desenhado para encapsular e transportar chamadas de RPC, e para isto utiliza-se dos recursos e flexibilidade do XML, sob HTTP.

RPCs ou chamadas remotas de procedimento, são chamadas locais a métodos de objetos (ou serviços) remotos. Portanto, podemos acessar os serviços de um objeto localizado em um outro ponto da rede, através de uma chamada local a este objeto. Cada chamada ou requisição exige uma resposta.

Processo de uma chamada RPC: Antes de serem enviadas pela rede, as chamadas de RPC (emitidas pela aplicação cliente) são encapsuladas (ou serializadas) segundo o padrão SOAP. O serviço remoto, ao receber a mensagem faz o processo contrário, desencapsulando-a e extraindo as chamadas de método. A aplicação servidora então processa esta chamada, e envia uma resposta ao cliente. O processo então se repete: a resposta é também serializada e enviada pela rede. Na máquina cliente, esta resposta é desencapsulada e é repassada para a aplicação cliente.

## 5. Web Service Description Language (WSDL)

### Documento WSDL

De que forma um cliente de um Web Service sabe qual formato dos métodos a serem chamados e quais parâmetros a serem passados? Como cliente e serviço sabem como processar uma requisição?

Para solucionar estes tipos de perguntas foi criado um documento, que utiliza uma linguagem chamada WSDL. WSDL ou Web Service Description Language é uma linguagem baseada em XML, utilizada para descrever um Web Service. Um Web Service deve, portanto, definir todas as suas interfaces, operações, esquemas de codificação, entre outros neste documento.

Um documento WSDL define um XML Schema para descrever um Web Service.

Tão logo o cliente tenha acesso à descrição do serviço a ser utilizado, a implementação do Web Service pode ser feita em qualquer linguagem de programação. Normalmente são utilizadas linguagem construídas para interação com a WEB, como por exemplo Java Servlets ou ASP, que, em seguida, chamam um outro programa ou objeto.

Basicamente, quando o cliente deseja enviar uma mensagem para um determinado Web Service, ele obtém a descrição do serviço (através da localização do respectivo documento WSDL), e em seguida constrói a mensagem, passando todos os parametros de acordo com a definição encontrada no documento. Em seguida, a mensagem é enviada para o endereço onde o serviço está localizado, a fim de que possa ser processada. O Web Service, quando recebe esta mensagem valida-a conforme as informações contidas no documento WSDL. À partir de então, o serviço remoto sabe como tratar a mensagem, sabe como processá-la (possivelmente enviando-a para outro programa) e como montar a resposta ao cliente.

## 6. Exemplos

#### SOAP sobre HTTP (POST) (Pedido)

...
POST /StockQuote HTTP/1.1
Host: www.stockquoteserver.com
Content-Type: text/xml; charset="utf-8"
Content-Length: nnnn
SOAPAction: "Some-URI"
<SOAP-ENV:Envelope
xmlns:SOAP- ENV="http://schemas.xmlsoap.org/soap/envelope/“
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
xmlns:SOAP- ENV="http://schemas.xmlsoap.org/soap/envelope/“
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

O SOAP teoricamente atua sobre qualquer protocolo de transporte, mas, sem dúvida nenhuma o http é o protocolo mais utilizado para a utilização de Web Services. Através do comando Post do HTTP é possível o envio das mensagens SOAP, utilizando-se da URI requisitora que especifica um destino ID. No cabeçalho do http, também temos um campo com o nome do método a ser chamado.

...
POST /rpcrouter HTTP/1.1
Host: 127.0.0.1
Content-Type: text/xml; charset=utf-8
Content-Length: 559
SOAPAction: “http://mauricio.com”
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

Através do HTTP Response é que obtemos uma resposta da solicitação SOAP. Note que alguns itens já não são mais necessários.

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
