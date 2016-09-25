<p><b>Autor: </b>Chrystian Soares<p>

Exercicio realizado para exemplificar a utilização dos scripts selenium (diretamente no codigo de teste), <b>teste feito com o navegador Edge.</b>

<p><b>Ambiente</b></p>
Sistema Operacional: Windows 10<br>
IDE: Eclipse Luna<br>
Java 1.8<br>
Git Bash 1.9.2<br>
Gradle 2.13<br>

<p><b>Passos para rodar a aplicação no Eclipse:</b><p>

1) Clonar o repositório<br/>
git clone https://github.com/chrystianjss/selenium.git<br/>
<br/><br/>
2) Entrar na pasta do projeto<br/>
cd selenium<br/>
<br/><br/>
3) Rodar os comandos:<br/>
./gradlew eclipse<br/>
./gradlew build<br/>
<br/><br/>
4) No eclipse, importar o projeto Import... > Projects from Git, selecionar o projeto em Existing local repository e por fim, selecionar Import Existing Repository.
<br/><br/>
5) Na aba Servers, botão direito em cima do Tomcat Server, selecionar a opção Add and Remove... e adionar o projeto selenium
<br/><br/>
6) Em seguida clicar em Start the server e acessar no navegador a URL http://localhost:8080/selenium/login.xhtml
<br/><br/>
<p><b>Para realizar o teste do Selenium, realizar os seguintes passos:</b></p>

1) Realilzar o download do webdriver do Edge:<br/>
https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/<br/>
 <br/><br/>
2) Após o download, mover o arquivo MicrosoftWebDriver para a pasta do Eclipse onde se encontra o eclipse.exe
<br/><br/>
3) No eclipse, abrir o arquivo LoginTest.java e com o botão direito selecionar a opção Run As... Java application.
