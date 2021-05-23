package Guerreros;

public class GuerreroRandom extends Guerreros{

	
	private final int saludPosicionada;
	private final int danioPosicionado;	
	private int salud;
	private int danioBasico;

	public GuerreroRandom(int salud , int danio) {
		this.saludPosicionada = salud;
		this.danioPosicionado = danio;
		posicionar();
	}
	
	@Override
	public void posicionar() {
		 	salud = saludPosicionada;
		 	danioBasico = danioPosicionado;
	}

	public int getSalud() {
		return salud;
	}

	@Override
	public int atacar() {
		return danioBasico;
	}
	
	@Override
	public void recibirAtaque (int ataqueEnemigo) {
			salud -= ataqueEnemigo;
	}

	@Override
	public void atacar(Guerreros enemigo) {
		enemigo.recibirAtaque(this.atacar());
	}

	@Override
	public void descansar() {
	}

}
