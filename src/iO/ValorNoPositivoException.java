package iO;

public class ValorNoPositivoException extends Exception {

	private static final long serialVersionUID = 4195138972352363924L;

	ValorNoPositivoException() {
		super("El valor numerico ingresado debe ser mayor a 0.");
	}
}
