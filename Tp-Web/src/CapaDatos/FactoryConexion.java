package CapaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConexion {
	private String dbDriver="com.mysql.jdbc.Driver";
		private String host="localhost";
		private String port="3306";
		private String user="root";
		private String pass="Mariuchi1920";
		private String db="juegoajedrez";
		
		private Connection conn;
		private int cantCon;
		
		private FactoryConexion(){
			try {
				Class.forName(dbDriver);
				conn=null;
				cantCon=0;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		private static FactoryConexion instancia;
		
		public static FactoryConexion getInstancia(){
			if (instancia==null){
				instancia = new FactoryConexion();
			}
			return instancia;
		}
		
		
		
		public Connection getConn(){
			try {
				if(conn==null || conn.isClosed()){
					conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+pass);
					System.out.println("Se ha conectado correctamente");
					cantCon++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		
		public void releaseConn(){
			try {
				cantCon--;
				if(cantCon==0){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
