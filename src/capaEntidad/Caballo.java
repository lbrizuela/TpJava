package capaEntidad;

public class Caballo extends Pieza{
	public  boolean validarMovimiento()
	{
		return true;
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
