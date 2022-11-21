package excepciones;

public class LongitudNoValidaException extends Exception {

	public LongitudNoValidaException(int longitud_maxima) {
		super(String.format("# Longitud demasiada larga, máximo permitido : %d", longitud_maxima));
	}
}
