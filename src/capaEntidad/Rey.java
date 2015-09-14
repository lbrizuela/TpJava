package capaEntidad;

public class Rey extends Pieza {
	public  boolean validarMovimiento()
	{
		return true;
	}
	public  void inicializarPiezas(String id, String col)
	{
		id_pieza=id;
		nombre="Rey";
		color=col;
		if(color=="blanco")
		{
			posicion= "e8";
		}
		else
		{
			posicion="e1";
		}
	}

}
