package CapaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;









import capaEntidad.*;
public class CatalogoPiezas {
private static ArrayList<Pieza> piezas;


public ArrayList<Pieza> iniciarJugo( String dni_b, String dni_n)
{
	piezas = new ArrayList<Pieza>();
	iniciarPiezas("blancas");
	iniciarPiezas("negras");
	agregarPiezas(dni_b, dni_n);
	return piezas;
	
}
	
public void iniciarPiezas(String a)
{

  
  Pieza p;
  p= new Rey();
  p.inicializarPiezas("r1",a);
 
  piezas.add(p);
  p=new Dama();
  p.inicializarPiezas("d1",a);
 
  piezas.add(p);
  p=new Alfil();
  p.inicializarPiezas("a1",a);
 
  piezas.add(p);
  p=new Alfil();
  p.inicializarPiezas("a2",a);

  piezas.add(p);
  p=new Caballo();
  p.inicializarPiezas("c1",a);

  piezas.add(p);
  p=new Caballo();
  p.inicializarPiezas("c2",a);

  piezas.add(p);
  p=new Torre();
  p.inicializarPiezas("t1",a);
  
  piezas.add(p);
  p=new Torre();
  p.inicializarPiezas("t2",a);
 
  piezas.add(p);
  for(int i=1; i<9;i++)
  {
	  p=new Peon();
	  p.inicializarPiezas("p"+ Integer.toString(i),a);
	  
	  piezas.add(p);
  }
  
 
 
  
}



private void agregarPiezas(String dni_b, String dni_n) {
	
	PreparedStatement stmt= null;
	for (Pieza pieza : piezas) {
		try{
	
	stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into pieza(dni_j1, dni_j2, id_pieza, nombre, color, posicion) values (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	stmt.setString(1, dni_b);
	stmt.setString(2, dni_n);
	stmt.setString(3, pieza.getId_pieza());
	stmt.setString(4, pieza.getNombre());
	stmt.setString(5, pieza.getColor());
	stmt.setString(6, pieza.getPosicion());
	stmt.execute();
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	FactoryConexion.getInstancia().releaseConn();
	
	
}

/*public String Lista(ArrayList<Pieza> p)
{
	String resultado=null;
	for(Pieza i:p)
	{
	
	resultado+=i.getNombre()+" "+i.getColor()+" "+i.getPosicion()+"\n";
	}
	return resultado;
}*/

public ArrayList<Pieza> colecPiezas(String dni_b, String dni_n)
{
	PreparedStatement stmt= null;
	ResultSet rst= null;
	
	try {
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement("Select * from pieza where dni_j1=? and dni_j2=?");

	stmt.setString(1,dni_b);
	stmt.setString(2, dni_n);
	rst= stmt.executeQuery();
	if(rst!= null && rst.next()){
	for (Pieza pieza : piezas) {
		pieza.setId_pieza(rst.getString("id_pieza"));
		pieza.setNombre(rst.getString("nombre"));
		pieza.setColor(rst.getString("color"));
		pieza.setPosicion(rst.getString("posicion"));
		////No se como si ya sabe de que clase es???
		piezas.add(pieza);
		rst.next();
		
	}
	
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally
	{
		try {
			
			if(stmt!=null) stmt.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConn();
	}
	return piezas;
}


public Pieza buscarFicha(String color,String pos)
{
	for(Pieza i:piezas)
	{
		if(i.getPosicion().equals(pos))
			if(i.getColor().equals(color))
			{
			   return i;
			}
	}
	return null;

}
public boolean borrarFicha(String color,String destino)
{
	boolean resp;
	Pieza p;
	if(color=="blanco")
		p=this.buscarFicha("negro", destino);
	else
		p=this.buscarFicha("blanco", destino);
	
	if(p.getClass().equals("Rey"))
		resp=false;
	else 
		resp=true;
	return resp;
	
	
}


public ArrayList<Pieza> moverFicha(String color,String origen,String destino)
{
	this.buscarFicha(color,origen).setPosicion(destino);
	
	
	
	
	return piezas;
}

public void UpFichas(ArrayList<Pieza> pie, String dni_b, String dni_n)
{
	PreparedStatement stmt= null;
	for (Pieza pieza : pie) {
		try{
	
	stmt= FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Pieza SET posicion= ? where dni_j1=? and dni_j2=?");
	stmt.setString(2, dni_b);
	stmt.setString(3, dni_n);
	stmt.setString(1, pieza.getPosicion());
	stmt.execute();
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	FactoryConexion.getInstancia().releaseConn();
	//No se si tengo que cerrar en todas las iteraciones la base.


}
}



