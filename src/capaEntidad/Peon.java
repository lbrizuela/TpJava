package capaEntidad;

public class Peon extends Pieza {
	boolean primerMovimiento;
	public  boolean validarMovimiento(String a, String b,String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
	
	int distancia = color.contentEquals("negra")? (c-d) : (d-c);  //Hago la pregunta de que color es
	if(distancia==1)                                               //el calculo de la distancia dependera de que color sea,esto se debe
		                                                             // a como avanzan las fichas blancas y las negras entonces sera 
		                                                             // un movimiento valido si la distancia entre que recorre es 1 
		                                                             // si la distancia es negativa recorreria hacia atras y no es valido
	{
		return true;
	}
	else
	{
	return false;
	}
	}
	


	public  void inicializarPiezas(String id, String col)
	{
		id_pieza=id;
		nombre="Peon";
		color=col;
		if(color=="blanco")
		{
			ponerPosicion(7, id.substring(1));
		}
		else
		{ 
		    ponerPosicion(2,id.substring(1));	
		}
	}
	private void ponerPosicion(int i, String indexOf) {
		
		
	switch(Integer.parseInt(indexOf)){
		case 1:
			posicion= "a"+indexOf;
			break;
		case 2:
			posicion="b"+ indexOf;
			break;
		case 3:
			posicion="c"+ indexOf;
			break;
		case 4:
			posicion="d"+ indexOf;
			break;
		case 5:
			posicion="e"+ indexOf;
			break;
		case 6:
			posicion="f"+ indexOf;
			break;
		case 7:
			posicion="g"+ indexOf;
			break;
		case 8:
			posicion="b"+ indexOf;
			break;
		
		
	}
	}
}

/*
 * public class Peon extends Pieza {
private boolean esPeon=true;
	public Peon(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}
public boolean esPeon()
{
	return esPeon;
}
	@Override
	public boolean esvalidoMovimiento(String a, String b,String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
	
	int distancia = color.contentEquals("negra")? (c-d) : (d-c);  //Hago la pregunta de que color es
	if(distancia==1)                                               //el calculo de la distancia dependera de que color sea,esto se debe
		                                                             // a como avanzan las fichas blancas y las negras entonces sera 
		                                                             // un movimiento valido si la distancia entre que recorre es 1 
		                                                             // si la distancia es negativa recorreria hacia atras y no es valido
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
 


