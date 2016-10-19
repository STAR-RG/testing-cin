Autor: Beatriz Sena, Chrystian Soares, Isadora Oliveira, Yasmine Santos

Repositório destinado à demonstração da utilização do Selenium.

Nesta demonstração, são executados alguns casos de testes no site de demonstração https://enterprise-demo.orangehrmlive.com/
Em relação ao Java, há uma pasta com nome TesteMultiplo, que visa rodar os testes em navegadores diferentes.

Os casos de teste foram adaptados para 3 linguagens diferentes(Java, Ruby e Python).
No entanto, não será abordada a instalação e configuração desses ambientes.




Apenas o que for necessário para o funcionamento do Selenium será abordado para cada ferramenta.

Ambiente utilizado

- Fedora 21
- Gradle 3.1

Instalação do Selenium

Ao baixar o repositório da demonstração realizar os comandos abaixo

Java

1) $ cd DemoSelenium/DemoSeleniumJava/DemoSimples ou 
DemoSelenium/DemoSeleniumJava/DemoMultiplo

2) $./gradlew build

Ruby

1) $ gem install selenium-webdriver

2) $ gem install minitest

Python

1) $ yum install python-pip

2) $ pip install selenium


Executando os testes

Java

1) $ cd DemoSelenium/DemoSeleniumJava/DemoSimples ou
DemoSelenium/DemoSeleniumJava/DemoMultiplo

2) $./gradlew test

Ruby 

1) $ cd DemoSelenium/DemoSeleniumRuby

2) $ ruby TesteSimples.rb

Python

1) $ cd DemoSelenium/DemoSeleniumPython

2) $ python TesteSimples.py


Selenium IDE

É um Plug-in para Firefox que permite ao usuário gravar e executar as ações no navegador.

Para utilizá-lo basta realizar os seguintes passos:

1) Acessar a página de downloads do Selenium através da url: http://www.seleniumhq.org/download/
 
2) Na seção Selenium IDE clicar no link "from addons.mozilla.org"
 
3) Na página seguinte clicar em Add to Firefox