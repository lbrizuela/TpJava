package CapaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;













import capaEntidad.*;
public class CatalogoPiezas {
 


public ArrayList<Pieza> iniciarPiezas( String dni_b, String dni_n){
	//Este metodo es llama los metodos para agregar las piezas al juego y la bd
	
	ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	crearPiezas("blancas");
	crearPiezas("negras");
	addPiezas(dni_b, dni_n,piezas);
	return piezas;
	
}




public void crearPiezas(String a){
//Este metodo devulve las piezas en su posicion inicial

  ArrayList<Pieza> piezas = new ArrayList<Pieza>();
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






private void addPiezas(String dni_b, String dni_n, ArrayList<Pieza> piezas) {
	
/// Este metodo crea las piezas en la Bd
	
	PreparedStatement stmt= null;
	
	for (Pieza pieza : piezas) {
		try{
	
	stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into posicion(dni_j1, dni_j2, colYfila, Pieza, color) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	stmt.setString(1, dni_b);
	stmt.setString(2, dni_n);
	stmt.setString(3, pieza.getPosicion());
	stmt.setString(4, pieza.getId_pieza());
	stmt.setString(5, pieza.getColor());
	
	stmt.execute();
	}
		catch (SQLException e) {
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
	}
		
}





public ArrayList<Pieza> buscarPiezas(String dni_b, String dni_n)
{
	//Este metodo busca las piezas en la DB y devuelve el arreglo de piezas inicializadas
	
	ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	Pieza p=null;
	PreparedStatement stmt= null;
	ResultSet rst= null;
	
	try {
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement("Select * from posicion where dniB=? and dniN=?");

	stmt.setString(1,dni_b);
	stmt.setString(2, dni_n);
	rst= stmt.executeQuery();
	while(rst!= null && rst.next())
	{
		switch( rst.getString("Pieza"))
		{
		case "r":
		{ 
			p=new Rey();
			break;
		}
		case "d":
		{
			p=new Dama();
			break;
		}
		case "t":
		{
			p=new Torre();
			break;
		}
		case "p":
		{
			p= new Peon();
			break;
		}
		case "c":
		{
			p= new Caballo();
			break;
		}
		case "a":
		{
			p=new Alfil();
			break;
		}
	}	
		p.setPosicion(rst.getString("colYfila"));
		p.setColor(rst.getString("color"));
		p.setId_pieza(rst.getString("Pieza"));
		piezas.add(p);
		rst.next();
		
	}
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally
	{
		try {
			
			if(stmt!=null) stmt.close();
			if(rst!=null) rst.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConn();
	}
	return piezas;
}







public Pieza buscarFicha(ArrayList<Pieza> piezas,String color,String pos){
// Este metodo busca una ficha del un arreglo 
	
	
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







public ArrayList<Pieza> borrarFicha(ArrayList<Pieza> piezas,String color,String destino)
{
//Este metodo borra(pone en null su posicion) a una ficha comida 

	if(color=="blanco")
		{this.buscarFicha(piezas,"negro", destino).setPosicion(null);}
	else
		{this.buscarFicha(piezas,"blanco", destino).setPosicion(null);}

	return piezas;	
}







public boolean reyNulo(ArrayList<Pieza> piezas){ 
	//Este metodo verifica si el rey es nulo

	for (Pieza pieza : piezas) {
		if(pieza.getClass().equals("Rey"))
			if(pieza.getPosicion()== null)
			{
				return true;
			}
			
			
	}
	return false;
}






public ArrayList<Pieza> moverFicha(ArrayList<Pieza> piezas,String color,String origen,String destino){
	//Este metodo mueve las fichas
	
	this.buscarFicha(piezas,color,origen).setPosicion(destino);
	return piezas;
}






public void UpFichas(ArrayList<Pieza> pie, String dni_b, String dni_n)
{
	//Este metodo actualizas las posiciones de la ficha

	PreparedStatement stmt= null;
	for (Pieza pieza : pie) {
		try{
	stmt= FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE posicion SET posicion= ? where dniB=? and dniN=? and Pieza=? and color=?");
	stmt.setString(2, dni_b);
	stmt.setString(3, dni_n);
	stmt.setString(4, pieza.getId_pieza());
	stmt.setString(5, pieza.getColor());
	stmt.setString(1, pieza.getPosicion());
	stmt.execute();
	}
		catch (SQLException e) {
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
}
}








public void borrarPiezas(String dni, String dni2) {
	
	//Este metodo borra las Piezas
	PreparedStatement stmt=null;
	try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM posicion WHERE dniB=? and dniN=? ");
	
	stmt.setString(1, dni);
	stmt.setString(2, dni2);
	stmt.execute();
	
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
}
}



