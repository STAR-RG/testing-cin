<html>
<head>
	<title> Sistema de Login </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
</head>


<body>

<div class="container droppedHover">
    <form class="form-signin" role="form" method="POST" action="login.php">
		<center>
			<h3 class="form-signin-heading" contenteditable="false">Sistema de Login</h3>
		</center>
		<br>
        <input type="text" class="form-control" placeholder="Email" autofocus="" contenteditable="false" id="login" name="login" required="true">
		
        <input type="password" class="form-control" placeholder="Senha" contenteditable="false" id="senha" name="senha" required="true">     
		<br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="entrar" id="entrar" name="entrar">Entrar</button>
		<a class="btn btn-warning btn-block" id="btncadastrar" name="btncadastrar" href="cadastro.php">Cadastrar novo Usuário</a>
	</form>
    
</div>

</body>
</html>


<?php   
include('conn.php');
if (isset($_POST['entrar'])) {	
	$login = $_POST['login'];
	$senha = $_POST['senha'];
			 
	$verifica = mysql_query("SELECT * FROM usuario WHERE email = '$login' AND senha = '$senha'") or die("erro ao selecionar");
	print_r($verifica);
		if (mysql_num_rows($verifica)<=0){
			echo"<script language='javascript' type='text/javascript'>alert('Login e/ou senha incorretos');window.location.href='login.php';</script>";
			die();
		}else{
			setcookie("login",$login);
			header("Location:index.php");
		}
}
?>
