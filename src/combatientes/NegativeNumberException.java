package combatientes;

public class NegativeNumberException extends Exception {

	private static final long serialVersionUID = 10000L;

	public NegativeNumberException() {
		super(" no puede ingresar numeros negativos");
	}
}
