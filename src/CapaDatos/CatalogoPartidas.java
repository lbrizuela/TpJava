package CapaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import capaEntidad.*;

public class CatalogoPartidas {
	
	
	public Partida buscarJugadorPorDni(String dni_b, String dni_n) {
		Partida partida=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from partida where dniB = ? and dniN=?");
		stmt.setString(1,dni_b);
		stmt.setString(2,dni_n);
		rs= stmt.executeQuery();
		if(rs !=null && rs.next()){
		partida=new Partida();
		partida.setDnb(rs.getString("dniB"));
		partida.setDnb(rs.getString("dniN"));
		partida.setTurno(rs.getString("turno"));
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		try {
			if(rs!=null)rs.close();
			if(stmt!=null) stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConn();
	}
	return partida;
}

	public void agregarJugadores(String dniB, String dniN) {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into Partida(dniB, dniN, Turno) values (?,?,?)");
			stmt.setString(1, dniB);
			stmt.setString(2, dniN);
			stmt.setString(3, "blanco");
			 stmt.executeUpdate();
			
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
	
	
		
	


/*
	public Partida buscarJugadorPorDni(String dni_b, String dni_n) {
		Partida partida=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from partida where dniB = ? and dniN=?");
			stmt.setString(1, dni_b);
			stmt.setString(2, dni_n);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				Jugador j_b, j_n;
				j_b=buscarPersona(rs.getString("dni_j1"));
				j_n=buscarPersona(rs.getString("dni_j2"));
				partida=new Partida();
				partida.setDnib();;
				partida.setDnin(dnin);
				partida.setTurno(rs.getString("turno"));
				
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

	private Jugador buscarPersona(String string) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Jugador j=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from jugador where dni = ?");
			stmt.setString(1, string);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				j=new Jugador();
				j.setDni(rs.getString("dni"));
				j.setColor(rs.getString("color"));
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
		
				
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
		return j;
	}

	public Partida agregarJugadores(Jugador ju_b, Jugador ju_n, ArrayList<Pieza> pieza) {
		Partida p= new Partida();
		agregoJugador(ju_b);
		agregoJugador(ju_n);
		agregoPartida(ju_n.getDni(), ju_n.getDni());
		p.setJ_b(ju_b);
		p.setJ_n(ju_n);
		p.setPiezas(pieza);
		p.setTurno("blanco");
		return p;
		
	}

	private void agregoPartida(String dni, String dni2) {
		PreparedStatement stmt=null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into Partida(dni_j1, dni_j2, turno) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, dni);
			stmt.setString(2, dni2);
			stmt.setString(3, "blanco");
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

	private void agregoJugador(Jugador j) {
		PreparedStatement stmt=null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into Jugador(dni, nombre, apellido, color) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, j.getDni());
			stmt.setString(2, j.getNombre());
			stmt.setString(2, j.getApellido());
			stmt.setString(4, j.getColor());
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
	
	public void UpPatida(Partida p)
	{
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Partida SET turno= ? where dni_j1=? and dni_j2=?");
			stmt.setString(1, p.getTurno());
			stmt.setString(2, p.getJ_b().getDni());
			stmt.setString(2, p.getJ_n().getDni());
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
*/
	

