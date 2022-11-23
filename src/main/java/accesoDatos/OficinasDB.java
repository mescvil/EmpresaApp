/*
 */
package accesoDatos;

import clases.Direccion;
import clases.Oficina;

/**
 *
 * @author Escoz
 */
public class OficinasDB {
    
    public static Oficina leeOficina(String codigo) {
        Oficina oficina = new Oficina("Juas", codigo, new Direccion(codigo, codigo, codigo));
        
        return oficina;
    }
}
