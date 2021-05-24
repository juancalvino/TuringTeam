package Guerreros;

public class GuerreroRandom extends Guerreros{
	
	private int salud;
	private int danioBasico;

	public GuerreroRandom(int salud , int danio) {
		this.salud = salud;
		this.danioBasico = danio;
	}

	public int getSalud() {
		return salud;
	}
	
	@Override
	public void recibirAtaque (int ataqueEnemigo) {
			salud -= ataqueEnemigo;
	}

	@Override
	public void atacar(Guerreros enemigo) {
		enemigo.recibirAtaque(danioBasico);
	}

	@Override
	public void descansar() {
	}

}