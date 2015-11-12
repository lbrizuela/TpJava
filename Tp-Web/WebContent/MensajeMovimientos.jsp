<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="java.awt.image.CropImageFilter"%>
<%@page import="CapaNegocio.*"%>
<%@page import="capaEntidad.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>


<% ControladorJuego crol = (ControladorJuego)session.getAttribute("controlador") ;
Jugador ganador= new Jugador();
if( crol.getPartida().getTurno().equals("blanco"))
{
	ganador=crol.getPartida().getJ_b();
}
else
{
	ganador=crol.getPartida().getJ_n();

}
%>

              <h1 style="font-weight: bold ; color: red;" align="center">FELICITACIONES...!!!!!!!!!!!</h1>


        <h3 style="font-weight: bold ; color: red;" align="center">GANO JUGADOR <%=ganador.getNombre() +" "+ ganador.getApellido() %> </h3>


              <p align="right"> <a href="bienvenido.jsp">&laquo; VOLVER </a></p>

</center>
</body>
</html>