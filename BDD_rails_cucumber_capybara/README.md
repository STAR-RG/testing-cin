# BDD - IF1009

Preparação do ambiente Rails, cucumber e capybara utilizando Vagrant

### Setup

1 - Instalar o VirtualBox - https://www.virtualbox.org/wiki/Downloads

2 - Instalar o Vagrant - https://www.vagrantup.com/downloads.html

3 - Instalar o plugin para convidado do VirtuaBox para o Vagrant, que permite a divisão de dados entre host e VM

```
vagrant plugin install vagrant-vbguest
```

### Instale a maquina virtual


4.Dentro do diretório meu_projeto_teste usar o comando:

```
vagrant up
```

4.1 - Esse comando cria e configura máquinas convidadas de acordo com o arquivo Vagrantfile

4.2 - OBS: Nas ultimas 7 linhas de saída do comando haverá a informação do
endereço e da porta, que por padrão é 127.0.0.1 e 2222
respectivamente. Essa informação é importante para conexão ssh no Windows

## Conectando ao servidor

5 - Para acessar a máquina virtual pelo Linux e Mac usar o comando:
```
vagrant ssh rails
```

5.1 - Esse comando de conexão pode ser utilizado a partir de qualquer
diretório, pois após a instalação o comando vagrant será adicionado ao
seu PATH para uso no terminal.  Os parâmetros do comando incluem o
nome da máquina caso você esteja rodando mais de uma.  O nome da nossa
é rails, mas assumindo que só temos a nossa rodando o comando acessará
ela por default.

5.2 - No Windows siga as instruções em: Conexão para Windows

### Configurando o Rails

Após isso, no console do PUTTy, ou do Linux/Mac você estará dentro da VM (/vagrant):

6 - Utilizar comando:
```
gem install rails
```

7 - Use o comando:
```
ls 
```
para visualizar o diretorio do app.

8 - Use o comando:
```
cd bdd_teste_app 
```
para entrar no diretório da aplicação (/vagrant/bdd_teste_app).

9 - Utilizar comando:
```
bundle install
```
Para instalar as gems necessárias.

##Rodando os Testes

Para rodar o app utilize o comando: `rails server -b 0.0.0.0` 
E veja, no seu browser, como está a página em 127.0.0.0:3000
Para parar use o comando: `Ctrl + c`

10 - Vá para a pasta features
11 - Crie um arquivo chamado Hello.feature na pasta features

11.1 - Dentro do arquivo, adicionar o conteudo:
    
    Feature: Hello Message     # a parte da feature apenas informa que tipo
    As a enterprise            # de caracteristicas é desejavel
    In order to say Something
    I want to the the Hello message


    # o Scenario é o local onde vai ser definido as informações
    # macro. "O que acontecer, quando apertar aquele botão"
    # "O que esperar quando estiver nessa ou naquela página"
    # São coisas que o scenario vai estar utilizando
    # Definindo com os parametros When, Given, Then e And
    
    Scenario:
        Given I'm in homepage
        Then I want to see the message "Hello to this page"
        
11.2 - Salve o arquivo. 
Volte para o diretório /bdd_teste_app e digite o comando: `cucumber features/hello.feature` e verificar os passos
        que podem ser utilizados no step_definitions.
        
12 - Crie um arquivo chamado Hello_step.rb na pasta features/step_definitions
    12.1 - Dentro do arquivo, adicionar o conteudo:
    
    # Aqui podemos fazer realmente o passo a passo que dissemos no 
    # scenario da feature: iremos dizer o que deve acontecer de acordo
    # com a frase dita. "I'm in homepage" por exemplo, você quer estar
    # na Página Principal, home, e então você adiciona o comando
    # visit(root_path) <- visite a rota raiz (que é a home page)
    # depois no outro comando, page.has_content?(arg1) <- teste se
    # a mensagem passada por parametro no scenario está na home page.
    
        When(/^I'm in homepage$/) do
            visit(root_path)
        end


        Given(/^I want to see the message "([^"]*)"$/) do |arg1|
            assert page.has_content?(arg1)
        end
    
12.2 - Volte para o diretório /bdd_teste_app e digite no terminal: `cucumber features/hello.feature` e verificar os passos
que podem ser utilizados no step_definitions.


13 - Vá para o arquivo app/views/static_pages/home.html.erb
    13.1 - Substitua o conteúdo, "Welcome to the Sample App" , da tag `<h1></h1>` por "Hello to this page"
   
    
14 - Para rodar o app, e ver o resultado, utilize o comando: `rails server -b 0.0.0.0` 

E veja, no seu browser, como está a página em 127.0.0.0:3000

Para parar o app use o comando: `Ctrl + c`




As instruções para construção de testes mais detalhadas encontram-se no arquivo
Execucao_da_Demo.txt



## Encerrando a prática

15 - Para desligar a máquina: `vagrant halt rails`
16 - Para religar a máquina: `vagrant reload rails`
17 - Para excluir a máquina totalmente : `vagrant destroy rails`

### Extras

BDD on Rails

Documentação Vagrant: https://www.vagrantup.com/docs/
Primeiros passos Rails: guides.rubyonrails.org/getting_started.html

