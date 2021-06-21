package combatientes;

public interface Combatiente {

	/**
	 * @return la salud de un Combatiente
	 */
	public int getSalud();

	/**
	 * @return el ataque de un Combatiente
	 */
	public int atacar();

	/**
	 * @return recibe el ataque de un Combatiente
	 */
	public void recibirAtaque(int ataque);

	/**
	 * @return descansa/n los Combatientes
	 */
	public void descansar();

	/**
	 * Cambia el estado "combatio" de un guerrero a True.
	 */
	public void guerreroCombatio();

}
