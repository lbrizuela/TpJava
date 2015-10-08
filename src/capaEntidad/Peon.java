package capaEntidad;

import java.io.StringWriter;

import CapaDatos.CatalogoPiezas;


public class Peon extends Pieza {
	boolean primerMovimiento;
	CatalogoPiezas cp=new CatalogoPiezas();
	Partida partida=new Partida();
	
	
	public  boolean validarMovimiento(String a, String b,String color) {
		
	   boolean respuesta=false;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distanciaLetra=Math.abs(a.charAt(0)-b.charAt(0));
		int distanciaNumero = color.equals("negro")? (d-c) : (c-d);  //Hago la pregunta de que color es
	
		switch (distanciaNumero) {                                        
		case 1:
		{
			if(distanciaLetra==1)
			{
				if(cp.buscarFicha(partida.getPiezas(), colorInverso() , b)!=null)
				{
					respuesta=true;
				}
			}else 
			{
				if(distanciaLetra==0)
				{
					respuesta=true;
				}
			}
			if(primerMovimiento)
			{
				primerMovimiento=false;
			}
			break;
		}
		case 2:
		{
			if(primerMovimiento)
			{
				if(distanciaLetra==0)
				{
					respuesta=true;
					primerMovimiento=false;
				}
			}	
		break;
		}
	}
		
	
	
	return respuesta;
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
	


	public  void inicializarPiezas(String id, String col, String pos)
	{
		id_pieza=id;
	
		nombre="Peon";
		color=col;
		if(pos.equals(""))
		{
			if(color.equals("blanco"))
			{
				ponerPosicion(7, id.substring(1));
			}
			else
			{ 
			    ponerPosicion(2,id.substring(1));	
			}
		}
		else
		{
			posicion=pos;
		}
		if(color.equals("blanco"))
		{
			buscarPosicion(7,posicion);
		}
		else
		{
			buscarPosicion(2,posicion);
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
	public void buscarPosicion(int a, String pos)
	{
		String inicio="a";
		String fin="h";
		char i=inicio.charAt(0);
		char f=fin.charAt(0);
		primerMovimiento=false;
		while(i<=f && primerMovimiento==false)
		{
			String p=String.valueOf(i)+a;
			if(p.equals(pos))
			{
				primerMovimiento=true;
			}
			i++;
		}
	
			
		
	}
}


 


