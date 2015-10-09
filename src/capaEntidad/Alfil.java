package capaEntidad;

public class Alfil extends Pieza{
	
	public  boolean validarMovimiento(String a, String b, String color)
	{
		boolean respuesta= false;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distanciaNumero=Math.abs(c-d);
		int distanciaLetra=Math.abs(a.charAt(0)-b.charAt(0));
	if(distanciaNumero==distanciaLetra)
	{
		respuesta= true;
	}
    return respuesta; 
		
	}
	
	
	
	public  void inicializarPiezas(String id, String col, String pos)

	{ 
		id_pieza=id;
		nombre="Alfil";
		color=col;
		if(pos.equals(""))
		{
			if(color=="blanco" )
			{
				if(id=="a1"){
					posicion="c8";
				}
				else
				{
					posicion="f8";
				}
			}
			else 
			{
				if(id=="a1"){
					posicion="c1";
				}
				else{
					posicion="f1";
				}
			}
		}else 
		{
			posicion=pos;
		}
			
		
	}

}
