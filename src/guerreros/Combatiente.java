package guerreros;

public interface Combatiente {

	public int getSalud();

	public int atacar();

	public void recibirAtaque(int ataque);
	
	public void descansar();

}
