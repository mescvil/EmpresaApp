package principal;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.Controlador;

public class Principal {

    public static void main(String[] args) {

        /* Iniciamos la vista con un Look and Feel propio*/
        FlatLightLaf.setup();
        new Controlador();
    }

}
