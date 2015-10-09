package capaEntidad;

public class Rey extends Pieza {
	public  boolean validarMovimiento(String a,String b,String color) {
		boolean respuesta= false;
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distanciaNumero=Math.abs(c-d);
		int distanciaLetra=Math.abs(a.charAt(0)-b.charAt(0));
     	if(distanciaLetra==distanciaNumero)
     	{
     		if(distanciaLetra==1)
     		{
     			respuesta=true;
     		}
     	}
     	if(distanciaLetra==0)
     	{
     		if(distanciaNumero==1)
     		{
     			respuesta=true;
     		}
     	}
     	if(distanciaLetra==1)
     	{
     		if(distanciaNumero==0)
     		{
     			respuesta=true;
     		}
     	}
     	return respuesta;
}
	
	
	public  void inicializarPiezas(String id, String col, String pos)
	{
		id_pieza=id;
		nombre="Rey";
		color=col;
		if(pos.equals(""))
		{
			if(color=="blanco")
			{
				posicion= "e8";
			}
			else
			{
				posicion="e1";
			}
		}
		else
		{
			posicion=pos;
		}
	}

}

