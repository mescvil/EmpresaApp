package accesoDatos;

import static accesoDatos.Conexion.conexion;
import static utilidades.Fechas.stringToGregorianCalendar;
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
import personas.Analista;
import personas.Empleado;
import personas.Programador;

public class EmpleadosDB {

    private static final String SELECT_ADMINISTRATIVOS = "select * from empleados join "
            + "administrativos on empleados.dni = administrativos.dni";

    private static final String SELECT_PROGRAMADORES = "select * from empleados join "
            + "programadores on empleados.dni = programadores.dni";

    private static final String SELECT_ANALISTAS = "select * from empleados join "
            + "analistas on empleados.dni = analistas.dni";

    /**
     * Lee todos los empleados presentes en la BBDD
     *
     * @return ArrayList con todos los empleados
     * @throws CargaDatosException En caso de error en la lectura de algún tipo de empelado
     */
    public static ArrayList<Empleado> leeEmpleados() throws CargaDatosException {
        ArrayList<Empleado> lista_empleados = new ArrayList<>();

        lista_empleados.addAll(leeAdministrativos());
        lista_empleados.addAll(leeProgramadores());
        lista_empleados.addAll(leeAnalistas());

        return lista_empleados;
    }

    /**
     * Lee todos los programadores presentes en la BBDD
     *
     * @return ArrayList con todos los programadores
     * @throws CargaDatosException En caso de error en la lectura de los programadores
     */
    public static ArrayList<Programador> leeProgramadores() throws CargaDatosException {
        ArrayList<Programador> lista_empleados = new ArrayList<>();

        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_PROGRAMADORES);

            while (resultSet.next()) {

                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido_1 = resultSet.getString("apellido_1");
                String apellido_2 = resultSet.getString("apellido_2");
                String fecha_nacimiento = resultSet.getString("fecha_nacimiento");
                GregorianCalendar fecha_gregorian = stringToGregorianCalendar(fecha_nacimiento);
                Direccion direccion = new Direccion(resultSet.getString("direccion"));
                Oficina oficina = OficinasDB.leeOficina(resultSet.getString("cod_oficina"));

                Nivel nivel = Nivel.valueOf(resultSet.getString("nivel_experiencia"));
                String tecnologias = resultSet.getString("tecnologias");

                lista_empleados.add(new Programador(dni, nombre, apellido_1, apellido_2, fecha_gregorian, direccion,
                        oficina, nivel));

                lista_empleados.get(lista_empleados.size() - 1).setTecnologias(tecnologias.split(","));
            }
        } catch (ParseException ex) {
            throw new CargaDatosException("Error al crear la fecha de nacimiento");
        } catch (LongitudNoValidaException | DniNoValidoException | SQLException ex) {
            throw new CargaDatosException("Error al leer y crear un empleado: " + ex.getMessage());
        }

        return lista_empleados;
    }

    /**
     * Lee todos los analistas presentes en la BBDD
     *
     * @return ArrayList con todos los analistas
     * @throws CargaDatosException En caso de error en la lectura de los analistas
     */
    public static ArrayList<Analista> leeAnalistas() throws CargaDatosException {
        ArrayList<Analista> lista_empleados = new ArrayList<>();

        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ANALISTAS);

            while (resultSet.next()) {

                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido_1 = resultSet.getString("apellido_1");
                String apellido_2 = resultSet.getString("apellido_2");
                String fecha_nacimiento = resultSet.getString("fecha_nacimiento");
                GregorianCalendar fecha_gregorian = stringToGregorianCalendar(fecha_nacimiento);
                Direccion direccion = new Direccion(resultSet.getString("direccion"));
                Oficina oficina = OficinasDB.leeOficina(resultSet.getString("cod_oficina"));

                String titulacion = resultSet.getString("titulacion");
                String tecnologias = resultSet.getString("tecnologias");

                lista_empleados.add(new Analista(dni, nombre, apellido_1, apellido_2, fecha_gregorian, direccion,
                        oficina, titulacion));

                lista_empleados.get(lista_empleados.size() - 1).setTecnologias(tecnologias.split(","));

            }
        } catch (ParseException ex) {
            throw new CargaDatosException("Error al crear la fecha de nacimiento");
        } catch (LongitudNoValidaException | DniNoValidoException | SQLException ex) {
            throw new CargaDatosException("Error al leer y crear un empleado: " + ex.getMessage());
        }

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
            ResultSet resultSet = statement.executeQuery(SELECT_ADMINISTRATIVOS);

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
            throw new CargaDatosException("Error al leer y crear un empleado: " + ex.getMessage());
        }

        return lista_empleados;
    }

}
