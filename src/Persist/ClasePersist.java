package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import mundo.Clase;

public class ClasePersist {
	
	private final static String url = "jdbc:sqlite:Notas.db";
	
	private Connection conn;
	
	public ClasePersist() {
		try {
			conn = DriverManager.getConnection(url);
		}
		catch(Exception e) {
			System.out.println("No se pudo conectar a la base de datos :( " + e);
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
				System.out.println("Algo salio muy mal: " + e);
			}
		}
	}
	
	public void agregarClase(String pClase) throws Exception {
		String sql = "INSERT INTO Clases(Nombre) VALUES(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pClase);
		ps.executeUpdate();
	}
	
	/**public ArrayList<Clase> darClases(){
		String sql = "SELECT * FROM Clases";
	}**/

}
