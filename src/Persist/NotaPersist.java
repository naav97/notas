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
		ps.setInt(5, n.getIDClase());
		ps.executeUpdate();
	}
	
	public ArrayList<Nota> darNotas() throws Exception {
		String sql = "SELECT * FROM Notas";
		Connection c = conect();
		Statement stmt  = c.createStatement();
		ResultSet rs    = stmt.executeQuery(sql);
		ArrayList<Nota> re = new ArrayList<>();
		while(rs.next()) {
			Nota n = new Nota(rs.getInt("id"), rs.getString("Nombre"), rs.getDouble("Porcentage"), rs.getDouble("Puntos"), rs.getString("Obtenida"), rs.getInt("Clase"));
			re.add(n);
		}
		return re;
	}
	
	public ArrayList<Nota> darNotasClase(int clase) throws Exception {
		String sql = "SELECT * FROM Notal WHERE Clase = ?";
		Connection c = conect();
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setInt(1, clase);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Nota> re = new ArrayList<>();
		while(rs.next()) {
			Nota n = new Nota(rs.getInt("id"), rs.getString("Nombre"), rs.getDouble("Porcentage"), rs.getDouble("Puntos"), rs.getString("Obtenida"), rs.getInt("Clase"));
			re.add(n);
		}
		return re;
	}
	
	public Nota darNota(int id) throws Exception {
		String sql = "SELECT * FROM Notas WHERE id = ?";
		Connection c = conect();
		PreparedStatement pstmt  = c.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs  = pstmt.executeQuery();
		Nota n = new Nota(rs.getInt("id"), rs.getString("Nombre"), rs.getDouble("Porcentage"), rs.getDouble("Puntos"), rs.getString("Obtenida"), rs.getInt("Clase"));
		return n;
	}
	
	public void updateNombre(int id, String nombre) throws Exception {
		String sql = "UPDATE Notas SET Nombre = ? WHERE id = ?";
		Connection c = conect();
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setString(1, nombre);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
	}
	
	public void updatePorcentage(int id, double porcentage) throws Exception {
		String sql = "UPDATE Notas SET Porcentage = ? WHERE id = ?";
		Connection c = conect();
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setDouble(1, porcentage);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
	}
	
	public void updatePuntos(int id, double puntos) throws Exception {
		String sql = "UPDATE Notas SET Puntos = ? WHERE id = ?";
		Connection c = conect();
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setDouble(1, puntos);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
	}
	
	public void updateObtenida(int id, String obtenida) throws Exception {
		String sql = "UPDATE Notas SET Obtenida = ? WHERE id = ?";
		Connection c = conect();
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setString(1, obtenida);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
	}
	
	public void updateClase(int id, String clase) throws Exception {
		String sql = "UPDATE Notas SET Clase = ? WHERE id = ?";
		Connection c = conect();
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setString(1, clase);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
	}
	
	public void deleteNota(int id) throws Exception {
		String sql = "DELETE FROM Notas WHERE id = ?";
		Connection c = conect();
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
	}
}
