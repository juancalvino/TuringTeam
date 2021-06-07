package guerreros;

public abstract class Guerrero implements Combatiente{

	protected int salud;
	protected int danioBasico;
	
	
	public Guerrero() {
	}
	
	public int getSalud() {
		return this.salud;
	}

	public void descansar() {
	}

	public int atacar() {
		return this.danioBasico;
	}

	public void recibirAtaque(int ataqueEnemigo) {
		salud -= ataqueEnemigo;
	}
	
}
