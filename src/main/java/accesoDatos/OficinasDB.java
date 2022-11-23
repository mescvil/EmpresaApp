/*
 */
package accesoDatos;

import static accesoDatos.Conexion.conexion;
import clases.Direccion;
import clases.Oficina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Escoz
 */
public class OficinasDB {

    private static final String SELECT_OFICINA = "select nombre,direccion from oficinas where codigo = ?";
    private static final String SELECT_ALL = "select * from oficinas";

    public static Oficina leeOficina(String codigo) throws SQLException {
        PreparedStatement statement = conexion.prepareStatement(SELECT_OFICINA);
        statement.setString(1, codigo);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            Direccion direccion = new Direccion(resultSet.getString("direccion"));

            return new Oficina(nombre, codigo, direccion);
        }
        return null;
    }

    public static ArrayList<Oficina> leeOficinas() throws SQLException {
        ArrayList<Oficina> lista_oficinas = new ArrayList<>();

        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);

        while (resultSet.next()) {
            String codigo = resultSet.getString("codigo");
            String nombre = resultSet.getString("nombre");
            Direccion direccion = new Direccion(resultSet.getString("direccion"));

            lista_oficinas.add(new Oficina(nombre, codigo, direccion));
        }

        return lista_oficinas;
    }
}
