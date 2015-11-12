

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
	forma.action="adminJuego";
	var accion = document.getElementById("accion");
	accion.value="mover";
	forma.submit();
	
}
function guardar() {
	
	var forma= document.getElementById("juego");
	forma.action="adminJuego";
	var accion = document.getElementById("accion");
	accion.value="Guardar";
	forma.submit();
	
}

function cargar() {
	
	var forma= document.getElementById("juego");
}

</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VENTANA JUEGO</title>
</head>
<body>
<center>
<p style="font-weight: bold; size: 12px; color: blue;" align="center" >El Movimiento Fue Correcto</p>
<form action="" method="POST" id="juego">
<input type="hidden" name="accion" id="accion">


<%
ControladorJuego crol= (ControladorJuego)session.getAttribute("controlador");
String blancas= "";
String negras= "";

for(Pieza pieza : crol.getPartida().getPiezas()){ 
	if(pieza.getColor().equals("blanco"))
	{

	 blancas= blancas+"\n"+pieza.getNombre()+"-"+ pieza.getPosicion();}
	 
	else  {
	 negras = negras + "\n"+pieza.getNombre()+"-"+  pieza.getPosicion(); 
	}

	}	
	

 

%>


<!-- <table border="1" cellpadding="1" cellspacing="1" style="width: 500px;"> -->
<table width="575" border="2" align="center" cellspacing="2" bordercolor="#000000" >
	<tbody>
	<tr align= "center"><td style="font-weight: bold ;" align="center">Jugador Blanco:</td><td style="font-weight: bold ;" align="center">Jugador Negro:</td> <td colspan="3" style="font-weight: bold ;" align="center" ><font>Turno: </font></td></tr> <!--  <--FILAS--> 
	<tr align= "center"><td><%=crol.getPartida().getJ_b().getNombre()%></td><td><%=crol.getPartida().getJ_n().getNombre()%></td><td colspan="3" rowspan="3"><%=crol.getPartida().getTurno()%></td></tr>
	<tr><td style="font-weight: bold ;" align="center"><font><font> Piezas Blancas </font></font></td><td style="font-weight: bold ;" align="center"><font><font>Piezas Negras</font></font></td></tr>
	
	<tr><td colspan="1" rowspan="4"><%= blancas %></td><td colspan="1" rowspan="4"><%= negras %></td></tr>
	
	<tr><td style="font-weight: bold ;" align="center"> Origen</td><td><input type="text" name="origen" id="origen" ></td></tr>	
			 
            
		
		<tr>
       <td style="font-weight: bold ;" align="center"> Destino</td> 
       <td><input type="text" name="destino" id="destino"></td>
		</tr>
		<tr align="center" valign="middle" ><td colspan="4" ><input type="button" value="Mover" style="font-weight: bold; font-size: 14px; color: black ;"
onclick="mover();">
<input align="right" type="button" value="Guardar" style="font-weight: bold; font-size: 14px; color: black ;"
onclick="guardar();"></td></tr>
	</tbody>
</table>



<div><img  src="ajedrez.jpg" /></div>


<div></div>




	



</form>
</center>
</body>
</html>