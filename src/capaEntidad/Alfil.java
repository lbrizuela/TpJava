package capaEntidad;

public class Alfil extends Pieza{
	
	public  boolean validarMovimiento(String a, String b, String color)
	{int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
	int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
	if(!a.substring(0,1).equals(b.substring(0,1)) && c!=d )
	{
		return true;
	}
	else
	{
		return false;
	}
		
	}
	public  void inicializarPiezas(String id, String col)

	{ 
		id_pieza=id;
		nombre="Alfil";
		color=col;
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
			if(id=="a1"){
				posicion="c1";
				}
			else
			{
				posicion="f1";
			}
			
		
	}

}
