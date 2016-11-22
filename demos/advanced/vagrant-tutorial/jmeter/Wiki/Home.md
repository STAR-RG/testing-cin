Welcome to the Jmeter-Demo wiki!

# Elementos do JMeter

Antes de começar a trabalhar com o JMeter, é interessante saber dos elementos que compõem ele em detalhes:

* Plano de Teste (Test Plan)
* Grupo de usuários (Thread Group)
* Controlador Logico (Controllers)
* Ouvintes (Listeners)
* Temporizadores (Timers)
* Elementos de Configuração (Configuration Elements)
* Pré-processadores (Pre-Processor Elements)
*  Pós-processadores (Post-Processor Elements)
* (Execution order of Test Elements)

## Plano de Teste (Test Plan)

Um plano de teste é o corpo de nível superior do JMeter, nele, se explica a sequência de passos a serem executados em tempo de execução. Um plano de teste final é composto por um ou mais grupos de usuários, Testadores(Sampler), controladores lógicos, ouvintes, temporizadores, asserções, e elementos de configuração. Cada Testador pode ser precedido por um ou mais elementos pré-processadores, seguido pelo elemento pós-processador, e / ou elemento de asserção. Ele salva no formato .jmx Java Management Extensions.

![](http://i.imgur.com/MMNspd1.png)

## Grupo de Usuários (Thread Group)

Grupo de Usuários é o estado inicial do plano de teste. O próprio nome, Grupos de Usuários representam um grupo de Threads. Nesse grupo, cada thread simula um requisições de um usuário real para o servidor.

Um controle em um grupo de threads facilita a definição do número de threads em cada grupo. Também é possível controlar o Ramp Up Time e o número de iterações de teste. 

![](http://www.softwaretestingclass.com/wp-content/uploads/2014/02/jmeter-thread-group-1-.png)

##Controladores (Controllers)

Existem dois tipos de controladores: 1) Testadores (Samplers) 2) Controladores Lógicos:

### 1) Testador

Testadores permitem ao JMeter entregar tipos explícitos de solicitações ao servidor. Ele simula uma solicitação do usuário para uma página do servidor alvo. De modo que, para aproveitar funções POST, GET, DELETE em um serviço HTTP, o usuário pode adicionar Requisições HTTP (HTTP Request) por exemplo. Além de solicitação HTTP, há outros 

* HTTP Request
* FTP Request
* JDBC Request
* Java Request
* SOAP/XML Request
* RPC Requests

### 2) Controladores Lógicos

Controladores Lógicos decidem a ordem de processamento dos Testadores em uma Thread. Possuem um mecanismo para controlar o fluxo das Threads. Controladores Lógicos facilitam a personalização da lógica que o JMeter usa para resolver quando enviar solicitações. Controladores Lógicos podem alterar a ordem dos pedidos provenientes de seus elementos filhos.

##Temporizadores

Para executar o teste de carga / stress em aplicações web, se usam threads, controladores e testadores, em seguida, o JMeter só vai enviar a aplicação muitos requests. Este não é o ambiente real ou característico do tráfego. O JMeter envia um pedido sem pausas entre cada teste. Este não é exatamente o que acontece. Podemos adicionar um elemento temporizador que permite definir um período de espera entre cada request.

Assim, para simular o tráfego real ou criar extrema carga / estresse, de forma ordenada, o JMeter oferece elementos temporizadores.

##Ouvintes (Listeners)

Ouvintes facilitam na visualização dos resultados dos Testes na forma de tabelas, gráficos, árvores ou de texto simples em alguns arquivos de log. Ouvintes oferecem um meio de recolher, guardar e exibir os resultados de um plano de teste e armazenar resultados em formato XML, ou uma mais eficiente (mas menos detalhado) em CSV. Sua saídas também podem ser visualizadas diretamente no console JMeter.

Ouvintes de JMeter fornecer muitas coisas,

* Resultados em Gráfico
* Resultados em declaração
* Gravador de Dados simples
* Gráfico agregado
* Relatório Resumido
* Guardar configuração resultado da amostra
* Gráfico resultados completos
* Ver Resultados em Árvore
* Relatório agregado
* Exibir resultados em Tabela

Existem diversas outras funcionalidades na ferramenta.
