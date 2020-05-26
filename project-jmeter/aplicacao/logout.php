<?php
  $sair = $_POST['sair'];
  $login_cookie = $_COOKIE['login'];
   if (isset($sair)) {
		unset($_COOKIE[$login_cookie]);
		setcookie('login', '', time() - 3600);
		header("Location:login.php");
   
	}
?>