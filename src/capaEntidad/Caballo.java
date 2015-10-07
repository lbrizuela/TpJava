package capaEntidad;

public class Caballo extends Pieza{
	public boolean validarMovimiento(String a, String b, String color) {
		boolean respuesta=false;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
        int distanciaNumero=Math.abs(c-d);
        int distanciaLetra= Math.abs(a.charAt(0)- b.charAt(0));
        switch(distanciaLetra)
        {
        case 2:
        {
        	if(distanciaNumero==1)
        	{
        		respuesta=true;
        	}
    
        	break;
        }
        case 1:
        {
        	if(distanciaNumero==2)
        	{
        	respuesta= true;
        	}
  
        break;
        }
        }
        return respuesta;
	}
        
	public  void inicializarPiezas(String id, String col)
	{
	
		id_pieza=id;
		nombre="Caballo";
		color=col;
		if(color=="blanco" )
		{
			if(id=="a1"){
				posicion="b8";
				}
			else
			{
				posicion="g8";
			}
		}
		else 
			if(id=="a1"){
				posicion="b1";
				}
			else
			{
				posicion="g1";
			}
	}

}



/*
 package Clases;

public class Caballo extends Pieza {

	public Caballo(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esvalidoMovimiento(String a, String b, String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
        int distancia=Math.abs(c-d);
        if(!a.substring(0,1).equals(b.substring(0,1))& distancia==2)
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
