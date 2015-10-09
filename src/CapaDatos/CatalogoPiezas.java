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
	piezas.addAll(crearPiezas("blanco"));
	piezas.addAll(crearPiezas("negro"));
	addPiezas(dni_b, dni_n,piezas);
	return piezas;
	
}




public ArrayList<Pieza>  crearPiezas(String a){
//Este metodo devulve las piezas en su posicion inicial

  ArrayList<Pieza> piezas = new ArrayList<Pieza>();
  Pieza p;
  p= new Rey();
  p.inicializarPiezas("r1",a,"");
 
  piezas.add(p);
  p=new Dama();
  p.inicializarPiezas("d1",a,"");
  piezas.add(p);
  
  p=new Alfil();
  p.inicializarPiezas("a1",a,"");
  piezas.add(p);
  
  p=new Alfil();
  p.inicializarPiezas("a2",a,"");
  piezas.add(p);
  
  p=new Caballo();
  p.inicializarPiezas("c1",a,"");
  piezas.add(p);
  
  p=new Caballo();
  p.inicializarPiezas("c2",a,"");
  piezas.add(p);
  
  p=new Torre();
  p.inicializarPiezas("t1",a,"");
  piezas.add(p);
  
  p=new Torre();
  p.inicializarPiezas("t2",a,"");
  piezas.add(p);
  
  for(int i=1; i<9;i++)
  {
	  p=new Peon();
	  p.inicializarPiezas("p"+ Integer.toString(i),a,"");	  
	  piezas.add(p);
  }
  return piezas;
  
}






private void addPiezas(String dni_b, String dni_n, ArrayList<Pieza> piezas) {
	
/// Este metodo crea las piezas en la Bd
	

	for (Pieza pieza : piezas) {
		PreparedStatement stmt= null;
		
		try{
	
	stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into posicion(dniB, dniN, colYfila, Pieza, color) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
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
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement("select Pieza, colYfila, color from posicion where dniB=? and dniN=?");

	stmt.setString(1,dni_b);
	stmt.setString(2, dni_n);
	rst= stmt.executeQuery();
	while(rst!= null && rst.next())
	{ 
		
		switch((rst.getString("Pieza")).substring(0, 1))
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
		p.inicializarPiezas(rst.getString("Pieza"),rst.getString("color"), rst.getString("colYfila"));		
		piezas.add(p);
	
		
	}
	
	
	} 
	catch (SQLException e) {
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














public void borrarFicha(ArrayList<Pieza> piezas,String color,String destino)
{
//Este metodo borra(pone en null su posicion) a una ficha comida 
    
	Pieza p;

	if(color.equals("blanco"))
		{
		p=buscarFicha(piezas,"negro", destino);
		if(p!=null){
		p.setPosicion("");}
		}
	else
		{
		p=buscarFicha(piezas,"blanco", destino);
		if(p!=null){
		p.setPosicion("");
		}
		}
	

	
}







public boolean reyNulo(ArrayList<Pieza> piezas){ 
	//Este metodo verifica si el rey es nulo

	for (Pieza pieza : piezas) {
		if(pieza.getNombre().equals("Rey"))
			if(pieza.getPosicion().equals(""))
			{
				return true;
			}
			
			
	}
	return false;
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




public void  moverFicha(ArrayList<Pieza> piezas,String color,String origen,String destino){
	//Este metodo mueve las fichas
	Pieza p= null;
	p=buscarFicha(piezas,color,origen);
	p.setPosicion(destino);

}






public void UpFichas(ArrayList<Pieza> pie, String dni_b, String dni_n)
{
	//Este metodo actualizas las posiciones de la ficha

	PreparedStatement stmt= null;
	for (Pieza pieza : pie) {
		try{
	stmt= FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE posicion SET colYfila= ? where dniB=? and dniN=? and Pieza=? and color=?");
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
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM Posicion WHERE dniB=? and dniN=? ");
	
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



