package utilidades;

public class Validador {

	private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	public static boolean isDniValido(String dni) {

		if (!dni.matches("[0-9]{8}[a-zA-Z]"))
			return false;

		char letra = Character.toUpperCase(dni.charAt(dni.length() - 1));
		int parte_numerica = Integer.parseInt(dni.substring(0, 8));
		int posicion_letra = parte_numerica % 23;

		return LETRAS_DNI.charAt(posicion_letra) == letra;
	}

}
