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

    private static final DateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");

    public static GregorianCalendar stringToGregorianCalendar(String fecha) throws ParseException {
        GregorianCalendar fecha_gregorian = new GregorianCalendar();
        fecha_gregorian.setTime(formato_fecha.parse(fecha));
        return fecha_gregorian;
    }

    public static String gregorianCalendarToString(GregorianCalendar fecha) {
        formato_fecha.setCalendar(fecha);
        return formato_fecha.format(fecha.getTime());
    }
}
