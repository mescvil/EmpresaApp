/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import accesoDatos.*;
import clases.Oficina;
import excepciones.CargaDatosException;
import static interfaz.Dialogs.creaDialogError;
import interfaz.VistaPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import personas.Empleado;
import observador.ObservadorCarga;

/**
 *
 * @author theky
 */
public class Controlador {

    private final VistaPrincipal vistaPrincipal;
    private ArrayList<ObservadorCarga> lista_observadores = new ArrayList<>();

    public Controlador() {
        this.vistaPrincipal = new VistaPrincipal(this);
        vistaPrincipal.setVisible(true);

        abreConexionDB();
    }

    /**
     * Abre la conexion con la BBDD, en caso de error muestra un mensaje y para la ejecución.
     */
    private void abreConexionDB() {
        try {
            Conexion.abreConexion();
            notifica();
        } catch (SQLException ex) {
            creaDialogError(null, "No es posible acceder a la BBDD", "Conexión");
            System.exit(1);
        }
    }

    public ArrayList<Empleado> leeEmpleados() throws CargaDatosException {
        return EmpleadosDB.leeEmpleados();
    }

    public ArrayList<Oficina> leeOficinas() throws CargaDatosException {
        return OficinasDB.leeOficinas();
    }

    public ArrayList<Empleado> buscaEmpleados(HashMap<String, String> busqueda) {
        return new ArrayList<>();
    }

    public void suscribirse(ObservadorCarga o) {
        lista_observadores.add(o);
    }

    private void notifica() {
        for (ObservadorCarga observador : lista_observadores) {
            observador.actualiza();
        }
    }

}
