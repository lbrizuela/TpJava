package capaEntidad;

public class Peon extends Pieza {
	boolean primerMovimiento;
	public  boolean validarMovimiento() {
		return true;
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


