package personas;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public abstract class Empleado extends Persona {

    // ----------------------------- ATRIBUTOS -----------------------------

    private Oficina oficina;

    // ----------------------------- CONSTRUCTORES -----------------------------

    public Empleado(String dni, String nombre, String apellido_1, Oficina oficina, float sueldo)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1);
        setOficina(oficina);

    }

    public Empleado(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina, float sueldo)
            throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2);
        setOficina(oficina);

    }

    public Empleado(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
                    Direccion direccion, Oficina oficina, float sueldo) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion);
        setOficina(oficina);

    }

    public Empleado(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
                    Oficina oficina, float sueldo) throws LongitudNoValidaException, DniNoValidoException {
        super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento);
        setOficina(oficina);

    }

    // ----------------------------- METODOS -----------------------------

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), oficina);
    }

    public float calculaSueldo() {
        return 0;
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }


}
