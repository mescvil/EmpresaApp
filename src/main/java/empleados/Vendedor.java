package empleados;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public class Vendedor extends NoTecnicos {

    // ----------------------------- ATRIBUTOS -----------------------------
    private int zona;

    // ----------------------------- CONSTRUCTORES -----------------------------
    public Vendedor(String dni, String nombre, String apellido_1, Oficina oficina, int zona)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, oficina);
        setZona(zona);
    }

    public Vendedor(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
            Direccion direccion, Oficina oficina, int zona)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina);
        setZona(zona);
    }

    public Vendedor(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
            Oficina oficina, int zona) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina);
        setZona(zona);
    }

    public Vendedor(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina,
            int zona) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, oficina);
        setZona(zona);
    }

    // ----------------------------- METODOS -----------------------------
    @Override
    public String toString() {
        return String.format("%s %d", super.toString(), zona);
    }

    @Override
    public float calculaSueldo(int mes) {
        float sueldo_base = super.calculaSueldo(mes);
        return (zona % 2 == 0) ? sueldo_base + 100 : sueldo_base + 200;
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------
    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getZona() {
        return zona;
    }
}
