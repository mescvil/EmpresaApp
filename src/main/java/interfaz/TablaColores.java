/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author theky
 */
public class TablaColores extends JTable {

    private final Color color_alterno = new Color(235, 235, 235);
    private final Color color_normal = null;

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component componente = super.prepareRenderer(renderer, row, column);

        if (!componente.getBackground().equals(getSelectionBackground())) {
            Color color = (row % 2 == 0 ? color_alterno : color_normal);
            componente.setBackground(color);

        }
        return componente;
    }

}
