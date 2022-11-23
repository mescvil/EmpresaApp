package clases;

public class Oficina implements Comparable<Oficina> {

    // ----------------------------- ATRIBUTOS -----------------------------
    private String nombre;
    private String codigo;
    private Direccion direccion;

    // ----------------------------- CONSTRUCTORES -----------------------------
    public Oficina(String nombre, String codigo, Direccion direccion) {
        setNombre(nombre);
        setCodigo(codigo);
        setDireccion(direccion);
    }

    public Oficina(Oficina oficina) {
        setNombre(oficina.getNombre());
        setCodigo(oficina.getCodigo());
        setDireccion(oficina.getDireccion());
    }

    // ----------------------------- METODOS -----------------------------
    @Override
    public String toString() {
        return String.format("%s - %s", getCodigo(), getNombre());
    }

    @Override
    public int compareTo(Oficina o) {
        return toString().compareTo(o.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Oficina)) {
            return false;
        }

        return toString().equals(obj.toString());
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
