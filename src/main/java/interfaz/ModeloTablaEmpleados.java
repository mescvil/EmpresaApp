package interfaz;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import personas.Empleado;

/**
 * @author Escoz
 */
public class ModeloTablaEmpleados extends AbstractTableModel {

    private Object[][] datos_empleados = {};
    private final String[] nombre_columnas = {"DNI", "Nombre", "Puesto", "Oficina", "Nomina (€)"};
    private final boolean[] isEditable = {false, false, false, false, false};
    private final Class[] clase_columnas = {String.class, String.class, String.class, String.class, Integer.class};

    private float suma_nominas;

    //  --------------------- MÉTODOS HEREDADOS  ---------------------
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return clase_columnas[columnIndex];
    }

    @Override
    public int getRowCount() {
        return datos_empleados.length;

    }

    @Override
    public int getColumnCount() {
        return nombre_columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos_empleados[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nombre_columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return isEditable[columnIndex];
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        datos_empleados[row][col] = o;
        fireTableCellUpdated(row, col);
    }

    public void addEmpleados(ArrayList<Empleado> empleados) {
        suma_nominas = 0;

        /* Añadimos una columna extra para trampear los empleados */
        datos_empleados = new Object[empleados.size()][getColumnCount() + 1];

        for (int i = 0; i < empleados.size(); i++) {
            addRow(empleados.get(i), i);
        }

        fireTableDataChanged();
    }

    public void addEmpleados(ArrayList<Empleado> empleados, int mes) {
        suma_nominas = 0;

        /* Añadimos una columna extra para trampear los empleados y una fila extra para la 
        sumatoria de las nominas */
        datos_empleados = new Object[empleados.size() + 1][getColumnCount() + 1];

        for (int i = 0; i < empleados.size(); i++) {
            addRow(empleados.get(i), i, mes);
        }
        addRowSuma(empleados.size());

        fireTableDataChanged();
    }

    private void addRow(Empleado empleado, int fila) {

        datos_empleados[fila][0] = empleado.getDni();
        datos_empleados[fila][1] = empleado.getNombreCompleto();
        datos_empleados[fila][2] = empleado.getClass().getSimpleName();
        datos_empleados[fila][3] = empleado.getOficina().getNombre();
        datos_empleados[fila][4] = 0;
        datos_empleados[fila][nombre_columnas.length] = empleado;

        fireTableRowsInserted(fila, fila);
    }

    private void addRow(Empleado empleado, int fila, int mes) {
        float sueldo = empleado.calculaSueldo(mes);
        suma_nominas += sueldo;

        datos_empleados[fila][0] = empleado.getDni();
        datos_empleados[fila][1] = empleado.getNombreCompleto();
        datos_empleados[fila][2] = empleado.getClass().getSimpleName();
        datos_empleados[fila][3] = empleado.getOficina().getNombre();
        datos_empleados[fila][4] = sueldo;
        datos_empleados[fila][nombre_columnas.length] = empleado;

        fireTableRowsInserted(fila, fila);
    }

    private void addRowSuma(int fila) {
        datos_empleados[fila][0] = "";
        datos_empleados[fila][1] = "";
        datos_empleados[fila][2] = "";
        datos_empleados[fila][3] = "";
        datos_empleados[fila][4] = suma_nominas;

        fireTableRowsInserted(fila, fila);
    }

    public Empleado getEmpleado(int fila) {
        return (Empleado) datos_empleados[fila][nombre_columnas.length];
    }
}
