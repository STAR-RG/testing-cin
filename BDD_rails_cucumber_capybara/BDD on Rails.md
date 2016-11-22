OBS: Ao utilizar essa demo, todas as gems necessárias já estão especificadas no Gemfile e foram instaladas no comando bundle install do README.md 


Pré Requisitos para preparar um ambiente Rails para esses testes :

Ter no Gemfile (arquivo de bibliotecas) na parte de testes pelo menos essas 4 gems:


(Entenda 'gem' como biblioteca)


gem 'cucumber-rails', :require => false
gem 'database_cleaner'
gem 'capybara'
gem 'rspec-rails'    


As 4 gems servirão para criar as pastas e integração do cucumber e capybara com o projeto.


Nota¹: a gem database_cleaner tem uma certa dependência com a gem cucumber-rails.


Nota²: a gem rspec-rails é utilizada para validação das expressões nos arquivos de step_definitions. Este diretório irá guardar os arquivos de features e os step_definitions do cucumber.


Os arquivos que descrevem como será o comportamento da webpage são da extensão .feature, e em seu conteúdo só existem o que será testado de comportamento e, por padrão, são guardados dentro da pasta features.


Os arquivos que realmente vão testar o comportamento tem a extensão .rb e são guardados
na pasta step_definitions


/*********************************/


Antes da instalação:
 - Configure o arquivo Gemfile.
 - Utilize o comando "bundle update" para atualizar as gems.
 
Em nosso exemplo, outras gems serão utilizadas, porém não são utilizadas para testes.
Contudo, iremos informar o conteúdo do arquivo para facilitar o entendimento do BDD.


Obs.: Caso o diretório "features" não for criado, utilize o comando cucumber --init para criar
e depois rode o comando rails generate cucumber:install. Caso apareça a pergunta se deseja sobrescrever algum campo, diga sim.


/*********************************/
