 <?php
   
   include('conn.php');
   
   $sql = "SELECT * FROM usuario";
   $result = @mysql_query($sql);
   echo "<center><table style='border-collapse: collapse;' border='1'>
	   <tr>
	   <th>Nº Registro </th>
	  <th>Nome</th>
	  <th>email</th>
	  </tr>";
   while($row = mysql_fetch_array($result)) {
    echo "<tr>";
    echo "<td>" . $row['id_usuario'] . "</td>";
    echo "<td>" . $row['nome'] . "</td>";
    echo "<td>" . $row['email'] . "</td>";
    echo "</tr>";
  }
  echo "</table></center>";
 
 ?>