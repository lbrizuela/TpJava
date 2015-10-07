package CapaNegocio;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import capaEntidad.*;
import CapaDatos.CatalogoJugador;
import CapaDatos.CatalogoPartidas;
import CapaDatos.CatalogoPiezas;

import CapaInterfaz.Escritorio;
import Excepciones.appException;



public class ControladorJuego {
CatalogoPiezas catPieza;
CatalogoPartidas catPartida;
Partida partida;
CatalogoJugador catJugador;

public ControladorJuego()
{
	partida=new Partida();
	catPieza=new CatalogoPiezas();
	catPartida=new CatalogoPartidas();
	catJugador= new CatalogoJugador();
}



public Partida validarPartida(String dni_b, String dni_n){
		/// Este metodo valida que la partida exista
		partida=catPartida.buscarPartida(dni_b, dni_n);
		if(partida==null)// Si la partida no existe la inicializa\
		{
			JOptionPane.showMessageDialog(null, "No existe la partida");
			
		}
		/* ACA ESTARIA LA PREGUNTA DE QUE SI LA PARTIDA NO ES NULA PREGUNTA SI 
		 * QYUERE HACER UNA NUEVA O CONTINUAR CON LA ANTERIOR
		 
		 */
		//Si la partida existe la muestra 
		else
		{
			partida.setPiezas(catPieza.buscarPiezas(dni_b,dni_n));
			int codigo=JOptionPane.showConfirmDialog(null, "¿Quieres realizar una nueva partida?", "Existe partida pendiente", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (codigo==JOptionPane.YES_OPTION){   /// Esto estaba al revez.
	            System.out.println("Has pulsado en SI");
	            borrarPartida();/// debe borar la partida anterior para inicializar otra.
	            IniciarJuego(partida.getJ_b(), partida.getJ_n());
	  	
	        }
	        else if(codigo==JOptionPane.NO_OPTION){
	        	// esto esta de mas, por que tiene que buscar las piezas por si quiere borrar la partida anterior, entonces debe
	        	// crear una nueva partida con sus nuevas piezas, lo deje para que lo vean.
	            System.out.println("Has pulsado en NO");
	            
	          
		}
		  
        }
		
        return partida;
}


public Partida IniciarJuego(Jugador jug_b, Jugador jug_n) {
		/// Este metodo busca a los jugadores si existen y lo agregan a una nueva partida


			
	setPartida(catPartida.agregarPartida(jug_b, jug_n));	
	return partida;
}


public boolean validarMovimiento(String text, String text2) {
		// Este metodo valida si el moviento es valido, si lo es devuelve un true
		Pieza p;
		boolean resp;
		p=catPieza.buscarFicha(partida.getPiezas(),partida.getTurno(),text);
		if(p!=null)
			{
			resp=p.validarMovimiento(text, text2,partida.getTurno());
			}
		else
			{
			resp= false;
			}
	
		return resp;
}





public void borrarPartida() {
		//Este metodo borra la partida al finalizar el juego cuando fue ganado
	catPieza.borrarPiezas(partida.getJ_b().getDni(), partida.getJ_n().getDni());
	catPartida.borrarPartida(partida.getJ_b().getDni(), partida.getJ_n().getDni());

	 System.out.print("se borro");
		
	}


public void save(Jugador j) {
	// TODO Auto-generated method stub
	catJugador.add(j);
}
	
public Partida getPartida() {
	return partida;
}


public void setPartida(Partida partida) {
	this.partida = partida;
}



public ArrayList<Pieza> realizarMovimiento(String text, String text2) {

	     //Este metodo realiza el movimiento si ya fue correcto
	    
	     catPieza.borrarFicha(partida.getPiezas(),partida.getTurno(), text2);/// Primero tengo que borrar la ficha que come, por si primero hacemos el moviento y dsps borramos
	                                                                         /// cuando querramos borrar va a encontrar 2 fichas en la misma posicion.. Este esta OK
	     catPieza.moverFicha(partida.getPiezas(),partida.getTurno(),text, text2);//// Este metodo esta mal.. no me enceuntra la ficha, y no encuentro cual es el error.
	     boolean resp= catPieza.reyNulo(partida.getPiezas());
	     if(resp)
	     {
	    	 partida.setPiezas(null);
	     }
	      
	     else
	     {
	    	 if(partida.getTurno().equals("blanco"))
	    	 {
	    		 partida.setTurno("negro");
	    	 }
	    	 else
	    	 {
	    		 partida.setTurno("blanco");
	    	 }
	    }
	     
	     return partida.getPiezas();		
}




public void UpPartida() {
	///Este metodo actualiza los datos en la base 
		catPartida.UpPatida(getPartida());
		catPieza.UpFichas(getPartida().getPiezas(), getPartida().getJ_b().getDni(), getPartida().getJ_n().getDni());
	
		
}



public Jugador existeJugador(String text) {
	Jugador jugador= new Jugador();
    jugador=catJugador.buscarExistencia(text);
	return jugador;
}
	
	
}
