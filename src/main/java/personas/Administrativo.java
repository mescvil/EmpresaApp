package personas;

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

	public Administrativo(String dni, String nombre, String apellido_1, Oficina oficina, float sueldo, Nivel nivel)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, oficina, sueldo);
		setNivelOfimatica(nivel);
	}

	public Administrativo(String dni, String nombre, String apellido_1, String apellido_2,
			GregorianCalendar fecha_nacimiento, Direccion direccion, Oficina oficina, float sueldo, Nivel nivel)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, direccion, oficina, sueldo);
		setNivelOfimatica(nivel);
	}

	public Administrativo(String dni, String nombre, String apellido_1, String apellido_2,
			GregorianCalendar fecha_nacimiento, Oficina oficina, float sueldo, Nivel nivel)
			throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, fecha_nacimiento, oficina, sueldo);
		setNivelOfimatica(nivel);
	}

	public Administrativo(String dni, String nombre, String apellido_1, String apellido_2, Oficina oficina,
			float sueldo, Nivel nivel) throws LongitudNoValidaException, DniNoValidoException {
		super(dni, nombre, apellido_1, apellido_2, oficina, sueldo);
		setNivelOfimatica(nivel);
	}

	// ----------------------------- METODOS -----------------------------

	@Override
	public String toString() {
		return String.format("%s %s", super.toString(), nivel_ofimatica.toString());
	}

	@Override
	public float calculaSueldo() {
		return super.calculaSueldo();
	}

	// ----------------------------- GETTERS & SETTERS -----------------------------

	public Nivel getNivelOfimatica() {
		return nivel_ofimatica;
	}

	public void setNivelOfimatica(Nivel nivel) {
		this.nivel_ofimatica = nivel;
	}

}
