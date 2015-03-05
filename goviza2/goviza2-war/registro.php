<?php
$conn = mysql_connect('jdbc:mysql://localhost/sistema','Anthony2909');
if (!$conn){
    die('No se puede conectar'.mysql_error());
}
$db_select = mysql_select_db('sistema', $conn);
if(!$db_select){
    die('Error al seleccionar BD'.mysql_error());
    }
    
    $usuario=$POST ['usuario'];    
    $pass=$POST ['password'];
    $pass1=$POST ['password1'];
    $nombre=$POST ['nombre'];
    $correo=$POST ['email'];

    $permitidos= array("image/jpg","image/jpeg","image/gif","image.png");
    if(in_array($_FILES['image']['type'],$permitidos)){
        $rutaEnServidor='images';
        $rutaTemporal=$_FILES['imagen']['tmp_name'];
        $nombreImagen=$_FILES['imagen']['name'];
        $rutaDestino=$rutaEnServidor.'/'.$nombreImagen;
        move.uploaded.file($rutaTemporal,$rutaDestino);
        
        if($pass!=pass1){
            echo"Las contraseñas no coninciden";
        }else{
            $ins = "INSERT INTO usuario(usuario,password,nombre,correo,foto_perfil) VALUES ('".$usuario."'.'".$pass."'.'".$pass1."''".$nombre."''".$correo."''".$rutaDestino."')";
            $ins3 = mysql_query($ins,$conn)or die(mysql_error());
            
            header("Location:admin");
        }
    }
