package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
				if(crol.getPartida().isJuegoGanado())
				{
					crol.borrarPartida();
					request.getRequestDispatcher("MensajeMovimientos.jsp").forward(request, response);
				}
				else{
				crol.cambiarTurno();
				request.getRequestDispatcher("juegoMovimientoCorrecto.jsp").forward(request, response);
				}
				
			}
			else {
			
				request.getRequestDispatcher("juegoMovimientoIncorrecto.jsp").forward(request, response);
			}
		}
		else 
		{
			
			if(accion.equals("Guardar"))
			{
				
				crol.UpPartida();
				request.getRequestDispatcher("MensajeGuardar.jsp").forward(request, response);
			}
		}
	}

}
