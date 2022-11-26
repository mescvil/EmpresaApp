package accesoDatos;

import static accesoDatos.Conexion.conexion;
import static utilidades.Fechas.stringToGregorianCalendar;
import clases.Direccion;
import clases.Nivel;
import clases.Oficina;
import excepciones.CargaDatosException;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
import java.sql.PreparedStatement;
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
import personas.Vendedor;

public class EmpleadosDB {

    public static String SIN_OFICINA = "sin oficina";

    /*  ------- Selecciones normales ------- */
    private static final String SELECT_ADMINISTRATIVOS = "select * from empleados join "
            + "administrativos on empleados.dni = administrativos.dni";

    private static final String SELECT_PROGRAMADORES = "select * from empleados join "
            + "programadores on empleados.dni = programadores.dni";

    private static final String SELECT_ANALISTAS = "select * from empleados join "
            + "analistas on empleados.dni = analistas.dni";

    private static final String SELECT_VENDEDORES = "select * from empleados join "
            + "vendedores on empleados.dni = vendedores.dni";

    /*  ------- Selecciones de oficina ------- */
    private static final String SELECT_ADMINISTRATIVOS_OFICINA = "select * from empleados join "
            + "administrativos on empleados.dni = administrativos.dni where cod_oficina = ?";

    private static final String SELECT_PROGRAMADORES_OFICINA = "select * from empleados join "
            + "programadores on empleados.dni = programadores.dni where cod_oficina = ?";

    private static final String SELECT_ANALISTAS_OFICINA = "select * from empleados join "
            + "analistas on empleados.dni = analistas.dni where cod_oficina = ?";

    private static final String SELECT_VENDEDORES_OFICINA = "select * from empleados join "
            + "vendedores on empleados.dni = vendedores.dni where cod_oficina = ?";

    /**
     * Lee todos los empleados presentes en la BBDD
     *
     * @param cod_oficina Codigo de oficina al que pertenecen, si no se quiere buscar por una en particular usar
     * SIN_OFICINA
     * @return ArrayList con todos los empleados
     * @throws CargaDatosException En caso de error en la lectura de algún tipo de empelado
     */
    public static ArrayList<Empleado> leeEmpleados(String cod_oficina) throws CargaDatosException {
        ArrayList<Empleado> lista_empleados = new ArrayList<>();

        if (cod_oficina.equals(SIN_OFICINA)) {
            lista_empleados.addAll(leeAdministrativos(SIN_OFICINA));
            lista_empleados.addAll(leeProgramadores(SIN_OFICINA));
            lista_empleados.addAll(leeAnalistas(SIN_OFICINA));
            lista_empleados.addAll(leeVendedores(SIN_OFICINA));
        } else {
            lista_empleados.addAll(leeAdministrativos(cod_oficina));
            lista_empleados.addAll(leeProgramadores(cod_oficina));
            lista_empleados.addAll(leeAnalistas(cod_oficina));
            lista_empleados.addAll(leeVendedores(cod_oficina));
        }

        return lista_empleados;
    }

    /**
     * Lee todos los programadores presentes en la BBDD
     *
     * @param cod_oficina Codigo de oficina al que pertenecen, si no se quiere buscar por una en particular usar
     * SIN_OFICINA
     * @return ArrayList con todos los programadores
     * @throws CargaDatosException En caso de error en la lectura de los programadores
     */
    public static ArrayList<Programador> leeProgramadores(String cod_oficina) throws CargaDatosException {
        ArrayList<Programador> lista_empleados = new ArrayList<>();

        try {
            ResultSet resultSet;

            if (cod_oficina.equals(SIN_OFICINA)) {
                Statement statement = conexion.createStatement();
                resultSet = statement.executeQuery(SELECT_PROGRAMADORES);

            } else {
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_PROGRAMADORES_OFICINA);
                preparedStatement.setString(1, cod_oficina);
                resultSet = preparedStatement.executeQuery();
            }

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
     * @param cod_oficina Codigo de oficina al que pertenecen, si no se quiere buscar por una en particular usar
     * SIN_OFICINA
     * @return ArrayList con todos los analistas
     * @throws CargaDatosException En caso de error en la lectura de los analistas
     */
    public static ArrayList<Analista> leeAnalistas(String cod_oficina) throws CargaDatosException {
        ArrayList<Analista> lista_empleados = new ArrayList<>();

        try {
            ResultSet resultSet;

            if (cod_oficina.equals(SIN_OFICINA)) {
                Statement statement = conexion.createStatement();
                resultSet = statement.executeQuery(SELECT_ANALISTAS);

            } else {
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_ANALISTAS_OFICINA);
                preparedStatement.setString(1, cod_oficina);
                resultSet = preparedStatement.executeQuery();
            }

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
     * @param cod_oficina Codigo de oficina al que pertenecen, si no se quiere buscar por una en particular usar
     * SIN_OFICINA
     * @return ArrayList con todos los administrativos
     * @throws CargaDatosException En caso de error en la lectura de los administrativos
     */
    public static ArrayList<Administrativo> leeAdministrativos(String cod_oficina) throws CargaDatosException {
        ArrayList<Administrativo> lista_empleados = new ArrayList<>();

        try {
            ResultSet resultSet;

            if (cod_oficina.equals(SIN_OFICINA)) {
                Statement statement = conexion.createStatement();
                resultSet = statement.executeQuery(SELECT_ADMINISTRATIVOS);

            } else {
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_ADMINISTRATIVOS_OFICINA);
                preparedStatement.setString(1, cod_oficina);
                resultSet = preparedStatement.executeQuery();
            }

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

    /**
     * Lee todos los vendedores presentes en la BBDD
     *
     * @param cod_oficina Codigo de oficina al que pertenecen, si no se quiere buscar por una en particular usar
     * SIN_OFICINA
     * @return ArrayList con todos los vendedores
     * @throws CargaDatosException En caso de error en la lectura de los vendedores
     */
    public static ArrayList<Vendedor> leeVendedores(String cod_oficina) throws CargaDatosException {
        ArrayList<Vendedor> lista_empleados = new ArrayList<>();

        try {
            ResultSet resultSet;

            if (cod_oficina.equals(SIN_OFICINA)) {
                Statement statement = conexion.createStatement();
                resultSet = statement.executeQuery(SELECT_VENDEDORES);

            } else {
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_VENDEDORES_OFICINA);
                preparedStatement.setString(1, cod_oficina);
                resultSet = preparedStatement.executeQuery();
            }

            while (resultSet.next()) {

                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido_1 = resultSet.getString("apellido_1");
                String apellido_2 = resultSet.getString("apellido_2");
                String fecha_nacimiento = resultSet.getString("fecha_nacimiento");
                GregorianCalendar fecha_gregorian = stringToGregorianCalendar(fecha_nacimiento);
                Direccion direccion = new Direccion(resultSet.getString("direccion"));
                Oficina oficina = OficinasDB.leeOficina(resultSet.getString("cod_oficina"));

                int zona = resultSet.getInt("zona");

                lista_empleados.add(new Vendedor(dni, nombre, apellido_1, apellido_2, fecha_gregorian, direccion,
                        oficina, zona));

            }
        } catch (ParseException ex) {
            throw new CargaDatosException("Error al crear la fecha de nacimiento");
        } catch (LongitudNoValidaException | DniNoValidoException | SQLException ex) {
            throw new CargaDatosException("Error al leer y crear un empleado: " + ex.getMessage());
        }

        return lista_empleados;
    }

}
