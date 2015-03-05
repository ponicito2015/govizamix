<?
$usuario = $POST ["n_usuario"];
$password =$POST["pwd"];

$conexion = mysql_connect("jdbc:mysql://localhost/","root","Anthony2909");
mysql_select_db("sistema",$conexion);

$sql="SELECT idusuario FROM usuario; WHERE nombre_usuario = '$usuario' AND password='$password'";
$comprobar = mysql_query($sql);

if (mysql_num_rows($comprobar)>0)
{
    $id_usuario=mysql_result($comprobar,0);
setcookie("misitio_userid","$id_usuario",time()+3600);
header ("Location:admin");
}
else {
    echo "Usuario o Contrasena incorrectos";
}
        
?>
