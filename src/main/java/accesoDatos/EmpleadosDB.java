package accesoDatos;

import static accesoDatos.Conexion.conexion;
import static extras.Fechas.stringToGregorianCalendar;
import clases.Direccion;
import clases.Nivel;
import clases.Oficina;
import excepciones.CargaDatosException;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import personas.Administrativo;
import personas.Empleado;

public class EmpleadosDB {

    private static final String SELECT_ALL = "select * from empleados join administrativos on empleados.dni = administrativos.dni";

    /**
     * Lee todos los empleados presentes en la BBDD
     *
     * @return ArrayList con todos los empleados
     * @throws CargaDatosException En caso de error en la lectura de algún tipo de empelado
     */
    public static ArrayList<Empleado> leeEmpleados() throws CargaDatosException {
        ArrayList<Empleado> lista_empleados = new ArrayList<>();

        lista_empleados.addAll(leeAdministrativos());

        return lista_empleados;
    }

    /**
     * Lee todos los administrativos presentes en la BBDD
     *
     * @return ArrayList con todos los administrativos
     * @throws CargaDatosException En caso de error en la lectura de los administrativos
     */
    public static ArrayList<Administrativo> leeAdministrativos() throws CargaDatosException {
        ArrayList<Administrativo> lista_empleados = new ArrayList<>();

        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()) {

                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido_1 = resultSet.getString("apellido_1");
                String apellido_2 = resultSet.getString("apellido_2");
                String fecha_nacimiento = resultSet.getString("fecha_nacimiento");
                GregorianCalendar fecha_gregorian = stringToGregorianCalendar(fecha_nacimiento);
                Direccion direccion = new Direccion(resultSet.getString("direccion"));

                Oficina oficina = OficinasDB.leeOficina(resultSet.getString("cod_oficina"));
                Nivel nivel = Nivel.valueOf(resultSet.getString("nivel_ofimatica"));

                lista_empleados.add(new Administrativo(dni, nombre, apellido_1, apellido_2, fecha_gregorian, direccion,
                        oficina, nivel));

            }
        } catch (ParseException ex) {
            throw new CargaDatosException("Error al crear la fecha de nacimiento");
        } catch (LongitudNoValidaException | DniNoValidoException | SQLException ex) {
            throw new CargaDatosException("Error al leer y crear un empleado");
        }

        return lista_empleados;
    }

}
