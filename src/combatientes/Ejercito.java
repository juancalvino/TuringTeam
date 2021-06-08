package combatientes;

import java.util.PriorityQueue;
import java.util.Queue;


public abstract class Ejercito implements Combatiente, Comparable<Ejercito> {

	protected Queue<Combatiente> cola = new PriorityQueue<Combatiente>();

	public Ejercito() {}
	
	public Ejercito(Guerrero tipo, int cantidad){
		try {
			cola.addAll(tipo.crearLista(Verificador.dePositividad(cantidad)));
			}
		catch(NegativeNumberException e){
			System.err.println("La cantidad de guerreros no puede ser menor a 0");
			e.printStackTrace();
		}
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
		if(!cola.isEmpty())
			return cola.peek().getSalud();
		return -1;
	}
	
	@Override
	public int atacar() {
		return cola.peek().atacar();
	}

	@Override
	public void recibirAtaque(int ataque){
		try {
			cola.peek().recibirAtaque(Verificador.dePositividad(ataque));
	
			if(cola.peek().getSalud() <= 0) {
				cola.remove();
			}
		}
		catch( NegativeNumberException e){
			System.err.println("El ataque no puede ser menor a 0");
			e.getStackTrace();
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
	public int compareTo(Ejercito other) {
		
		if(this.getClass() == other.getClass()) {
			return 0;
		}
		if(other instanceof EjercitoAliado) {
			return 1; 
		}
		
		return -1;
		
	}
}
