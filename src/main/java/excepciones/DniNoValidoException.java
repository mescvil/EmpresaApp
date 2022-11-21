package excepciones;

public class DniNoValidoException extends Exception {

	public DniNoValidoException() {
		super("# Formato del DNI invalido");
	}

}
