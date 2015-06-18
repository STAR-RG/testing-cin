
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<title>Cadastro de Usuário </title>
</head>

<body>
<div class="container droppedHover" style="margin-top:5%;">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
		<center>
			<h3 class="form-signin-heading" contenteditable="false">Cadastro de Usuário</h3>
			<br/>
		</center>
		<form id="fm" method="post" name="formCad">
					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" name="nome" required="true">
					</div>
					<div class="form-group">
						<label>Email:</label>
						<input name="email" type="email" class="form-control" required="true" >
					</div>
					<div class="form-group">
						<label>Senha:</label>
						<input name="senha" type="password" class="form-control" required="true">
					</div>
					<center>
					<a class="btn btn-primary" href="login.php" role="button">Voltar</a>
					<button class='btn btn-primary' type='submit' value='cadastrar' id='cadastrar' name='cadastrar'>Cadastrar</button>
					</center>
		</form>
		</div>
	</div>
</div>
</body>
<html>


<?php
if(isset($_POST['cadastrar'])){
	$nome = $_POST['nome'];
	$email = $_POST['email'];
	$senha = $_POST['senha'];

	include('conn.php');

	$sql = "INSERT INTO usuario(nome, email, senha) values('$nome','$email','$senha')";
	$result = @mysql_query($sql);
	if ($result){
		echo '<div class="col-md-4 col-md-offset-4">
				<div class="alert alert-success" role="alert"><p>Usuário cadastrado com sucesso!<p></div></div>';
	} else {
		echo json_encode(array('msg'=>'Erro ao inserir dados.'));
	}

}
?>
