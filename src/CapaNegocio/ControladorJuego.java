package CapaNegocio;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import capaEntidad.*;
import CapaDatos.CatalogoJugador;
import CapaDatos.CatalogoPartidas;
import CapaDatos.CatalogoPiezas;
import CapaInterfaz.CrearJugador12;
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
		if(partida==null)// Si la partida no existe la inicializa\
		{
	
			JOptionPane.showMessageDialog(null, "No tienen partidas entre los jugadores");
			piezas.addAll(IniciarJuego(dni_b, dni_n));
			}
		/* ACA ESTARIA LA PREGUNTA DE QUE SI LA PARTIDA NO ES NULA PREGUNTA SI 
		 * QYUERE HACER UNA NUEVA O CONTINUAR CON LA ANTERIOR
		 
		 */
		//Si la partida existe la muestra 
		int codigo=JOptionPane.showConfirmDialog(null, "¿Quieren realizar una nueva partida?", "Existe partida pendiente", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (codigo==JOptionPane.YES_OPTION){
            System.out.println("Has pulsado en SI");
            piezas.addAll(catPieza.buscarPiezas(dni_b,dni_n));
    		partida.setPiezas(piezas);
    		
        }else if(codigo==JOptionPane.NO_OPTION){
        	// crea una nueva partida
            System.out.println("Has pulsado en NO");
            piezas.addAll(IniciarJuego(dni_b, dni_n));
            
        }

        return piezas;
}


public ArrayList<Pieza> IniciarJuego(String dni_b, String dni_n) {
		/// Este metodo busca a los jugadores si existen y lo agregan a una nueva partida
	CrearJugador12 crearJug = new CrearJugador12();
	
	Jugador jug_b= catJugador.buscarExistencia(dni_b);
	if(jug_b==null){
		JOptionPane.showMessageDialog(null, "Jugador blanco debe registrarse para jugar");
		crearJug.setVisible(true);
		}
	
	Jugador jug_n= catJugador.buscarExistencia(dni_n);
	if(jug_n==null){
		JOptionPane.showMessageDialog(null, "Jugador Negro debe registrarse para jugar");
		crearJug.setVisible(true);
		
		/*crearJug.showDialog();*/
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
	catJugador.add(j);
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
	
	
}