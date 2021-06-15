# Medindo a Maturidade de sua API 
##### Bruno Brito

## Richardson Maturity Model

Leonard Richardson fez uma analise em centenas de API's diferentes. E dividiu em quatro categorias para identificar o nível de maturidade da API com base no quanto eles são compatíveis com REST. Esse modelo é chamado de Richardson Maturity Model.

Ele utilizou três fatores. URI, HTTP Methods e HATEOAS (Hypermedia). Quanto mais um serviço emprega esses conceitos, mais maduro ele deve ser considerado.

### As categorias que ele utilizou foram:

- Level Zero Services
- Level One Services
- Level Two Services
- Level Three Services

Sendo que o nivel 3 é considerado o suprasumo das API's.

#### Level Zero Services

O nível zero de maturidade não utiliza recursos de URI, HTTP Methods e HATEOAS.

A API têm um único URI e usa um único método HTTP (normalmente POST). Um exemplo são os Antigos WebServices do ASP.NET (ASMX).

####  Level One Services

O nível um de maturidade já considera a utilização eficiente de URIs. Os recursos são mapeados, mas ainda não emprega o uso eficiente dos verbos. Geralmente utilizam apenas GET e POST.

Em minha experiência diria que a maioria das API's atualmente estão nesse nivel de maturidade.

#### Level Two Services

O nível dois de maturidade faz o uso eficiente de URIs e verbos HTTP.

Nos níveis anteriores o protocolo HTTP estava sendo usado superficialmente. O nível dois começa a separar os adultos das crianças. Nesse nível as API's começam a se aproximar do que o RESTFul espera.


##### Verbos HTTP

A API suporta os diversos verbos HTTP:

- POST - Criar
- GET - Ler
- PUT - Atualizar
- DELETE - Excluir
- PATCH - Atualizar parcialmente

#### Level Three Services

O nível três de maturidade faz o uso eficiente dos três fatores. URIs, HTTP e HATEOAS.

O objetivo dos controles hipermídia é que eles nos digam o que podemos fazer a seguir e o URI do recurso que precisamos manipular para fazê-lo.

Esse é o nível mais maduro do modelo de Richardson. A API começa a guiar as próximas ações através do response. Os consumidores da API podem faze uma trilha nos resources.

## Conclusão

Apesar de achar que atualmente HATEOAS é impráticavel, esse é um modelo de classificação.

Esse modelo ser guia para times que buscam melhorar o ecossistema interno da empresa. Essa classificação pode ajudar a definir um norte em um processo de melhoria contínua.

Referências
Richardson Maturity Model - Martin Fowler
REST in Practice: Hypermedia and Systems Architecture

[Artigo Original](https://www.brunobrito.net.br/richardson-maturity-model/)