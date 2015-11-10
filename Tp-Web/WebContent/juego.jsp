

<%@page import="CapaNegocio.*"%>
<%@page import="Imagenes.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
      <%@page import="capaEntidad.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script >
function mover() {
	
	var forma= document.getElementById("juego");
	///forma.accion= "guardar"; no se hace asi
	forma.action="adminJuego";
	var accion = document.getElementById("accion");
	accion.value="mover";
	forma.submit();
	
}
function guardar() {
	
	var forma= document.getElementById("juego");
	///forma.accion= "guardar"; no se hace asi
	forma.action="adminJuego";
	var accion = document.getElementById("accion");
	accion.value="guardar";
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
<center>
<form action="" method="POST" id="juego">
<input type="hidden" name="accion" id="accion">


<%
ControladorJuego crol= (ControladorJuego)session.getAttribute("controlador");
String blancas= "";
String negras= "";

for(Pieza pieza : crol.getPartida().getPiezas()){ 
if(pieza.getColor().equals("blanco"))
{

 blancas= blancas+"\n"+ pieza.getPosicion();}
 
else  {
 negras = negras + "\n"+  pieza.getPosicion(); 
}

}	

 

%>


<table border="1" cellpadding="1" cellspacing="1" style="width: 500px;">

	<tbody>
		<tr>
			<td><font><font>Blancas </font></font></td>
			
			
			<td><font><font>Negras</font></font></td>
			<td><font>Turno </font></td>
			<td><%=crol.getPartida().getTurno()%></td>
			
		
			
			



		<tr>
		    
			
			<td colspan="1" rowspan="4"><%= blancas %></td>
			<td colspan="1" rowspan="4"><%= negras %></td>

		</tr>
		<tr>	
			<td style="font-weight: bold ;" align="center">Origen :</td> 
            <td><input type="text" name="origen" id="origen"></td>
		</tr>
		<tr>
       <td style="font-weight: bold ;" align="center">Destino :</td> 
       <td><input type="text" name="destino" id="destino"></td>
		</tr>
		<tr>
		<td><img alt="" src="src/Imagenes/ajedrez.jpg"/></td>
		</tr>
	</tbody>
</table>

<tr>
<td colspan="2" >
<input type="button" value="Mover" style="font-size: 14px; color: black;"
onclick="mover();">
<input type="button" value="Guardar Partida" style="font-size: 14px; color: black;"
onclick="guardar();">
</td>
</tr>




	



</form>
</center>
</body>
</html>