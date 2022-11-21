package personas;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public abstract class NoTecnicos extends Empleado {

	// ----------------------------- ATRIBUTOS -----------------------------

	// ----------------------------- CONSTRUCTORES -----------------------------

	public NoTecnicos(String dni, String nombre, String apellido_1, Oficina oficina, float sueldo)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, oficina, sueldo);
	}

	public NoTecnicos(String dni, String nombre, String apellido_1, String apellido_2,
			GregorianCalendar fecha_nacimiento, Direccion direccion, Oficina oficina, float sueldo)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina, sueldo);
	}

	public NoTecnicos(String dni, String nombre, String apellido_1, String apellido_2,
			GregorianCalendar fecha_nacimiento, Oficina oficina, float sueldo)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina, sueldo);
	}

	public NoTecnicos(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina, float sueldo)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, oficina, sueldo);
	}

	// ----------------------------- METODOS -----------------------------

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public float calculaSueldo() {
		return super.calculaSueldo();
	}

	// ----------------------------- GETTERS & SETTERS -----------------------------

}
