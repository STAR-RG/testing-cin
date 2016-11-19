Esse cenário é para mostrar a capacidade do JMeter em gravar as ações do usuário e fazer com que outras centenas de usuários façam o mesmo cenário.

A primeira coisa que devemos adicionar na nossa área de trabalho é um “Elemento que não é de teste >> Servidor HTTP Proxy”  

![](http://i.imgur.com/6HnpN2D.png)

lá definiremos:
* porta do nosso servidor: 8080
* nosso grupo de usuários
* padrões de URL a serem excluídos: .* \css, .* \ico, .* \json, .* \png, .* \js

E com isso podemos iniciar nosso proxy.

![](http://i.imgur.com/g53pp9e.png)

Definimos o número de usuários no Grupo de Usuários (Thread Group). No exemplo usamos:
* Número de usuários Virtuais: 10
* Tempo de inicialização: 1
* Contador de iteração: 1

Para utiliza-lo, precisamos configurar nosso browser(Firefox) para que ele utilize a porta 8080.

![](http://i.imgur.com/vhqqNLD.png)

com o proxy ligado, podemos iniciar a gravação das requisições, para isso é só entrar em qualquer site, no exemplo acessamos o site [https://openweathermap.org/](https://openweathermap.org/) e pesquisamos por “Recife”, ao voltar para o JMeter vemos que todos os passos foram gravados e ao rodar o teste cada usuário roda a gravação.

![](http://i.imgur.com/ZQfxBom.png)

![](http://i.imgur.com/pdyLnFo.png)

![](http://i.imgur.com/1Rw5w5t.png)

![](http://i.imgur.com/oXXNMzU.png)
