Vamos simular um case onde cinco usuários acessam o sistema do “g1.globo.com” 

A primeira coisa que precisamos entender é a árvore de componentes que fica ao lado esquerdo do JMeter:

![](http://i.imgur.com/qQvkkdC.png)

Nesse exemplo bem básico está sendo composto por um plano de teste que é um elemento único e requerido para qualquer atividade dentro do JMeter. Esse elemento agrupa todos os outros elementos e controla a execução do grupo de usuários.

O Grupo de usuários é onde podemos configurar todos os comandos de teste, é nele que definimos também o número de usuários participantes do grupo, o tempo de execução e a quantidade de vezes cada usuário vai executar cada requisição.
Na imagem abaixo existe um grupo de cinco usuários, cada um fazendo duas requisições no intervalo de 1 segundo.
![](http://i.imgur.com/oK5Zj2D.png)

Dentro do grupo de usuários contém as ações do grupo, no exemplo definimos um padrão que foi onde colocamos o servidor que estamos acessando, no caso a “g1.globo.com”.
![](http://i.imgur.com/hz6vMyc.png)

Logo em seguida colocamos as requisições, no caso colocamos uma requisição para o index e outra para a página da educação.
![](http://i.imgur.com/BZ8fhk4.png)

![](http://i.imgur.com/N7slU8U.png)

Para poder ver o resultado adicionamos um ouvinte(Listener) onde podemos observar a ação de cada usuário. No cenário cada usuário(cinco usuários) entrou pelo menos duas vez em cada página(index e educação), no total foram executados 20 requisições. Na tabela podemos observar a latência e o tempo de conexão, o estado, a quantidade de bytes utilizados, etc.

Para executar esse cenário: Executar > Iniciar
Para limpar os resultados: Executar > “Limpar Tudo”

***

![](http://i.imgur.com/UugJXwD.png)
***

***
