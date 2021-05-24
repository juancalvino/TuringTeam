package Guerreros;

public class Radaiteran extends Guerreros{

	private int salud;
	private int danioBasico;
	private boolean activo;
	private int potenciador;

	public Radaiteran() {
		this.setActivo(true);
		this.salud = 36;
		this.danioBasico = 56;
	}

	public int getDanioBasico() {
		return danioBasico;
	}

	public int getSalud() {
		return salud;
	}

	@Override
	public void descansar() {
		setActivo(false);
	}

	@Override
	public void atacar(Guerreros enemigo) {
		setActivo(true);
		enemigo.recibirAtaque(danioBasico + potenciador);
		potenciador += 3;
	}

	@Override
	public void recibirAtaque(int ataqueEnemigo) {
		salud -= ataqueEnemigo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
