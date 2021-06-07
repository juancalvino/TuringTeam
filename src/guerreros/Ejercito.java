package guerreros;

import java.util.Queue;

public abstract class Ejercito implements Combatiente{

	protected TipoEjercito tipo;
	Queue<Combatiente> cola;
	
	@Override
	public int getSalud() {
		int saludTotal = 0;
		
		for (Combatiente combatiente : cola) {
			saludTotal += combatiente.getSalud();
		}
		
		return saludTotal;
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
		
}
