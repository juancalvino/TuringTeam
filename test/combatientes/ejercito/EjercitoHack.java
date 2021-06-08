package combatientes.ejercito;

import combatientes.guerrero.GuerreroHack;

public class EjercitoHack extends Ejercito {
	
	public EjercitoHack(int salud, int danio, int cantidad) {
		super(new GuerreroHack(salud,danio), cantidad);
	}
}
