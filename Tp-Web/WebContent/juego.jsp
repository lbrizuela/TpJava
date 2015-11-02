

<%@page import="CapaNegocio.ControladorJuego"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.List" %>
      <%@page import="capaEntidad.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script >
function mover() {
	
	var forma= document.getElementById("juego");
	///forma.accion= "guardar"; no se hace asi
	forma.action="adminJuego";
	var accion = document.getElementById("accion");
	accion.value="jugar";
	forma.submit();
	
}
function guardar() {
	
	var forma= document.getElementById("juego");
	///forma.accion= "guardar"; no se hace asi
	forma.action="adminJuego";
	var accion = document.getElementById("accion");
	accion.value="jugar";
	forma.submit();
	
}

function cargar() {
	
	var forma= document.getElementById("juego");
}

</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Juego</title>
</head>
<body>

<form action="" method="POST" id="juego">
<input type="hidden" name="accion" id="accion">
<table>
<table style=" frot-weight; align: right">
<tr>
<td style="font-weight: bold ;" align="center">Turno :</td> 
</td>
</tr>

<tr>
<th>Fichas Blancas</th><th>Fichas Negras</th>
</tr>




<%
ControladorJuego crol= (ControladorJuego)session.getAttribute("controlador");
Partida partida=crol.getPartida(); 

%>
<tr>
<td><%=partida.getTurno()%></td>
</tr>

<% 
for(Pieza obj: partida.getPiezas()) {
	if(obj.getColor().equals("blanco")){
%>
	<tr>
	<td><%=obj.getPosicion()%></td>
	</tr>
	<%} else{  %>
	<tr>
	<td><%=obj.getPosicion() %></td>
	</tr>
<%	
	}
}
%>

</table>

<table style=" frot-weight; align: left" >
<tr>
<td style="font-weight: bold ;" align="center">Origen :</td> 
<td><input type="text" name="origen" id="origen">
</td>
</tr>

<tr>
<td style="font-weight: bold ;" align="center">Destino :</td> 
<td><input type="text" name="destino" id="destino">
</td>
</tr>
<tr>
<td colspan="2" >
<input type="button" value="Mover" style="font-size: 14px; color: black;"
onclick="mover();">
<input type="button" value="Guardar Partida" style="font-size: 14px; color: black;"
onclick="guardar();">
</td>
</tr>
</table>
</table>
</form>
</body>
</html>