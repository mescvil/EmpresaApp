package clases;

public class Direccion implements Comparable<Direccion> {

    // ----------------------------- ATRIBUTOS -----------------------------

    private String nombre_via;
    private String numero;
    private String piso;
    private String codigo_postal;
    private String localidad;

    // ----------------------------- CONSTRUCTORES -----------------------------

    public Direccion(String nombre_via, String codigo_postal, String localidad) {
        setNombre_via(nombre_via);
        setCodigo_postal(codigo_postal);
        setLocalidad(localidad);
    }

    public Direccion(Direccion direccion) {
        setNombre_via(direccion.getNombre_via());
        setNumero(direccion.getNumero());
        setPiso(direccion.getPiso());
        setCodigo_postal(direccion.getCodigo_postal());
        setLocalidad(direccion.getLocalidad());
    }

    // ----------------------------- METODOS -----------------------------

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", getNombre_via(), getNumero(), getPiso(), getCodigo_postal(),
                getLocalidad());
    }

    @Override
    public int compareTo(Direccion o) {
        return toString().compareTo(o.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Direccion))
            return false;

        return toString().equals(obj.toString());
    }

    // ----------------------------- GETTERS & SETTERS -----------------------------

    public String getNombre_via() {
        return nombre_via;
    }

    public void setNombre_via(String nombre_via) {
        this.nombre_via = nombre_via;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}
