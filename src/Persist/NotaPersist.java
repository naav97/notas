package Persist;

import java.sql.*;

public class NotaPersist {
	
	private final static String url = "jdbc:sqlite:Notas.db";
	
	private Connection conn;
	
	public NotaPersist() {
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
	
	public void agregarNota(String pNombre, double pPorcentage, double pPuntos, String pObtenida, String pClase) throws Exception {
		String sql = "INSERT INTO Notas(Nombre,Porcentage,Puntos,Obtenida,Clase) VALUES(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pNombre);
		ps.setDouble(2, pPorcentage);
		ps.setDouble(3, pPuntos);
		ps.setString(4, pObtenida);
		ps.setString(5, pClase);
		ps.executeUpdate();
	}

}
