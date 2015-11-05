package Servlet;

import java.io.IOException;
import capaEntidad.Jugador;
import CapaNegocio.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginUsuario
 */
@WebServlet("/loginUsuario")
public class loginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginUsuario() {
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
		if(accion.equals("aceptar"))
		{
			Jugador ju= new Jugador();
			ju.setApellido(request.getParameter("apellido"));
			ju.setDni(request.getParameter("dni"));
			ju.setNombre(request.getParameter("nombre"));
			ControladorJuego crolJuego= new ControladorJuego();
			crolJuego.save(ju);
			response.sendRedirect("/loginPartida.java");
			
			
		}
		else
		{
			if(accion.equals("cancelar"))
			{
				/////response.sendRedirect("/salir"); algo asi deberia ser..
			}
		}
	}
		
	

}
