package combatientes;

public class NegativeNumberException extends Exception {

	private static final long serialVersionUID = 10000L;

	public NegativeNumberException() {
		super("No se pueden ingresar numeros negativos");
	}
}
