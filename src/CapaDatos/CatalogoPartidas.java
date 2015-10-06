package CapaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CapaDatos.FactoryConexion;
import capaEntidad.*;

public class CatalogoPartidas {
	CatalogoJugador cj;
	CatalogoPiezas cp;
	public CatalogoPartidas(){
		
	cj= new CatalogoJugador();
	cp =new CatalogoPiezas() ;
	}

public Partida buscarPartida(String dni_b, String dni_n) {
		//Este metodo busca una partida en la BD, si no la encuentra devuelve nuull
		
		
		Partida partida=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select dniB, dniN, Turno from Partida where dniB like ? and dniN like ?");
			stmt.setString(1, dni_b);
			stmt.setString(2, dni_n);
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()){
				Jugador j_b= new Jugador();
				Jugador j_n=new Jugador();
				partida=new Partida();
				partida.setTurno(rs.getString("Turno"));   // Marcaba Error por que al buscar los jugadores en la base se
				j_b=cj.buscarExistencia(dni_b);            // cerraba el resultset, entonces cuando queria guardar el turno
				j_n=cj.buscarExistencia(dni_n);            // el resultset estaba cerrado, por eso primero debe guardar el 
				partida.setJ_b(j_b);                       // turno y despues buscar los jugadores
				partida.setJ_n(j_n);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();	
			
		}
		return partida;
		
		
		
}

	

public Partida agregarPartida(Jugador ju_b, Jugador ju_n) {
		//Este metodo solo crea un objeto partida y llama a el metodo que lo agrega a la base
		
		Partida p= new Partida();
		addPartida(ju_b.getDni(), ju_n.getDni()); // Por BD primero debe agragar las partidas y dsps las piezas.
		p.setJ_n(ju_n); 
		p.setJ_b(ju_b);
		p.setPiezas(cp.iniciarPiezas(ju_b.getDni(), ju_n.getDni()));
		p.setTurno("blanco");
		return p;
		
}




private void addPartida(String dniB, String dniN) {
		//Este metodo crea una partida a DB
		
		PreparedStatement stmt=null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into Partida(dniB, dniN, Turno) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, dniB);
			stmt.setString(2, dniN);
			stmt.setString(3, "blanco");
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
			stmt.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
	
	  

	
}





	
public void UpPatida(Partida p){
	///Este metodo actualiza una partida.
	
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Partida SET Turno= ? where dniB=? and dniN=?");
			stmt.setString(1, p.getTurno());
			stmt.setString(2, p.getJ_b().getDni());
			stmt.setString(3, p.getJ_n().getDni());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
}







public void borrarPartida(String dni, String dni2) {
		// Este metodo borra una partida
		PreparedStatement stmt=null;
				
			try {
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM Partida WHERE dniB=? and dniN=? ");
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
					
					 stmt.close();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FactoryConexion.getInstancia().releaseConn();
			}
		
	}

}
