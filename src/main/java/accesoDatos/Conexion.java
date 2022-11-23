package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final static String CONEXION = "jdbc:mysql://192.168.121.22:3306/empresa";
    private final static String USUARIO = "admin";
    private final static String PASS = "admin";

    public static Connection conexion;

    public static void abreConexion() throws SQLException {
        conexion = DriverManager.getConnection(CONEXION, USUARIO, PASS);
    }

    public static Connection getConexion() {
        return conexion;
    }
}
