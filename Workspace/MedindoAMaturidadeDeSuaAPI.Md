# Medindo a Maturidade de sua API 
##### Bruno Brito

## Richardson Maturity Model

Leonard Richardson fez uma analise em centenas de API's diferentes. E dividiu em quatro categorias para identificar o n�vel de maturidade da API com base no quanto eles s�o compat�veis com REST. Esse modelo � chamado de Richardson Maturity Model.

Ele utilizou tr�s fatores. URI, HTTP Methods e HATEOAS (Hypermedia). Quanto mais um servi�o emprega esses conceitos, mais maduro ele deve ser considerado.

### As categorias que ele utilizou foram:

- Level Zero Services
- Level One Services
- Level Two Services
- Level Three Services

Sendo que o nivel 3 � considerado o suprasumo das API's.

#### Level Zero Services

O n�vel zero de maturidade n�o utiliza recursos de URI, HTTP Methods e HATEOAS.

A API t�m um �nico URI e usa um �nico m�todo HTTP (normalmente POST). Um exemplo s�o os Antigos WebServices do ASP.NET (ASMX).

####  Level One Services

O n�vel um de maturidade j� considera a utiliza��o eficiente de URIs. Os recursos s�o mapeados, mas ainda n�o emprega o uso eficiente dos verbos. Geralmente utilizam apenas GET e POST.

Em minha experi�ncia diria que a maioria das API's atualmente est�o nesse nivel de maturidade.

#### Level Two Services

O n�vel dois de maturidade faz o uso eficiente de URIs e verbos HTTP.

Nos n�veis anteriores o protocolo HTTP estava sendo usado superficialmente. O n�vel dois come�a a separar os adultos das crian�as. Nesse n�vel as API's come�am a se aproximar do que o RESTFul espera.


##### Verbos HTTP

A API suporta os diversos verbos HTTP:

- POST - Criar
- GET - Ler
- PUT - Atualizar
- DELETE - Excluir
- PATCH - Atualizar parcialmente

#### Level Three Services

O n�vel tr�s de maturidade faz o uso eficiente dos tr�s fatores. URIs, HTTP e HATEOAS.

O objetivo dos controles hiperm�dia � que eles nos digam o que podemos fazer a seguir e o URI do recurso que precisamos manipular para faz�-lo.

Esse � o n�vel mais maduro do modelo de Richardson. A API come�a a guiar as pr�ximas a��es atrav�s do response. Os consumidores da API podem faze uma trilha nos resources.

## Conclus�o

Apesar de achar que atualmente HATEOAS � impr�ticavel, esse � um modelo de classifica��o.

Esse modelo ser guia para times que buscam melhorar o ecossistema interno da empresa. Essa classifica��o pode ajudar a definir um norte em um processo de melhoria cont�nua.

Refer�ncias
Richardson Maturity Model - Martin Fowler
REST in Practice: Hypermedia and Systems Architecture

[Artigo Original](https://www.brunobrito.net.br/richardson-maturity-model/)