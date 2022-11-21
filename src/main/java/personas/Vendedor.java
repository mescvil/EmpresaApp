package personas;

import java.util.GregorianCalendar;

import clases.Direccion;
import clases.Oficina;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;

public class Vendedor extends NoTecnicos {

	// ----------------------------- ATRIBUTOS -----------------------------

	private int zona;

	// ----------------------------- CONSTRUCTORES -----------------------------

	public Vendedor(String dni, String nombre, String apellido_1, Oficina oficina, float sueldo, int zona)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, oficina, sueldo);
		setZona(zona);
	}

	public Vendedor(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
			Direccion direccion, Oficina oficina, float sueldo, int zona)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina, sueldo);
		setZona(zona);
	}

	public Vendedor(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
			Oficina oficina, float sueldo, int zona) throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina, sueldo);
		setZona(zona);
	}

	public Vendedor(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina, float sueldo,
			int zona) throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, oficina, sueldo);
		setZona(zona);
	}

	// ----------------------------- METODOS -----------------------------

	@Override
	public String toString() {
		return String.format("%s %d", super.toString(), zona);
	}

	@Override
	public float calculaSueldo() {
		return super.calculaSueldo();
	}

	// ----------------------------- GETTERS & SETTERS -----------------------------

	public void setZona(int zona) {
		this.zona = zona;
	}

	public int getZona() {
		return zona;
	}
}
