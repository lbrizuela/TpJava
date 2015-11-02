package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CapaNegocio.ControladorJuego;
import capaEntidad.Jugador;
import capaEntidad.Partida;

/**
 * Servlet implementation class loginPartida
 */
@WebServlet("/loginPartida")
public class loginPartida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginPartida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion= request.getParameter("accion");
		ControladorJuego crolJuego=new ControladorJuego();;
		HttpSession session= request.getSession(true);
		Partida partida= new Partida();
		if(accion.equals("jugar"))
		{ 
			
		
			partida=crolJuego.validarPartida(request.getParameter("dni_blanco"), request.getParameter("dni_negro"));
			if(partida==null){
			Jugador jug_blanco;
			Jugador jug_negro;
			jug_blanco=crolJuego.existeJugador(request.getParameter("dni_blanco"));
			if(jug_blanco==null)
			{
				response.sendRedirect("/crearUsuario");
			}
			jug_negro=crolJuego.existeJugador(request.getParameter("dni_negro"));
			
			if(jug_negro==null){
				response.sendRedirect("/crearUsuario.jsp");
			}
			partida=crolJuego.IniciarJuego(jug_blanco, jug_negro);
			}
			
		
			
		
		}
		session.setAttribute("controlador", crolJuego);/// No estoy muy segura pero para tener smp el controlador en estado original y la partida.
		response.sendRedirect("/juego.jsp");
	}

}
