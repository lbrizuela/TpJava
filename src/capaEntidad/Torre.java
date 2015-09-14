package capaEntidad;

public class Torre extends Pieza {

	public  boolean validarMovimiento()
	{
		return true;
	}
	public  void inicializarPiezas(String id, String col)
	{
		id_pieza=id;
		nombre="Torre";
		color=col;
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
			if(id=="t1"){
			posicion="a1";
			}
			else
			{
			posicion="h1";
			}
	}
}
