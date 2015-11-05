package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import capaEntidad.Jugador;
import capaEntidad.Partida;
import CapaNegocio.*;

/**
 * Servlet implementation class juegoServlet
 */
@WebServlet("/adminJuego")
public class juegoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public juegoServlet() {
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
		ControladorJuego crol= (ControladorJuego)request.getSession().getAttribute("controlador");
		if(accion.equals("mover"))
		{
			if(crol.validarMovimiento(request.getParameter("origen"),request.getParameter( "destino")))
			{
				crol.realizarMovimiento(request.getParameter("origen"),request.getParameter( "destino"));
			}
			else {
				/// mandar un msj no se como chota se hace
			}
		}
		else 
		{
			if(accion.equals("guardar"))
			{
				////falta hacer el guardar
				
			}
		}
	}

}