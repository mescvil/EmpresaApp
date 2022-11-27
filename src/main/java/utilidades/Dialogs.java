/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author theky
 */
public final class Dialogs {

    /**
     * Crea un JDialog con un mensaje de error
     *
     * @param padre JFrame padre para ubicar el mensaje en el centro de este
     * @param mensaje Mensaje que a de aparecer en el JDialog
     * @param titulo Titulo del JDialog
     */
    public static void creaDialogError(JFrame padre, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(padre, mensaje,
                titulo, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Crea un JDialog con un mensaje de advertencia
     *
     * @param padre JFrame padre para ubicar el mensaje en el centro de este
     * @param mensaje Mensaje que a de aparecer en el JDialog
     * @param titulo Titulo del JDialog
     */
    public static void creaDialogWarning(JFrame padre, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(padre, mensaje,
                titulo, JOptionPane.WARNING_MESSAGE);
    }

}
