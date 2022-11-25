package personas;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Nivel;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public class Programador extends Tecnicos {

    // ----------------------------- ATRIBUTOS -----------------------------
    private Nivel nivel_experiencia;

    // ----------------------------- CONSTRUCTORES -----------------------------
    public Programador(String dni, String nombre, String apellido_1, Oficina oficina,
            Nivel nivel_experiencia) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, oficina);
        setNivel_experiencia(nivel_experiencia);
    }

    public Programador(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina,
            Nivel nivel_experiencia) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, oficina);
        setNivel_experiencia(nivel_experiencia);
    }

    public Programador(String dni, String nombre, String apellido_1, String apellido_2,
            GregorianCalendar fecha_nacimiento, Direccion direccion, Oficina oficina,
            Nivel nivel_experiencia) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina);
        setNivel_experiencia(nivel_experiencia);
    }

    public Programador(String dni, String nombre, String apellido_1, String apellido_2,
            GregorianCalendar fecha_nacimiento, Oficina oficina, Nivel nivel_experiencia)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina);
        setNivel_experiencia(nivel_experiencia);
    }

    // ----------------------------- METODOS -----------------------------
    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), nivel_experiencia.toString());
    }

    @Override
    public float calculaSueldo(int mes) {
        return super.calculaSueldo(mes) + (25 * getTecnologias().size());
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------
    public Nivel getNivel_experiencia() {
        return nivel_experiencia;
    }

    public void setNivel_experiencia(Nivel nivel_experiencia) {
        this.nivel_experiencia = nivel_experiencia;
    }

}
