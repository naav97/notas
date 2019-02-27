package Persist;

import java.sql.*;
import java.util.ArrayList;

import mundo.Nota;

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
	
	public void agregarNota(Nota n) throws Exception {
		String sql = "INSERT INTO Notas(Nombre,Porcentage,Puntos,Obtenida,Clase) VALUES(?,?,?,?,?)";
		Connection c = conect();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, n.getNombre());
		ps.setDouble(2, n.getPorcentage());
		ps.setDouble(3, n.getPuntos());
		if(n.isObtenida()) {
			ps.setString(4, "Y");
		}
		else {
			ps.setString(4, "N");
		}
		ps.setString(5, n.getNombreClase());
		ps.executeUpdate();
	}
	
	public ArrayList<Nota> darNotas() throws Exception {
		String sql = "SELECT * FROM Notas";
		Connection c = conect();
		Statement stmt  = c.createStatement();
		ResultSet rs    = stmt.executeQuery(sql);
		ArrayList<Nota> re = new ArrayList<>();
		while(rs.next()) {
			Nota n = new Nota(rs.getString("Nombre"), rs.getDouble("Porcentage"), rs.getDouble("Puntos"), rs.getString("Obtenida"), rs.getString("Clase"));
			re.add(n);
		}
		return re;
	}
	
	public Nota darNota(String pNota) throws Exception {
		String sql = "SELECT * FROM Notas WHERE Nombre = ?";
		PreparedStatement pstmt  = conn.prepareStatement(sql);
		pstmt.setString(1, pNota);
		ResultSet rs  = pstmt.executeQuery();
		Nota n = new Nota(rs.getString("Nombre"), rs.getDouble("Porcentage"), rs.getDouble("Puntos"), rs.getString("Obtenida"), rs.getString("Clase"));
		return n;
	}

}
