package capaEntidad;

public abstract class Pieza {
	
	String id_pieza;
	String color;
	String nombre;
	String posicion;
	



	public String getId_pieza() {
		return id_pieza;
	}


	public void setId_pieza(String id_pieza) {
		this.id_pieza = id_pieza;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void quePieza(String nombre, String Color)
	{
	
	
	}


	public abstract boolean validarMovimiento(String a, String b, String color);// Este metodo valida el movieminto de la pieza
	public abstract void inicializarPiezas(String id,String col,String pos); // Este metodo incializa las piezas


	
		


	

}
