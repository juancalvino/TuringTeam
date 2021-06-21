package combatientes.ejercito;

import java.util.PriorityQueue;
import java.util.Queue;

import combatientes.Combatiente;
import combatientes.guerrero.Guerrero;

public abstract class Ejercito implements Combatiente, Comparable<Ejercito> {

	protected Queue<Combatiente> cola = new PriorityQueue<Combatiente>();

	protected Ejercito() {
	}

	public Ejercito(Guerrero tipo, int cantidad) {
		if (cantidad < 0) {
			throw new IllegalArgumentException("La cantidad ingresada debe ser mayor a 0");
		}
		cola.addAll(tipo.crearLista(cantidad));
	}

	/**
	 * @return la salud del primer Guerrero de la cola del Ejercito
	 */
	@Override
	public int getSalud() {
		if (!cola.isEmpty())
			return cola.peek().getSalud();
		return -1;
	}

	/**
	 * @return el ataque del primer Guerrero la cola del Ejercito
	 */
	@Override
	public int atacar() {
		return cola.peek().atacar();
	}

	/**
	 * Se recibe un ataque
	 * 
	 * @param ataque debe ser mayor o igual a 0
	 * @throws IllegalArgumentException si ataque es menor a 0
	 * @return el ataque del primer Guerrero la cola del Ejercito
	 */
	@Override
	public void recibirAtaque(int ataque) {
		if (ataque < 0) {
			throw new IllegalArgumentException("La cantidad ingresada debe ser mayor a 0");
		}

		if (!cola.isEmpty()) {
			cola.peek().recibirAtaque(ataque);
		}

		if (cola.peek().getSalud() <= 0) {
			cola.remove();
		}
	}

	/**
	 * Descansan todo los Combatientes
	 */
	@Override
	public void descansar() {
		for (Combatiente combatiente : cola) {
			combatiente.descansar();
		}
	}

	/**
	 * @return la cantidad total de guerreros
	 */
	public int cantidadDeGuerreros() {
		return cola.size();
	}

	/**
	 * El ultimo Combatiente de la cola cambia su estado de combatio
	 */
	@Override
	public void guerreroCombatio() {
		if (!cola.isEmpty()) {
			Combatiente guerrero = cola.poll();
			guerrero.guerreroCombatio();
			cola.add(guerrero);
		}
	}

	/**
	 * Compara a los ejercitos con la instancia EjercitoUnico para ser ultilizado en
	 * una cola de prioridad y enviarlo al final de la cola.
	 */
	@Override
	public int compareTo(Ejercito other) {

		if (other instanceof EjercitoUnico) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * El ejercito interactua con el ejercito jugador. Si es EjercitoAliado se unira
	 * a EjercitoPropio y EjercitoPropio descansara. Si es EjercitoEnemigo batallara
	 * contra el EjercitoPropio.
	 */
	public abstract void interactuar();

}
