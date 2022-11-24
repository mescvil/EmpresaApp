package personas;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
import java.util.Arrays;

public abstract class Tecnicos extends Empleado {

    // ----------------------------- ATRIBUTOS -----------------------------
    private ArrayList<String> tecnologias;

    // ----------------------------- CONSTRUCTORES -----------------------------
    public Tecnicos(String dni, String nombre, String apellido_1, Oficina oficina)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, oficina);
        tecnologias = new ArrayList<>();
    }

    public Tecnicos(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, oficina);
        tecnologias = new ArrayList<>();
    }

    public Tecnicos(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
            Direccion direccion, Oficina oficina) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina);
        tecnologias = new ArrayList<>();
    }

    public Tecnicos(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
            Oficina oficina) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina);
        tecnologias = new ArrayList<>();
    }

    // ----------------------------- METODOS -----------------------------
    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), tecnologias);
    }

    @Override
    public float calculaSueldo() {
        return super.calculaSueldo();
    }

    public void aniadeTecnologia(String tecnologia) {
        tecnologias.add(tecnologia);
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------
    public ArrayList<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(ArrayList<String> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public void setTecnologias(String[] tecnologias) {
        for (String tecnologia : tecnologias) {
            aniadeTecnologia(tecnologia);
        }
    }
}
