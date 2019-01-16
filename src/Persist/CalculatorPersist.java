package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class CalculatorPersist {
	
	private final static String url = "jdbc:sqlite:Notas.db";
	
	private Connection conn;
	
	public CalculatorPersist() {
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

}
