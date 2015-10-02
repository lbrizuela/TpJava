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
CatalogoPiezas cat;
CatalogoPartidas cj;
Partida partida;
CatalogoJugador catJug;

public ControladorJuego()
{
	partida=new Partida();
	cat=new CatalogoPiezas();
	cj=new CatalogoPartidas();
	catJug= new CatalogoJugador();
}


	


public ArrayList<Pieza> validarJugador(String dni_b, String dni_n){
		
		partida=cj. buscarPartida(dni_b, dni_n);
		ArrayList<Pieza> piezas= new ArrayList<Pieza>();
		if(partida==null)
		{
	
	
		piezas.addAll(IniciarJuego(dni_b, dni_n));
		}
		
		piezas.addAll(cat.colecPiezas(dni_b,dni_n));
		
		partida.setPiezas(piezas);
		return piezas;
	
	
	
		
	}
	public ArrayList<Pieza> modificarPiezas(String color,String text, String text2) {

	     
	     partida.setPiezas(cat.moverFicha(partida.getPiezas(),color,text, text2));
	     partida.setPiezas(cat.borrarFicha(partida.getPiezas(),color, text2));
	     boolean resp= cat.reyNulo(partida.getPiezas());
	     if(resp)
	     {
	    	 partida.setPiezas(null);
	     }
	       
	     else
	     {
	    	 if(color.equals("blanco"))
	    		 partida.setTurno("negro");
	    	 else
	    		 partida.setTurno("blanco");
	    }
	     
	     return partida.getPiezas();
		
	}
	public void UpPartida() {
		
		cj.UpPatida(getPartida());
		cat.UpFichas(getPartida().getPiezas(), getPartida().getJ_b().getDni(), getPartida().getJ_n().getDni());
		
		// TODO Auto-generated method stub
		
	}
	
	public Partida getPartida() {
	return partida;
}
public void setPartida(Partida partida) {
	this.partida = partida;
}
	public ArrayList<Pieza> IniciarJuego(String dni_b, String dni_n) {
		
		Jugador jug_b= catJug.buscarExistencia(dni_b);
		CrearJugador jg = new CrearJugador();
		if(jug_b==null){
			// llamar a la interfaz guardarlo en variable jugador 
			jg.setVisible(true);
			catJug.add(jug_b);
			
		}
	
		Jugador jug_n= catJug.buscarExistencia(dni_n);
				if(jug_n==null){
					//llama a la interfaz de nuevo  guardalo en variable jugador
					jg.setVisible(true);
					catJug.add(jug_n);
				 // ni idea esto che te dejo el setvisible y un me gusta
				}
		
		setPartida(cj.agregarPartida(jug_b, jug_n));
	
		
		return partida.getPiezas();
		
		
	}
	public boolean realizarMovimiento(String color,String text, String text2) {
		Pieza p;
		boolean resp;
		p=cat.buscarFicha(partida.getPiezas(),color,text);
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
	
	
	
	
}