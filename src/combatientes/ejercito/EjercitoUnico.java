package combatientes.ejercito;

import combatientes.guerrero.Guerrero;

public class EjercitoUnico extends Ejercito {

	private static EjercitoUnico instanciaUnica;

	private EjercitoUnico(Guerrero tipo, int cantidad){
		super(tipo, cantidad);
	}

	protected static void startEjercitoPropio(Guerrero tipo, int cantidad){
		instanciaUnica = new EjercitoUnico(tipo, cantidad);
	}

	protected static EjercitoUnico getEjercito() {
		return instanciaUnica;
	}

}
