package guerreros;

public abstract class Guerrero implements Combatiente, Comparable<Guerrero>{

	protected int salud;
	protected int danioBasico;
	private boolean terminoUnaBatalla;
	
	public Guerrero() {
		this.terminoUnaBatalla = false;
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
	
	@Override
	public int compareTo(Guerrero other) {
		if(this.terminoUnaBatalla && other.getTerminoUnaBatalla()) {
			return 0;
		}
		if(this.terminoUnaBatalla) {
			return -1;
		}
		return 1;
	}

	public void terminoUnaBatalla() {
		this.terminoUnaBatalla = true;
	}
	
	public boolean getTerminoUnaBatalla() {
		return this.terminoUnaBatalla;
	}
	
}
