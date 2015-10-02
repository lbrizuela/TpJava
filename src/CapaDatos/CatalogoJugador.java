package CapaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import capaEntidad.Jugador;

public class CatalogoJugador {

public Jugador buscarExistencia(String dni) {
		// Este metodo busca un jugador en BD
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Jugador j=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select dni, nombre, apellido from jugador where dni = ?"
					);
			stmt.setString(1,dni);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				j=new Jugador();
				j.setDni(rs.getString("dni"));
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return j;
}

public void add(Jugador jug) {
		// Este metodo agrega un jugador en la BD
		ResultSet rs=null;
		PreparedStatement stmt=null;
	
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into jugador(dni, nombre, apellido) values (?,?,?)");
			
			stmt.setString(1, jug.getDni());
			stmt.setString(2, jug.getNombre());
			stmt.setString(3, jug.getApellido());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}
	}
}
		

