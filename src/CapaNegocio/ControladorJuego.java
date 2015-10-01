package CapaNegocio;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import capaEntidad.*;
import CapaDatos.CatalogoJugador;
import CapaDatos.CatalogoPartidas;
import CapaDatos.CatalogoPiezas;
import CapaInterfaz.CrearJugador;
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



public ArrayList<Pieza> validarPartida(String dni_b, String dni_n){
		/// Este metodo valida que la partida exista
		partida=catPartida. buscarPartida(dni_b, dni_n);
		ArrayList<Pieza> piezas= new ArrayList<Pieza>();
		if(partida==null)
		{
	// Si la partida no existe la inicializa
		piezas.addAll(IniciarJuego(dni_b, dni_n));
		}
		//Si la partida existe la muestra 
		piezas.addAll(catPieza.buscarPiezas(dni_b,dni_n));
		
		partida.setPiezas(piezas);
		return piezas;
}


public Partida getPartida() {
	return partida;
}


public void setPartida(Partida partida) {
	this.partida = partida;
}



public ArrayList<Pieza> realizarMovimiento(String color,String text, String text2) {

	     //Este metodo realiza el movimiento si ya fue correcto
	     partida.setPiezas(catPieza.moverFicha(partida.getPiezas(),color,text, text2));
	     partida.setPiezas(catPieza.borrarFicha(partida.getPiezas(),color, text2));
	     boolean resp= catPieza.reyNulo(partida.getPiezas());
	     if(resp)
	     {
	    	 partida.setPiezas(null);
	     }
	       
	     else
	     {
	    	 if(color.equals("blanco"))
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
	



public ArrayList<Pieza> IniciarJuego(String dni_b, String dni_n) {
		/// Este metodo busca a los jugadores si existen y lo agregan a una nueva partida
		
	Jugador jug_b= catJugador.buscarExistencia(dni_b);
	CrearJugador jg = new CrearJugador();
	
	if(jug_b==null){
			
			jg.setVisible(true);
			catJugador.add(jug_b);
			
	}
	
	Jugador jug_n= catJugador.buscarExistencia(dni_n);
	
	if(jug_n==null){
	//llama a la interfaz de nuevo  guardalo en variable jugador
	jg.setVisible(true);
	catJugador.add(jug_n);
	 // ni idea esto che te dejo el setvisible y un me gusta
	}
		
	setPartida(catPartida.agregarPartida(jug_b, jug_n));
	
		
	return partida.getPiezas();
}









public boolean validarMovimiento(String color,String text, String text2) {
		// Este metodo valida si el moviento es valido, si lo es devuelve un true
		Pieza p;
		boolean resp;
		p=catPieza.buscarFicha(partida.getPiezas(),color,text);
		if(p==null)
			{
			resp=p.validarMovimiento(text, text2, color);
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
	partida=null;
		
		
	}


public void save(Jugador j) {
	// TODO Auto-generated method stub
	
}
	
	
	
	
}