/*
 */
package utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Escoz
 */
public class Fechas {
    
    private static final DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public static GregorianCalendar stringToGregorianCalendar(String fecha) throws ParseException {
        GregorianCalendar fecha_gregorian = new GregorianCalendar();
        fecha_gregorian.setTime(formato.parse(fecha));
        return fecha_gregorian;
    }
}
