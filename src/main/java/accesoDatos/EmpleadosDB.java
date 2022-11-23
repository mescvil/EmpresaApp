package accesoDatos;

import static accesoDatos.Conexion.conexion;
import static extras.Fechas.stringToGregorianCalendar;
import clases.Direccion;
import clases.Nivel;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import personas.Administrativo;

public class EmpleadosDB {

    private static final String SELECT_ALL = "select * from empleados join administrativos on empleados.dni = administrativos.dni";

    public static ArrayList<Administrativo> leeAdministrativos() throws SQLException {
        ArrayList<Administrativo> lista_empleados = new ArrayList<>();

        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);

        while (resultSet.next()) {
            try {
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido_1 = resultSet.getString("apellido_1");
                String apellido_2 = resultSet.getString("apellido_2");
                String fecha_nacimiento = resultSet.getString("fecha_nacimiento");
                GregorianCalendar fecha_gregorian = stringToGregorianCalendar(fecha_nacimiento);
                Direccion direccion = new Direccion(resultSet.getString("direccion"));

                Oficina oficina = OficinasDB.leeOficina(resultSet.getString("cod_oficina"));
                Nivel nivel = Nivel.valueOf(resultSet.getString("nivel_ofimatica").toUpperCase());

                lista_empleados.add(new Administrativo(dni, nombre, apellido_1, apellido_2, fecha_gregorian, direccion,
                        oficina, nivel));

            } catch (ParseException ex) {
                throw new SQLException("Error al crear la fecha de nacimiento");
            } catch (LongitudNoValidaException | DniNoValidoException ex) {
                throw new SQLException("Error al leer y crear un empleado");
            }
        }

        return lista_empleados;
    }

}
