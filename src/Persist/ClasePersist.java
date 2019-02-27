package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public Connection conect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		}
		catch(Exception e) {
			System.out.println("No se pudo conectar a la base de datos :( " + e);
		}
		finally {
			try {
				if(con != null) {
					//con.close();
				}
			}
			catch(Exception e) {
				System.out.println("Algo salio muy mal: " + e);
			}
		}
		return con;
	}
	
	public void agregarClase(String pClase) throws Exception {
		String sql = "INSERT INTO Clases(Nombre) VALUES(?)";
		Connection c = conect();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, pClase);
		ps.executeUpdate();
	}
	
	public ArrayList<Clase> darClases() throws Exception{
		String sql = "SELECT * FROM Clases";
		Connection c = conect();
		Statement stmt  = c.createStatement();
		ResultSet rs    = stmt.executeQuery(sql);
		ArrayList<Clase> re = new ArrayList<>();
		while(rs.next()) {
			Clase r = new Clase(rs.getString("Nombre"));
			re.add(r);
		}
		return re;
	}
	
	public Clase darClase(String pClase) throws Exception {
		String sql = "SELECT * FROM Clases WHERE Nombre = ?";
		PreparedStatement pstmt  = conn.prepareStatement(sql);
		pstmt.setString(1, pClase);
		ResultSet rs  = pstmt.executeQuery();
		Clase re = new Clase(rs.getString("Nombre"));
		return re;
	}

}
