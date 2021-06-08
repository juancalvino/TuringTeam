package combatientes;

import java.util.PriorityQueue;
import java.util.Queue;


public class Ejercito implements Combatiente {

	protected TipoEjercito tipo;
	Queue<Combatiente> cola = new PriorityQueue<Combatiente>();

	public Ejercito(TipoEjercito tipo) {
		this.tipo = tipo;
	}

	public Ejercito(Guerrero tipo, int cantidad) {
		cola.addAll(tipo.crearLista(cantidad));
	}

	public int getSaludTotalDelEjercito() {
		int saludTotal = 0;

		for (Combatiente combatiente : cola) {
			saludTotal += combatiente.getSalud();
		}
		return saludTotal;
	}
	
	@Override
	public int getSalud() {
		return cola.peek().getSalud();
	}
	
	@Override
	public int atacar() {
		return cola.peek().atacar();
	}

	@Override
	public void recibirAtaque(int ataque) {
		Combatiente combatiente = cola.peek();
		combatiente.recibirAtaque(ataque);
		
		if(combatiente.getSalud() <= 0) {
			cola.poll();
		}
	}

	@Override
	public void descansar() {
		for (Combatiente combatiente : cola) {
			combatiente.descansar();
		}
	}
	
	public int devolverCantidadDeGuerreros(){
		return cola.size();
	}
}
