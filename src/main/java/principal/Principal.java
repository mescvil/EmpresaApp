package principal;

import com.formdev.flatlaf.FlatLightLaf;
import interfaz.VistaPrincipal;

public class Principal {

    public static void main(String[] args) {
        
        FlatLightLaf.setup();
        new VistaPrincipal().setVisible(true);
    }

}
