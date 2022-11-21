package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private final static String CONEXION = "jdbc:sqlite:recursos/empresa_db.db";
	private final static String USUARIO = "";
	private final static String PASS = "";

	public static Connection conexion;

	public static void abreConexion() throws SQLException {
		conexion = DriverManager.getConnection(CONEXION);
	}

	public static Connection getConexion() {
		return conexion;
	}
}
