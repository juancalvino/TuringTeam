package guerreros;

public abstract class Guerrero implements Combatiente{
	// TODO: 29/5/2021 Implementar el sistema de prioridad para las colas.

	protected int salud;
	protected int danioBasico;
	
	
	public int getSalud() {
		return this.salud;
	}

	public void descansar() {
	}

	public int atacar() {
		return this.danioBasico;
	}

	protected void atacar(Guerrero enemigo) {
		enemigo.recibirAtaque(this.atacar());
	}

	public void recibirAtaque(int ataqueEnemigo) {
		salud -= ataqueEnemigo;
	}
}
