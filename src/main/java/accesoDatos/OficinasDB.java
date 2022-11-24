/*
 */
package accesoDatos;

import static accesoDatos.Conexion.conexion;

import clases.Direccion;
import clases.Oficina;
import excepciones.CargaDatosException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Escoz
 */
public class OficinasDB {

    private static final String SELECT_OFICINA = "select nombre,direccion from oficinas where codigo = ?";
    private static final String SELECT_ALL = "select * from oficinas";

    /**
     * Lee los datos de una oficina por un codigo dado
     *
     * @param codigo Codigo de oficina para realizar la busqueda
     * @return Oficina encontrada, en caso de no encontrarla retornará nulo
     * @throws CargaDatosException En caso de error en la lectura
     */
    public static Oficina leeOficina(String codigo) throws CargaDatosException {

        try {
            PreparedStatement statement = conexion.prepareStatement(SELECT_OFICINA);
            statement.setString(1, codigo);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                Direccion direccion = new Direccion(resultSet.getString("direccion"));

                return new Oficina(nombre, codigo, direccion);
            }
        } catch (SQLException ex) {
            throw new CargaDatosException("No es posible cargar esta oficina (" + codigo + ")");
        }
        return null;
    }

    /**
     * Lee todas las oficinas de la BBDD
     *
     * @return ArrayList con todas las oficinas, en caso de no encontrar ninguna retornará una lista vacia
     * @throws CargaDatosException En caso de error en la lectura
     */
    public static ArrayList<Oficina> leeOficinas() throws CargaDatosException {
        ArrayList<Oficina> lista_oficinas = new ArrayList<>();

        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String nombre = resultSet.getString("nombre");
                Direccion direccion = new Direccion(resultSet.getString("direccion"));

                lista_oficinas.add(new Oficina(nombre, codigo, direccion));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            throw new CargaDatosException("No es posible cargar las oficinas");
        }

        return lista_oficinas;
    }
}
