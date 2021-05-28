package Guerreros;

public abstract class Guerrero {

	protected int salud;
	protected int danioBasico;
	protected int powerUp;
	
	public Guerrero() {
		posicionar();
	}	
	
	public abstract void posicionar();
	
	public int getSalud() {
		return this.salud;
	}

	public int getDanioBasico() {
		return this.danioBasico;
	}
	
	public void descansar() {
	}

	public int atacar() {
		return danioBasico;
	}
	
	public void atacar(Guerrero enemigo) {
		enemigo.recibirAtaque(this.atacar());
	}
	
	public void recibirAtaque(int ataqueEnemigo) {
		salud -= ataqueEnemigo;
	}
}

