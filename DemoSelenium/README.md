<h1>Repositório destinado à demonstração da utilização do Selenium.</h1>

Nesta demonstração, são executados alguns casos de testes no site de demonstração https://enterprise-demo.orangehrmlive.com/
Em relação ao Java, há uma pasta com nome TesteMultiplo, que visa rodar os testes em navegadores diferentes.

Os casos de teste foram adaptados para 3 linguagens diferentes(Java, Ruby e Python).
No entanto, não será abordada a instalação e configuração desses ambientes.

Apenas o que for necessário para o funcionamento do Selenium será abordado para cada ferramenta.

<h3>Ambiente utilizado</h3>

- Fedora 21
- Gradle 3.1

<h2>Instalação do Selenium</h2>

Ao baixar o repositório da demonstração realizar os comandos abaixo

<h3>Java</h3>

1) <code>$ cd DemoSelenium/DemoSeleniumJava/DemoSimples</code> ou 
DemoSelenium/DemoSeleniumJava/DemoMultiplo

2) $./gradlew build

<h3>Ruby</h3>

1) $ gem install selenium-webdriver

2) $ gem install minitest

<h3>Python</h3>

1) $ yum install python-pip

2) $ pip install selenium


<h2>Executando os testes</h2>

<h3>Java</h3>

1) $ cd DemoSelenium/DemoSeleniumJava/DemoSimples ou
DemoSelenium/DemoSeleniumJava/DemoMultiplo

2) $./gradlew test

<h3>Ruby</h3>

1) $ cd DemoSelenium/DemoSeleniumRuby

2) $ ruby TesteSimples.rb

<h3>Python</h3>

1) $ cd DemoSelenium/DemoSeleniumPython

2) $ python TesteSimples.py


<h2>Selenium IDE</h2>

É um Plug-in para Firefox que permite ao usuário gravar e executar as ações no navegador.

Para utilizá-lo basta realizar os seguintes passos:

1) Acessar a página de downloads do Selenium através da url: http://www.seleniumhq.org/download/
 
2) Na seção Selenium IDE clicar no link "from addons.mozilla.org"
 
3) Na página seguinte clicar em Add to Firefox

<b>Autor: Beatriz Sena, Chrystian Soares, Isadora Oliveira, Yasmine Santos</b>
