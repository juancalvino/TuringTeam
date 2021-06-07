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

	public int getSaludTotal() {
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
		cola.peek().recibirAtaque(ataque);
	}

	@Override
	public void descansar() {
		for (Combatiente combatiente : cola) {
			combatiente.descansar();
		}
	}
	
	public Queue<Combatiente> devolverCola(){
		return cola;
	}
}
