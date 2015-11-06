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
		session.setAttribute("dni_blanco",request.getParameter("dni_blanco") );
		session.setAttribute("dni_negro",request.getParameter("dni_negro") );
		Partida partida= new Partida();
		if(accion.equals("jugar"))
		{ 
			
		
			partida=crolJuego.validarPartida(String.valueOf(session.getAttribute("dni_blanco")),String.valueOf( session.getAttribute("dni_negro")));
			if(partida==null){
			Jugador jug_blanco;
			Jugador jug_negro;
			jug_blanco=crolJuego.existeJugador(String.valueOf(session.getAttribute("dni_blanco")));
			jug_negro=crolJuego.existeJugador(String.valueOf(session.getAttribute("dni_negro")));
			if(jug_blanco==null)
			{
				//request.getRequestDispatcher("crearUsuario.jsp").forward(request, response);  // Bueno no funciona ninguno.. Ambos siguen de largo
				response.sendRedirect("crearUsuario.jsp");
			}
			else{
				if(jug_negro==null){
				response.sendRedirect("/crearUsuario.jsp");
				}
			}
			partida=crolJuego.IniciarJuego(jug_blanco, jug_negro);
			}
			
		
		//// que pasa si la partida existe, por si 	quiere modificar o no la existente
		
		}
		session.setAttribute("controlador", crolJuego);/// No estoy muy segura pero para tener smp el controlador en estado original y la partida.
		response.sendRedirect("/juego.jsp");
	}

}
