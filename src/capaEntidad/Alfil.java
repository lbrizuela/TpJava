package capaEntidad;

public class Alfil extends Pieza{
	
	public  boolean validarMovimiento()
	{
		return true;
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
