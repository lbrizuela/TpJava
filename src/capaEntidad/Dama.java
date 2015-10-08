package capaEntidad;

public class Dama extends Pieza {
	public boolean validarMovimiento(String a, String b, String color) {
		boolean respuesta= false;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		String origen=a.substring(0, 1);
		String destino=b.substring(0, 1);
		int distanciaNumero=Math.abs(c-d);
		int distanciaLetra=Math.abs(a.charAt(0)-b.charAt(0));
		if(origen.equals(destino) )
		{
			if(c!=d)
			{
				respuesta= true;
			}
			
		}
		else
		///////if(a.substring(0, 1)== b.substring(0, 1) && c!=d )
		{
			if(c==d){
				respuesta=true;
			}
			if(distanciaNumero==distanciaLetra)
			{
				respuesta=true;
			}
		}
		
		return respuesta;
	}
	
	public  void inicializarPiezas(String id, String col,String pos)
	{
		id_pieza=id;
		nombre="Dama";
		color=col;
		if(pos.equals("")){
			if(color=="blanco")
			{
				posicion= "d8";
			}
			else
			{
				posicion="d1";
			}
		}
		else 
		{
			posicion=pos;
		}
	}
		
}




