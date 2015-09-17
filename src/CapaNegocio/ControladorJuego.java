package CapaNegocio;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import capaEntidad.*;
import CapaDatos.CatalogoPartidas;
import CapaDatos.CatalogoPiezas;
import CapaInterfaz.CrearJugador;
import CapaInterfaz.Escritorio;
import Excepciones.appException;


/**
 * @author Luisina
 *
 */
public class ControladorJuego {
CatalogoPiezas cat;
CatalogoPartidas cj;
Partida partida;

public ControladorJuego()
{
	partida=new Partida();
	cat=new CatalogoPiezas();
	cj=new CatalogoPartidas();
}



	
	
	
	public Partida getPartida() {
	return partida;
}
public void setPartida(Partida partida) {
	this.partida = partida;
}
	public ArrayList<Pieza> IniciarJuego(Jugador ju_b, Jugador ju_n) {
		ArrayList<Pieza> pieza= new ArrayList<Pieza>();
		
		pieza.addAll(cat.iniciarJugo(ju_b.getDni(), ju_n.getDni()));
		partida=cj.agregarJugadores(ju_b, ju_n,pieza);
	
		
		return pieza;
		
		
	}
	public boolean realizarMovimiento(String color,String text, String text2) {
		Pieza p;
		boolean resp;
		p=cat.buscarFicha(color,text);
		resp=p.validarMovimiento(text, text2, color);
		return resp;
		
	}
/*	public String posiciones( ArrayList<Pieza> piezas) {
		
		String s=cat.Lista(piezas);
		return s;
	}*/
	
	
	public ArrayList<Pieza> validarJugador(String dni_b, String dni_n){
		
		partida=cj. buscarJugadorPorDni(dni_b, dni_n);
		ArrayList<Pieza> piezas= new ArrayList<Pieza>();
		if(partida==null)
		{
			Jugador jug_b=null, jug_n=null;
			//Aca deberia llamar a la interfaz que tiene el metodo guardar dos veces,
			// primero guardo jug_b y lugeo vuelvo hacer lo mismo para jug_n
			piezas.addAll(IniciarJuego(jug_b, jug_n));
		}
		else 
		{
			piezas.addAll(cat.colecPiezas(dni_b,dni_n));
		}
		// aca iria el posiociones pero me parece que es mejor enviarlo la intefaz y dividirla 
		// en blancas y ngeras sino les gusta, ahi los deje comentado
		partida.setPiezas(piezas);
		return piezas;
	
	
	
		
	}
	public ArrayList<Pieza> modificarPiezas(String color,String text, String text2) {

	     ArrayList<Pieza> p= new ArrayList<Pieza>();
	     p.addAll(cat.moverFicha(color,text, text2));
	     boolean resp=cat.borrarFicha(color, text2);
	     if(resp)
	        {
	    	 partida.setPiezas(p);
	    	 if(color.equals("blanco"))
	    		 partida.setTurno("negro");
	    	 else
	    		 partida.setTurno("blanco");
	    	 }
	     else
	    	 p=null;
	    
	     
	     return p;
		
	}
	public void UpPartida() {
		
		cj.UpPatida(getPartida());
		cat.UpFichas(getPartida().getPiezas(), getPartida().getJ_b().getDni(), getPartida().getJ_n().getDni());
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	/*
	public void realizarMovimiento  (String origen,String destino) throws appException
	{
		
		cat.Lista();
		try{
		Pieza PiezaOrigen = cat.buscarFicha(origen);
		Pieza PiezaDestino = cat.buscarFicha(destino);
		 if(PiezaOrigen.esvalidoMovimiento(origen, destino, PiezaOrigen.getColor()))
	     {
	    	 if(PiezaDestino==null)
	    	 {
	    		 cat.moverFicha(origen, destino);
	    	 }
	    	 else
	    		if(PiezaOrigen.getColor()!=PiezaDestino.getColor())
	    			 cat.borrarFicha(origen, destino);
	    		else
	    			JOptionPane.showMessageDialog( null,"No se pueden eliminar piezas de un mismo color", "Error", JOptionPane.NO_OPTION);
	     }
	     else 
	    	 JOptionPane.showMessageDialog( null,"El movimiento es invalido para la pieza", "Error", JOptionPane.NO_OPTION);
		}
		catch(NullPointerException e)
		{
			throw new appException("No hay ningna pieza en la posicion",e);
		}
	   
	}
	
	public String posiciones()
	{
		return cat.Lista();
	}
	*/
	

/*	//VALIDA SI EL CAMPO ESTA VACIO;
	private void validarCampo(Jugador jugador) throws Exception {
		if(jugador.getDni() == null) {
			throw new Exception("DEBE INGRESAR UN DNI PARA VALIDAR");
		}
		
	
	}
	private void buscarJugadorPorDni(Jugador jugador) {
		
		}*/
		
	
}
