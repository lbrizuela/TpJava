package CapaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import capaEntidad.*;

public class CatalogoPartidas {
	CatalogoJugador cj;
	CatalogoPiezas cp;

	public Partida buscarPartida(String dni_b, String dni_n) {
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
				j_b=cj.buscarExistencia(rs.getString("dniB"));
				j_n=cj.buscarExistencia(rs.getString("dniN"));
				partida=new Partida();
				partida.setJ_b(j_b);
				partida.setJ_n(j_n);
				partida.setTurno(rs.getString("Turno"));
				
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
		Partida p= new Partida();
		agregoPartida(ju_n.getDni(), ju_n.getDni());
		ArrayList<Pieza> pieza= new ArrayList<Pieza>();
		pieza.addAll(cp.iniciarJugo(ju_b.getDni(), ju_n.getDni()));
		p.setJ_b(ju_b);
		p.setJ_n(ju_n);
		p.setPiezas(pieza);
		p.setTurno("blanco");
		return p;
		
	}

	private void agregoPartida(String dni, String dni2) {
		PreparedStatement stmt=null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("insert into Partida(dniN, dniB, turno) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
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

	
	
	public void UpPatida(Partida p)
	{
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Partida SET Turno= ? where dniB=? and dniN=?");
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

}
