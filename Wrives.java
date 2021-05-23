package Guerreros;

public class Wrives extends Guerreros {
 
	private int powerUp = 0;
	private int salud;
	private int danioBasico;
	private boolean atacaNormal;
	private boolean activo;
	
	public Wrives() {
		posicionar();
	}

	public void posicionar() {
		this.salud = 108 + powerUp;
		this.danioBasico = 113;
		this.atacaNormal = true;
		this.activo = true;
	}
	
	@Override
	public int getSalud() {
		return salud;
	}

	@Override
	public int atacar() {
		if(!activo) {
			return 0;
		}
		return (atacaNormal = !atacaNormal)? danioBasico * 2 : danioBasico;
	}

	@Override
	public void recibirAtaque (int ataqueEnemigo) {
			salud -= ataqueEnemigo;
			activo  = true;
	}

	@Override
	public void atacar(Guerreros enemigo) {
		enemigo.recibirAtaque(this.atacar());
	}

	@Override
	public void descansar() {
		activo = false;
		salud += 50;
		powerUp += 50;
	}
}
