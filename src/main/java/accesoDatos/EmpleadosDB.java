package accesoDatos;

import static accesoDatos.Conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import personas.Administrativo;

public class EmpleadosDB {

    private static final String SELECT_ALL = "select * from empleados join administrativos on empleados.dni = administrativos.dni";

    public static ArrayList<Administrativo> leeAdministrativos() throws SQLException {
        ArrayList<Administrativo> lista_empleados = new ArrayList<>();

        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);

        while (resultSet.next()) {
            String dni = resultSet.getString("dni");
            String nombre = resultSet.getString("nombre");
            String apellido_1 = resultSet.getString("apellido_1");
            String apellido_2 = resultSet.getString("apellido_2");
            
        }

        return lista_empleados;
    }

}
