package clases;

import java.util.TreeMap;

import empleados.Empleado;

public class Empresa {

	private String nombre;
	private TreeMap<String, Empleado> empleados;

	public Empresa(String nombre) {
		setNombre(nombre);
		empleados = new TreeMap<>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeMap<String, Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(TreeMap<String, Empleado> empleados) {
		this.empleados = empleados;
	}

}
