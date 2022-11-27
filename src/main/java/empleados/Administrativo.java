package empleados;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Nivel;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public class Administrativo extends NoTecnicos {

    // ----------------------------- ATRIBUTOS -----------------------------
    private Nivel nivel_ofimatica;

    // ----------------------------- ATRIBUTOS -----------------------------
    public Administrativo(String dni, String nombre, String apellido_1, Oficina oficina, Nivel nivel)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, oficina);
        setNivelOfimatica(nivel);
    }

    public Administrativo(String dni, String nombre, String apellido_1, String apellido_2,
            GregorianCalendar fecha_nacimiento, Direccion direccion, Oficina oficina, Nivel nivel)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina);
        setNivelOfimatica(nivel);
    }

    public Administrativo(String dni, String nombre, String apellido_1, String apellido_2,
            GregorianCalendar fecha_nacimiento, Oficina oficina, Nivel nivel)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina);
        setNivelOfimatica(nivel);
    }

    public Administrativo(String dni, String nombre, String apellido_1, String apellido_2,
            Oficina oficina, Nivel nivel) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, oficina);
        setNivelOfimatica(nivel);
    }

    // ----------------------------- METODOS -----------------------------
    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), nivel_ofimatica.toString());
    }

    @Override
    public float calculaSueldo(int mes) {
        float sueldo_base = super.calculaSueldo(mes);

        switch (nivel_ofimatica) {
            case Bajo ->
                sueldo_base += 0;
            case Medio ->
                sueldo_base += 40;
            case Alto ->
                sueldo_base += 80;
            case Avanzado ->
                sueldo_base += 120;
        }
        return sueldo_base;
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------
    public Nivel getNivelOfimatica() {
        return nivel_ofimatica;
    }

    public void setNivelOfimatica(Nivel nivel) {
        this.nivel_ofimatica = nivel;
    }

}
