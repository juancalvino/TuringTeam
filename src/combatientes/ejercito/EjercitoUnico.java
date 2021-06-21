package combatientes.ejercito;

import combatientes.guerrero.Guerrero;

public class EjercitoUnico extends Ejercito {

	private static EjercitoUnico instanciaUnica;

	private EjercitoUnico(Guerrero tipo, int cantidad) {
		super(tipo, cantidad);
	}

	/**
	 * Prepara la instancia del EjercitoUnico para ser utilizada
	 * 
	 * @param tipo
	 * @param cantidad tiene que ser mayor o igual a 0
	 */
	protected static void startEjercitoPropio(Guerrero tipo, int cantidad) {
		instanciaUnica = new EjercitoUnico(tipo, cantidad);
	}

	/**
	 * @return la unica instancia del EjercitoUnico
	 */
	protected static EjercitoUnico getEjercito() {
		return instanciaUnica;
	}

	@Override
	public void interactuar() {
		// no hace nada
	}

}
