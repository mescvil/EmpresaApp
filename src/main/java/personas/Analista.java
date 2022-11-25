package personas;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public class Analista extends Tecnicos {

    // ----------------------------- ATRIBUTOS -----------------------------
    private String titulacion;

    // ----------------------------- CONSTRUCTORES -----------------------------
    public Analista(String dni, String nombre, String apellido_1, Oficina oficina, String titulacion)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, oficina);
        setTitulacion(titulacion);
    }

    public Analista(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina,
            String titulacion) throws LongitudNoValidaException, DniNoValidoException {

        super(dni, nombre, apellido_1, apellido_2, oficina);
        setTitulacion(titulacion);
    }

    public Analista(String dni, String nombre, String apellido_1, String apellido_2,
            GregorianCalendar fecha_nacimiento, Direccion direccion, Oficina oficina, String titulacion)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina);
        setTitulacion(titulacion);
    }

    public Analista(String dni, String nombre, String apellido_1, String apellido_2,
            GregorianCalendar fecha_nacimiento, Oficina oficina, String titulacion)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina);
        setTitulacion(titulacion);
    }

    // ----------------------------- METODOS -----------------------------
    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), titulacion);
    }

    @Override
    public float calculaSueldo(int mes) {
        return super.calculaSueldo(mes) + 300;
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------
    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

}
