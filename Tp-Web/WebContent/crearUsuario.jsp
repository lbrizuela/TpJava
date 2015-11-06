<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logueo</title>
</head>
<script>
function cancelar() {
	
	var forma= document.getElementById("crearUsuario");
	///forma.accion= "guardar"; no se hace asi
	forma.action="loginUsuario";
	var accion = document.getElementById("accion");
	accion.value="cancelar";
	forma.submit();
	
}

function aceptar() {
	var forma= document.getElementById("crearUsuario");
	///forma.accion= "guardar"; no se hace asi
	forma.action="loginUsuario";
	var accion = document.getElementById("accion");
	accion.value="aceptar";
	forma.submit();
}

function cargar() {
	
	var forma= document.getElementById("crearUsuario");
	
}


</script onload="cargar();">

<body>
<form action="" method="POST" id="crearUsuario"">
<center>
<input type="hidden" name="accion" id="accion">
<p style="height: 22px; ">

Por favor,Logueese</p>
<table>
<tr>
<td style="font-weight: bold ;" align="center">DNI :</td> 
<td><input type="text" name="dni" id="dni">
</td>
</tr>


<tr>
<tr>
<td style="font-weight: bold;" align="center">Nombre : </td>
<td><input type="text" name="nombre" id="nombre"></td>
</tr>
<tr>

<tr>
<td style="font-weight: bold; " align="center">Apellido : </td>
<td><input type="text" name="apellido" id="apellido"></td>
</tr>

<tr>
<td colspan="2" >
<input type="button" value="Cancelar" style="font-size: 14px; color: blue;"
onclick="cancelar();">
<input type="button" value="Aceptar" style="font-size: 14px; color: blue;"
onclick="aceptar();" >
</td>

</tr>

</table>
</center>
</form>

</body>
</html>