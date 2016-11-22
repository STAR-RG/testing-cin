# BDD - IF1009

Preparação do ambiente Rails, cucumber e capybara utilizando Vagrant

### Pré-requisitos

1 - Instalar o VirtualBox - https://www.virtualbox.org/wiki/Downloads

2 - Instalar o Vagrant - https://www.vagrantup.com/downloads.html

3 - Instalar o plugin para convidado do VirtuaBox para o Vagrant, que permite a divisão de dados entre host e VM

```
vagrant plugin install vagrant-vbguest
```

### Instalando


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

5.1 - Esse comando de conexão pode ser utilizado a partir de qualquer diretório, 
pois após a instalação o comando vagrant será adicionado ao seu PATH para uso no terminal.
Os parâmetros do comando incluem o nome da máquina caso você esteja rodando mais de uma.
O nome da nossa é rails, mas assumindo que só temos a nossa rodando o comando acessará ela por default.

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

9 - Utiizar comando:
```
bundle install
```
Para instalar as gems necessárias.

##Rodando os Testes

10 - As instruções para construção dos testes se encontram em Execução da Demo

## Encerrando a prática

11 - Para desligar a máquina: `vagrant halt rails`

12 - Para excluir a máquina totalmente : `vagrant destroy rails`

### Extras

BDD on Rails

Documentação Vagrant: https://www.vagrantup.com/docs/
Primeiros passos Rails: guides.rubyonrails.org/getting_started.html

