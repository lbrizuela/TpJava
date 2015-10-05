package capaEntidad;

import CapaDatos.CatalogoPiezas;


public class Peon extends Pieza {
	boolean primerMovimiento;
	CatalogoPiezas cp=new CatalogoPiezas();
	Partida partida=new Partida();
	public  boolean validarMovimiento(String a, String b,String color) {
		
	   boolean reps=true;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
	
	int distancia = color.contentEquals("negra")? (c-d) : (d-c);  //Hago la pregunta de que color es
	switch (distancia)                                           //el calculo de la distancia dependera de que color sea,esto se debe	                                                             // a como avanzan las fichas blancas y las negras entonces sera 	                                                             // un movimiento valido si la distancia entre que recorre es 	                                                             // si la distancia es negativa recorreria hacia atras y no es valido
	{
	case 1:
	{
		if(a.substring(0,1)!= b.substring(0,1))
		{
			if(cp.buscarFicha(partida.getPiezas(), colorInverso() , b)!=null)
			{
			reps=true;
			}
			else
			{
			reps=false;
			}
		}
		else 
		{
			reps=true;
		}
		break;
		
	}
	case 2:
	{
		
		if(primerMovimiento){
			reps=true;
			}
		else {
			reps=false;
				}
		
		break;
	}	
	
	}
	return reps;
	}
	
	public String colorInverso()
	{
		//Este metodo devuelve el color
		if(getColor()=="blanco")
		{
			return "negro";
		}
		else 
		{
			return"blanco";
		}
	}
	


	public  void inicializarPiezas(String id, String col)
	{
		id_pieza=id;
		primerMovimiento=true;
		nombre="Peon";
		color=col;
		if(color=="blanco")
		{
			ponerPosicion(7, id.substring(1));
		}
		else
		{ 
		    ponerPosicion(2,id.substring(1));	
		}
	}
	private void ponerPosicion(int i, String indexOf) {
		
		
	switch(Integer.parseInt(indexOf)){
		case 1:
			posicion= "a"+i;
			break;
		case 2:
			posicion="b"+ i;
			break;
		case 3:
			posicion="c"+ i;
			break;
		case 4:
			posicion="d"+ i;
			break;
		case 5:
			posicion="e"+ i;
			break;
		case 6:
			posicion="f"+ i;
			break;
		case 7:
			posicion="g"+ i;
			break;
		case 8:
			posicion="h"+ i;
			break;
		
		
	}
	}
}

/*
 * public class Peon extends Pieza {
private boolean esPeon=true;
	public Peon(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}
public boolean esPeon()
{
	return esPeon;
}
	@Override
	public boolean esvalidoMovimiento(String a, String b,String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
	
	int distancia = color.contentEquals("negra")? (c-d) : (d-c);  //Hago la pregunta de que color es
	if(distancia==1)                                               //el calculo de la distancia dependera de que color sea,esto se debe
		                                                             // a como avanzan las fichas blancas y las negras entonces sera 
		                                                             // un movimiento valido si la distancia entre que recorre es 1 
		                                                             // si la distancia es negativa recorreria hacia atras y no es valido
	{
		return true;
	}
	else
	{
	return false;
	}
	}
	

}

 */
 


