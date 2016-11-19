
//Teste 02 - Verificando o valor Inesperado 
QUnit.test( "Test Failed", function( assert ) {
  assert.ok( 1 == "2", "Teste mal sucedido!" );
});


//Teste 03 - Criando possiveis testes unitários 
var valor01 = "UFPE";
var valor02 = 2;

QUnit.test( "Testes unitários", function(verifica) {
  verifica.equal(valor01, "UFPE", "Os valores são iguais");
  verifica.deepEqual(valor02, 2, "Os valores são iguais e são do mesmo tipo"); //===
});


//Teste 04 - Testando possível conexão com um DB
QUnit.test( "Abre conexão", function( abre_conexao ) {
  abre_conexao.ok( true, "Conexão aberta" );
});


//Teste 05 - MODULO LOGIN
QUnit.module( "Módulo Login" );

//VARIAVEIS VINDO DE UMA FUNÇÃO ATRAVÈS DE JSON
var login = '{"email":"rjs3@cin.ufpe.br","senha":"123456","firstAcess":"false"}';
//PARTICIONANDO O JSON
var obj = JSON.parse(login);

//CAMPOS QUE O USUARIO ESCREVEU
var campo_email = "rjs3@cin.ufpe.br";
var campo_senha = "123456";

//INICIANDO PRIMEIRO TESTE
QUnit.test( "Username", function(assert) {
  assert.ok( campo_email.length > 0 , "Usuario escreveu login");
  assert.deepEqual( obj.email, "rjs3@cin.ufpe.br", "Login Correto!" );
});

//INICIANDO SEGUNDO TESTE
QUnit.test( "Password", function(assert) {
  assert.ok( campo_senha.length > 0 , "Usuario escreveu Senha");
  assert.deepEqual( obj.senha, "123456", "Senha Correta!" );

});

//TESTE 06 - MODULO DASHBOARD
QUnit.module( "Dashboard" );

QUnit.test( "Testes Assincronos", function( resposta ) {
  
  var done1 = resposta.async();
  var done2 = resposta.async();

  setTimeout(function(recuperarSenha) {
    resposta.ok( true, "Primeiro teste foi efetuado depois de '200ms'" );
    done1();
  }, 200 );

  setTimeout(function(enviarEmail) {
    resposta.ok( true, "Segundo teste foi efetuado depois de '200ms' " );
    done2();
  }, 200);

});

//TESTE DE INTERFACE
QUnit.test( "Teste Interface - Point Click ", function( assert ) {
  assert.expect(1);
 
  var $button = $( "#button" );
 
  $button.on( "click", function() {
    assert.ok( true, "Botão TESTAR foi clicado" );
  });

  $button.trigger( "click" );
 
});

//INFORMATIVO DE TESTES
QUnit.test( "Informativo de Teste", function( informativo ) {
  var fixture = $( "#conteudo" );
 
  fixture.append( "<br/><br/><div class='alert alert-success text-center' role='alert'><b>Olá Usuário, você está realizando testes!</b></div>" );
  informativo.ok( true, "Testes sendo efetuados (MENSAGEM PARA O USUARIO)!" );
 
});