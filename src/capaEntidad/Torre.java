package capaEntidad;

public class Torre extends Pieza {

	public  boolean validarMovimiento(String a, String b, String color) {
		boolean respuesta =false;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));//analizo la parte numerica de la posicion(cadena)
		String origen=a.substring(0, 1);
		String destino=b.substring(0, 1);
		if(origen.equals(destino))
		{
			if( c!=d )
			{
				respuesta= true;
			}
			
		}
		else
		
		{
			if(c==d){
				respuesta=true;
				}
		}
		return respuesta;
	}

	
	public  void inicializarPiezas(String id, String col, String pos)
	{
		id_pieza=id;
		nombre="Torre";
		color=col;
		if(pos.equals(""))
		{
			if(color=="blanco")
			{
				if(id=="t1"){
				posicion="a8";
				}
				else
				{
				posicion="h8";
				}
			}
			else 
			{
				if(id=="t1"){
				posicion="a1";
				}
				else
				{
				posicion="h1";
				}
			}
		}
		else
		{
			posicion=pos;
		}
	}
}


