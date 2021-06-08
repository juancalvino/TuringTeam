package combatientes;


public class EjercitoUnico extends Ejercito {

	private static EjercitoUnico instanciaUnica;

	private EjercitoUnico(Guerrero tipo, int cantidad) throws NegativeNumberException {
		super(tipo, cantidad);
	}

	protected static void startEjercitoPropio(Guerrero tipo, int cantidad) throws NegativeNumberException {
		instanciaUnica = new EjercitoUnico(tipo, cantidad);
	}

	protected static EjercitoUnico getEjercito() throws CreateInstanceEjercitoPropioException {
		if (instanciaUnica == null) {
			throw new CreateInstanceEjercitoPropioException();
		}
		return instanciaUnica;
	}

}
