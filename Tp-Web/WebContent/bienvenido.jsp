<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script >
function jugar() {
	
	var forma= document.getElementById("inicioJuego");
	///forma.accion= "guardar"; no se hace asi
	forma.action="loginPartida";
	var accion = document.getElementById("accion");
	accion.value="jugar";
	forma.submit();
	
}
function cargar() {
	
	var forma= document.getElementById("inicioJuego");
}

</script>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
<center>

<form action="" method="POST" id="inicioJuego">
<input type="hidden" name="accion" id="accion">
<table>

<tr>
<td style="font-weight: bold ;" align="center">Blanco :</td> 
<td><input type="text" name="dni_blanco" id="dni_blanco"></td>
</tr>


<tr>
<td style="font-weight: bold ;" align="center">Negro :</td> 
<td><input type="text" name="dni_negro" id="dni_negro">
</td>
</tr>

<tr>
<td colspan="2" >
<input type="button" value="Jugar" style="font-size: 14px; color: black; align: center; width: 236px"
onclick="jugar();">
</td>
</tr>


</table>
</form>
</center>
</body>
</html>