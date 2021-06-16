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

	@Override
	public int getSalud() {
		if (!cola.isEmpty())
			return cola.peek().getSalud();
		return -1;
	}

	@Override
	public int atacar() {
		return cola.peek().atacar();
	}

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

	@Override
	public void descansar() {
		for (Combatiente combatiente : cola) {
			combatiente.descansar();
		}
	}

	public int cantidadDeGuerreros() {
		return cola.size();
	}

	@Override
	public void guerreroCombatio() {
		if (!cola.isEmpty()) {
			Combatiente guerrero = cola.poll();
			guerrero.guerreroCombatio();
			cola.add(guerrero);
		}
	}

	@Override
	public int compareTo(Ejercito other) {
		return other instanceof EjercitoUnico? -1 : 0;
	}
}
