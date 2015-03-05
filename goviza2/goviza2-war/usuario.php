<?php
session_start();
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenido | &nbsp;<?php echo ''.$_SESSION['usuario'].''; ?></title>
        <meta charset="utf-8" lang="es">
    </head>
    <body>
        
        <table>
            <tr>
                <td><img src="<?php echo ''.$_SESSION['foto_perfil'].''; ?>" width="110" height="120"> </td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><?php echo '<b>'.$_SESSION['nombre'].'</b>'; ?></td>
            </tr>
            <tr>
                <td>Correo:</td>
                <td><?php echo '<b>'.$_SESSION['correo'].'</b>'; ?></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="cerrar.php">Cerrar sesion</a> </td>
            </tr>
        </table>
    </body>
</html>
