/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import accesoDatos.*;
import static accesoDatos.EmpleadosDB.SIN_OFICINA;
import clases.Oficina;
import excepciones.CargaDatosException;
import static utilidades.Dialogs.creaDialogError;
import vistas.VistaNominas;
import java.sql.SQLException;
import java.util.ArrayList;
import observador.ObservadorEmpleado;
import empleados.Empleado;
import vistas.DialogoInicial;

/**
 *
 * @author theky
 */
public class Controlador implements ObservadorEmpleado {

    public static final int DIALOGO_INICIAL = 0;
    public static final int VISTA_NOMINAS = 1;

    private final VistaNominas vistaNominas;
    private final DialogoInicial dialogoInicial;

    public Controlador() {
        abreConexionDB();
        EmpleadosDB.suscribirse(this);

        this.dialogoInicial = new DialogoInicial(null, true, this);
        this.vistaNominas = new VistaNominas(this);

        dialogoInicial.setVisible(true);
    }

    public void cambiaVentana(int ventana) {
        switch (ventana) {
            case VISTA_NOMINAS ->
                vistaNominas.setVisible(true);
            case DIALOGO_INICIAL ->
                dialogoInicial.setVisible(true);
        }
    }

    /**
     * Abre la conexion con la BBDD, en caso de error muestra un mensaje y para la ejecución.
     */
    private void abreConexionDB() {
        try {
            Conexion.abreConexion();
        } catch (SQLException ex) {
            creaDialogError(null, "No es posible acceder a la BBDD: " + ex.getMessage(), "Conexión");
            System.exit(1);
        }
    }

    public ArrayList<Empleado> leeEmpleados() throws CargaDatosException {
        return EmpleadosDB.leeEmpleados(SIN_OFICINA);
    }

    public void eliminaEmpleado(String dni) throws SQLException {
        EmpleadosDB.eliminaEmpleado(dni);
    }

    public ArrayList<Oficina> leeOficinas() throws CargaDatosException {
        return OficinasDB.leeOficinas();
    }

    public ArrayList<Empleado> buscaEmpleados(String[] busqueda) throws CargaDatosException {
        /* Si mete algo raro se devuelve vacio */
        ArrayList<Empleado> empleados_econtrados = new ArrayList<>();

        if (busqueda[0].equals("Todas")) {
            /* Buscamos segun el empleado seleccionado en el comboBox */
            switch (busqueda[1]) {
                case "Administrativos" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeAdministrativos(SIN_OFICINA));
                case "Analistas" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeAnalistas(SIN_OFICINA));
                case "Vendedores" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeVendedores(SIN_OFICINA));
                case "Programadores" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeProgramadores(SIN_OFICINA));
                case "Todos" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeEmpleados(SIN_OFICINA));
            }
            /* Si selecciona una oficina */
        } else {
            switch (busqueda[1]) {
                case "Administrativos" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeAdministrativos(busqueda[0]));
                case "Analistas" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeAnalistas(busqueda[0]));
                case "Vendedores" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeVendedores(busqueda[0]));
                case "Programadores" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeProgramadores(busqueda[0]));
                case "Todos" ->
                    empleados_econtrados.addAll(EmpleadosDB.leeEmpleados(busqueda[0]));
            }
        }
        return empleados_econtrados;
    }

    @Override
    public void cambioEmpleados() {
        vistaNominas.actualizaTabla();
    }

}
