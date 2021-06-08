package combatientes;

public interface Combatiente {

	public int getSalud();

	public int atacar();

	public void recibirAtaque(int ataque) throws NegativeNumberException;
	
	public void descansar();

}