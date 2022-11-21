package personas;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public class Analistas extends Tecnicos {

	// ----------------------------- ATRIBUTOS -----------------------------

	private String titulacion;

	// ----------------------------- CONSTRUCTORES -----------------------------

	public Analistas(String dni, String nombre, String apellido_1, Oficina oficina, float sueldo, String titulacion)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, oficina, sueldo);
		setTitulacion(titulacion);
	}

	public Analistas(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina, float sueldo,
			String titulacion) throws LongitudNoValidaException, DniNoValidoException {

		super(dni, nombre, apellido_1, apellido_2, oficina, sueldo);
		setTitulacion(titulacion);
	}

	public Analistas(String dni, String nombre, String apellido_1, String apellido_2,
			GregorianCalendar fecha_nacimiento, Direccion direccion, Oficina oficina, float sueldo, String titulacion)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina, sueldo);
		setTitulacion(titulacion);
	}

	public Analistas(String dni, String nombre, String apellido_1, String apellido_2,
			GregorianCalendar fecha_nacimiento, Oficina oficina, float sueldo, String titulacion)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina, sueldo);
		setTitulacion(titulacion);
	}

	// ----------------------------- METODOS -----------------------------

	@Override
	public String toString() {
		return String.format("%s %s", super.toString(), titulacion);
	}

	@Override
	public float calculaSueldo() {
		return super.calculaSueldo();
	}

	// ----------------------------- GETTERS & SETTERS -----------------------------

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

}
