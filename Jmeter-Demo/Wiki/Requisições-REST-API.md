Nós podemos executar testes de performance em serviços web SOPA / REST usando JMeter.  Serviços web REST usam o método de solicitação HTTP com a maioria dos protocolos populares como: GET e POST. 

Neste exemplo vamos usar  a API OpenWeather Map para fazer o teste.

[http://openweathermap.org/api](http://openweathermap.org/api)

Nesse exemplo vamos fazer uma chamada para a API com o tempo atual, para a cidade de de Recife. 

[http://openweathermap.org/current](http://openweathermap.org/current)

um exemplo seria:
http://api.openweathermap.org/data/2.5/weather?q=Recife,br&appid= [SUA API KEY]

O **appID**  é gerado uma vez que é feito cadastro no site do Open Weather Map.

Para o teste, primeiro definimos o número de usuários no Grupo de Usuários (Thread Group). No exemplo usamos:

* Número de usuários Virtuais: 500
* Tempo de inicialização: 2
* Contador de iteração: 3

![](http://i.imgur.com/MxIDtnq.png)

Iremos adicionar um Request HTTP no Grupo de Usuários (Adicionar> Testador > Requisição HTTP)

* Nome do servidor: api.openweathermap.org
* Caminho: /data/2.5/weather
* Método: GET

E os Parâmetros da requisição:

![](http://i.imgur.com/q8Gqyhm.png)

Para verificar se o retornado está correto, colocamos uma Asserção de Resposta, com o Valor Recife (do parâmetro).
![](http://i.imgur.com/MnOL6hj.png)

E dois ouvintes, um como Tabela e outro como Árvore de Resultados, assim conseguimos ver o tempo médio, além de dados de resposta, etc.

![](http://i.imgur.com/LPsoJ9A.png)

![](http://i.imgur.com/2gOwVN9.png)