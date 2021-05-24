package Guerreros;

public abstract class Guerreros {

	public abstract int getSalud(); 
	public abstract void descansar();
	public abstract void atacar(Guerreros enemigo);
	public abstract void recibirAtaque (int ataqueEnemigo);
}