Neste exemplo queremos demonstrar o teste de performance utilizando um banco de dados.

o Banco usado foi encontrado no seguinte endereço:
[https://chinookdatabase.codeplex.com/releases/view/55681](https://chinookdatabase.codeplex.com/releases/view/55681)

Usando o MySQL. O script também pode ser encontrado nesse repositório.

A árvore de componentes do exemplo do JDBC ficou dessa maneira:
![](http://i.imgur.com/5VghANz.png)

Nela precisamos configurar o grupo de usuários:

* Número de usuários virtuais: **10**
* Tempo de inicialização: **1**
* Contador de iteração: **2**

Precisamos configurar a conexão com o banco de dados:

![](http://i.imgur.com/flqR39U.png)
**Obs**: é necessário adicionar o conector JDBC .jar do banco de dados utilizado, no exemplo utilizamos o banco de dados MySql , na pasta /lib do JMeter.

A requisição JDBC é onde falamos qual database a tabela está sendo utilizada e a consulta utilizada. 
![](http://i.imgur.com/AxzNyxy.png)

No ouvinte, utilizamos a árvore de resultados onde aparece cada requisição no banco de dados e o resultado de cada requisição
![](http://i.imgur.com/YCtXBNc.png)

![](http://i.imgur.com/RADQD50.png)

![](http://i.imgur.com/suRWj9s.png)


