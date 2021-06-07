package combatientes;

import combatientes.Guerrero;

public class GuerreroHack extends Guerrero {

	public GuerreroHack(int salud, int danio) {
		this.salud = salud;
		this.danioBasico = danio;
	}

	@Override
	protected Guerrero crearUnidad() {
		return new GuerreroHack(salud, danioBasico);
	}
}
