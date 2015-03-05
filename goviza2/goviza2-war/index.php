<?php
session_start();
?>
<?php
$conn=mysql_connect ('jdbc:mysql://localhost:3306/sistema"','root','Anthony2909');
if (!$conn){
    die('No se puede conectar'.mysql_error());
}
$db_selected = mysql_select_db ('login',$conn);
if (!$db_selected){
    die('Error al seleccionar la BD'.mysql_error());
}

$usuario=$POST['usuario'];
$pass=$POST['password'];
   $sql = mysql_query("SELECT * FROM usuario WHERE usuario='".$usuario."'");
    if($dato === mysql_fetch_array($sql)){
    if($dato["password"] == SHA1("$pass")){
    $_SESSION["usuario"] = $dato['usuario'];
    $_SESSION["nombre"] = $dato['nombre'];
    $_SESSION["correo"] = $dato['correo'];
    $_SESSION["foto_perfil"] = $dato['foto_perfil'];
        
        header('Location: usuario.php');
    }else{
    echo 'Contraseña incorrecta';
    echo '<a href="login.xhtml">Aceptar</a>';
    }
    }else{
    echo 'Usuario no registrado';
    echo '<a href="login.xhtml">Aceptar</a>';
    }

