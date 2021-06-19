package combatientes.ejercito;

import combatientes.guerrero.Guerrero;
import escenario.Batalla;
import escenario.Escenario;

public class EjercitoEnemigo extends Ejercito {

	public EjercitoEnemigo(Guerrero tipo, int cantidad) {
		super(tipo, cantidad);
	}

	@Override
	public void interactuar() {
		Batalla.obtenerSobreviviente(Escenario.getInstance().getJugador(), this);
	}

}
