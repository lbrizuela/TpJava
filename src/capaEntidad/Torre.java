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


/*
 public class Torre extends Pieza {

	public Torre(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esvalidoMovimiento(String a, String b, String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		if(a.substring(0,1).equals(b.substring(0,1)) | c==d )
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
