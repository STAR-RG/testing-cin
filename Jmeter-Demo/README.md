# Jmeter-Demo
*Projeto da cadeira de testes 2016.2*

Nesse tutorial vamos demonstrar diversos casos de uso de uma das ferramentas de testes de performance e carga mais conhecidos, o Jmeter!

###O que é o Jmeter?

é uma aplicação Java projetado para testar e medir a Performance de aplicações web. Pode ser utilizado como um servidor de benchmarck bem como gerador de carga multiclient.

Algumas features são:

Capacidade de testes de carregar e de performance em diferentes tipode de servidores / protocolos:

* Web - HTTP, HTTPS
* SOAP / REST
* FTP
* Banco de dados via JDBC
* LDAP
* Middleware orientado a mensagem (MOM) via JMS
* Mail - SMTP (S), POP3 (S) e IMAP (S)
* Native commands ou scripts shell
* TCP

### Pre requisitos

A seguir os pré requisitos para rodar os testes do tutorial com o JMeter:

* Java 7 (mínimo) Runtime Environment.
* JDBC

## Instalando

###Para Windows

* Faça o Download da versão mais atual do Jmeter [aqui](http://jmeter.apache.org/download_jmeter.cgi]). 
* Descompactar arquivo numa pasta.
Para rodar o Jmeter
```
jmeter.bat
```

###Para Mac
Caso você tenha o Homebrew vá para o Terminal:

```
brew update
```

```
brew install jmeter --with-plugins
```
e para rodar o Jmeter

```
open /usr/local/bin/jmeter
```

##Testes Realizados

Para ter acesso a cada case, vá para nossa wiki.

* Caso base
* JDBC
* REST API
*
*

##Links importantes
* [Site oficial - Apache Jmeter](jmeter.apache.org)
* [Destilando Jmeter](http://www.bugbang.com.br/destilando-jmeter-i-introducao-e-conceitos/)
* [Tutorials on Point - Jmeter](https://www.tutorialspoint.com/jmeter/jmeter_tutorial.pdf)
* [Jmeter tutorial Series](http://www.softwaretestingclass.com/learn-jmeter-performance-testing-jmeter-tutorial-series/)
* [Ultimate Resoures List](https://www.blazemeter.com/blog/ultimate-jmeter-resource-list)
