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
	
        
	public  void inicializarPiezas(String id, String col,String pos)
	{
	
		id_pieza=id;
		nombre="Caballo";
		color=col;
		if(pos.equals("inicio"))
		{
			if(color=="blanco" )
			{
				if(id=="c1"){
					posicion="b8";
					}
				else
				{
					posicion="g8";
				}
			}
			else 
				if(id=="c1"){
					posicion="b1";
					}
				else
				{
					posicion="g1";
				}
		}else
		{
			posicion=pos;
		}
		
	}

}



