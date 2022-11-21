package personas;

import java.util.GregorianCalendar;

import clases.Direccion;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
import utilidades.Validador;

public abstract class Persona implements Comparable<Persona> {

	// ----------------------------- ATRIBUTOS -----------------------------

	private String dni;
	private String nombre;
	private String apellido_1;
	private String apellido_2;
	private GregorianCalendar fecha_nacimiento;
	private Direccion direccion;

	private final int MAX_NOMBRE = 45;
	private final int MAX_APELLIDO = 45;

	// ----------------------------- CONSTRUCTORES -----------------------------

	public Persona(String dni, String nombre, String apellido_1)
			throws LongitudNoValidaException, DniNoValidoException {
		setDni(dni);
		setNombre(nombre);
		setApellido_1(apellido_1);
	}

	public Persona(String dni, String nombre, String apellido_1, String apellido_2)
			throws LongitudNoValidaException, DniNoValidoException {
		setDni(dni);
		setNombre(nombre);
		setApellido_1(apellido_1);
		setApellido_2(apellido_2);
	}

	public Persona(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento)
			throws LongitudNoValidaException, DniNoValidoException {
		setDni(dni);
		setNombre(nombre);
		setApellido_1(apellido_1);
		setApellido_2(apellido_2);
		setFecha_nacimiento(fecha_nacimiento);
	}

	public Persona(String dni, String nombre, String apellido_1, String apellido_2, GregorianCalendar fecha_nacimiento,
			Direccion direccion) throws LongitudNoValidaException, DniNoValidoException {
		setDni(dni);
		setNombre(nombre);
		setApellido_1(apellido_1);
		setApellido_2(apellido_2);
		setFecha_nacimiento(fecha_nacimiento);
		setDireccion(direccion);
	}

	// ----------------------------- METODOS -----------------------------

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", getNombre(), getApellido_1(), getApellido_2(), getFecha_nacimiento(),
				getDireccion());
	}

	@Override
	public int compareTo(Persona o) {
		return getDni().compareTo(o.getDni());
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Persona))
			return false;
		return toString().equals(obj.toString());
	}

	// ----------------------------- GETTERS & SETTERS -----------------------------

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws DniNoValidoException {

		if (Validador.isDniValido(dni))
			this.dni = dni;
		else
			throw new DniNoValidoException();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws LongitudNoValidaException {

		if (nombre.length() <= MAX_NOMBRE)
			this.nombre = nombre;
		else
			throw new LongitudNoValidaException(MAX_NOMBRE);
	}

	public String getApellido_1() {
		return apellido_1;
	}

	public void setApellido_1(String apellido_1) throws LongitudNoValidaException {

		if (apellido_1.length() <= MAX_APELLIDO)
			this.apellido_1 = apellido_1;
		else
			throw new LongitudNoValidaException(MAX_APELLIDO);
	}

	public String getApellido_2() {
		return apellido_2;
	}

	public void setApellido_2(String apellido_2) throws LongitudNoValidaException {

		if (apellido_2.length() <= MAX_APELLIDO)
			this.apellido_2 = apellido_2;
		else
			throw new LongitudNoValidaException(MAX_APELLIDO);
	}

	public GregorianCalendar getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(GregorianCalendar fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
