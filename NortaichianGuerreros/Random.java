package razas;

public class Random extends Guerreros{

	private int salud;
	private int danioBasico;
	private boolean activo;
	
	public Random() {
		this.salud = 100;
		this.danioBasico = 10;
	}

	@Override
	public int getSalud() {
		return this.salud;
	}

	@Override
	public int atacar() {
		return this.danioBasico;
	}
	

	@Override
	public void recibirAtaque(int ataque) {
		this.salud -= ataque;
	}

	@Override
	public void descansar() {
		
	}

}
