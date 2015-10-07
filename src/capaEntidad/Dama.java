package capaEntidad;

public class Dama extends Pieza {
	public boolean validarMovimiento(String a, String b, String color) {
		boolean respuesta= false;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distanciaNumero=Math.abs(c-d);
		int distanciaLetra=Math.abs(a.charAt(0)-b.charAt(0));
		if(c==d && a.substring(0, 1)!= b.substring(0, 1))
		{
			respuesta=true;
		}
		if(a.substring(0, 1)== b.substring(0, 1) && c!=d )
		{
			respuesta= true;
		}
		if(distanciaNumero==distanciaLetra)
		{
			respuesta=true;
		}
		return respuesta;
	}
	
	public  void inicializarPiezas(String id, String col)
	{
		id_pieza=id;
		nombre="Dama";
		color=col;
		if(color=="blanco")
		{
			posicion= "d8";
		}
		else
		{
			posicion="d1";
		}
	}
}



/*
package Clases;

public class dama extends Pieza {

	public Dama(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esvalidoMovimiento(String a, String b, String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distancia=Math.abs(c-d);
		if((a.substring(0,1).equals(b.substring(0,1)) | c==d )|(!a.substring(0,1).equals(b.substring(0,1)) && c!=d ))
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
