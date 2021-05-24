package razas;

public abstract class Guerreros {

	public abstract int getSalud();

	public abstract int atacar();
	
	public void atacar(Guerreros enemigo) {
		enemigo.recibirAtaque(this.atacar());
	}
	
	public abstract void recibirAtaque(int ataque);
	
	public abstract void descansar();
	
	
}
