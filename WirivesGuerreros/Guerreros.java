package WirivesGuerreros;

public abstract class Guerreros {

	public abstract void posicionar();
	public abstract int getSalud(); 
	public abstract int atacar();
	public abstract void descansar();
	public abstract void atacar(Guerreros enemigo);
	public abstract void recibirAtaque (int ataqueEnemigo);
}
