package combatientes.ejercito;

import combatientes.guerrero.Guerrero;
import escenario.Escenario;

public class EjercitoAliado extends Ejercito {

	public EjercitoAliado(Guerrero tipo, int cantidad) {
		super(tipo, cantidad);
	}

	/**
	 * El EjercitoAliado se agrega al EjercitoPropio. Y el EjercitoPropio descansa.
	 */
	@Override
	public void interactuar() {
		Escenario.getInstance().getJugador().descansar();
		Escenario.getInstance().getJugador().agregarEjercito(this);
	}

}
