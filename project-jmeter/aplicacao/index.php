
<?php
    $login_cookie = $_COOKIE['login'];
        if(isset($login_cookie)){
            echo"<body><br><div class='container'><center>Bem-Vindo, $login_cookie <br>";
            echo"O seu login foi realizado com sucesso!<br>";	
			echo"<br><form class='form-signin' role='form' method='POST' action='logout.php'>
				   <button class='btn btn-primary' type='submit' value='sair' id='sair' name='sair'>Sair</button></div> </center></body>";
			
        }else{
            echo"Bem-Vindo, convidado <br>";
            echo"Essas informações <font color='red'>NÃO PODEM</font> ser acessadas por você";
            echo"<br><a href='login.php'>Faça Login</a> Para ler o conteúdo";
        }
		
		
	
		
?>

<head>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
</head>
