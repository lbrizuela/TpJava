package capaEntidad;

public class Dama extends Pieza {
	public  boolean validarMovimiento()
	{
		return true;
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
