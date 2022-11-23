/*
 */
package interfaz;

import accesoDatos.Conexion;
import accesoDatos.EmpleadosDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Escoz
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        abreConexionDB();
        leeAdministrativos();

        initComponents();
    }

    private void abreConexionDB() {
        try {
            Conexion.abreConexion();
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void leeAdministrativos() {
        try {
            EmpleadosDB.leeAdministrativos();
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel_filtros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo_oficina = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        combo_empleado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        boton_buscar = new javax.swing.JButton();
        boton_limpiar = new javax.swing.JButton();
        panel_botones = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        boton_imprimir = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        boton_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmpresaApp 1.0");
        setPreferredSize(new java.awt.Dimension(900, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        panel_filtros.setMinimumSize(new java.awt.Dimension(0, 35));
        panel_filtros.setPreferredSize(new java.awt.Dimension(0, 50));
        panel_filtros.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Oficina");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panel_filtros.add(jLabel1, gridBagConstraints);

        combo_oficina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Sin selección -" }));
        combo_oficina.setPreferredSize(new java.awt.Dimension(120, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panel_filtros.add(combo_oficina, gridBagConstraints);

        jLabel2.setText("Empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panel_filtros.add(jLabel2, gridBagConstraints);

        combo_empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Sin selección -" }));
        combo_empleado.setPreferredSize(new java.awt.Dimension(120, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panel_filtros.add(combo_empleado, gridBagConstraints);

        jLabel3.setText("Mes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panel_filtros.add(jLabel3, gridBagConstraints);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panel_filtros.add(jComboBox3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        panel_filtros.add(filler3, gridBagConstraints);

        boton_buscar.setBackground(new java.awt.Color(51, 153, 255));
        boton_buscar.setForeground(new java.awt.Color(255, 255, 255));
        boton_buscar.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panel_filtros.add(boton_buscar, gridBagConstraints);

        boton_limpiar.setText("Limpiar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.1;
        panel_filtros.add(boton_limpiar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 5, 10);
        getContentPane().add(panel_filtros, gridBagConstraints);

        panel_botones.setMinimumSize(new java.awt.Dimension(0, 50));
        panel_botones.setPreferredSize(new java.awt.Dimension(0, 50));
        panel_botones.setLayout(new javax.swing.BoxLayout(panel_botones, javax.swing.BoxLayout.LINE_AXIS));
        panel_botones.add(filler1);

        boton_imprimir.setText("Imprimir");
        boton_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_imprimir.setPreferredSize(new java.awt.Dimension(80, 23));
        panel_botones.add(boton_imprimir);
        panel_botones.add(filler2);

        boton_salir.setBackground(new java.awt.Color(255, 102, 102));
        boton_salir.setForeground(new java.awt.Color(255, 255, 255));
        boton_salir.setText("Salir");
        boton_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_botones.add(boton_salir);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(panel_botones, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_buscar;
    private javax.swing.JButton boton_imprimir;
    private javax.swing.JButton boton_limpiar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JComboBox<String> combo_empleado;
    private javax.swing.JComboBox<String> combo_oficina;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_filtros;
    // End of variables declaration//GEN-END:variables
}
