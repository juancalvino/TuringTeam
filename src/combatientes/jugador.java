package combatientes;


public class jugador extends Ejercito {

	private static jugador instanciaUnica;

	private jugador(Guerrero tipo, int cantidad) throws NegativeNumberException {
		super(tipo, cantidad);
	}

	protected static void startEjercitoPropio(Guerrero tipo, int cantidad) throws NegativeNumberException {
		instanciaUnica = new jugador(tipo, cantidad);
	}

	protected static jugador getEjercito() throws CreateInstanceEjercitoPropioException {
		if (instanciaUnica == null) {
			throw new CreateInstanceEjercitoPropioException();
		}
		return instanciaUnica;
	}

}
