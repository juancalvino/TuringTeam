package combatientes.guerrero;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import combatientes.Combatiente;

public abstract class Guerrero implements Combatiente, Comparable<Guerrero> {

	protected int salud;
	protected int danioBasico;
	private boolean combatio;

	public Guerrero() {
		this.combatio = false;
	}

	public int getSalud() {
		return this.salud;
	}

	public void descansar() {
	}

	public int atacar() {
		return this.danioBasico;
	}

	public void recibirAtaque(int ataqueEnemigo) {
		if(ataqueEnemigo < 0) {
			throw new IllegalArgumentException("El ataque no puede ser menor a 0");
		}
		
		salud -= ataqueEnemigo;
	}

	@Override
	public int compareTo(Guerrero other) { 
		if (this.getCombatio() == other.getCombatio()) {
			return 0;
		}
		if (this.getCombatio()) {
			return 1;
		}
		return -1;
	}

	@Override
	public void guerreroCombatio() {
		this.combatio = true;
	}

	private boolean getCombatio() {
		return this.combatio;
	}

	public ArrayList<Guerrero> crearLista(int cantidad) {
		ArrayList<Guerrero> lista = new ArrayList<Guerrero>();

		for (int i = 0; i < cantidad; i++) {
			lista.add(crearUnidad());
		}

		return lista;
	};

	protected abstract Guerrero crearUnidad();

	
	public static void main(String[] args) {
		Combatiente guerrero1 = new GuerreroHack(10, 10);
		Combatiente guerrero2 = new GuerreroHack(20, 20);
		
		Queue<Combatiente> cola = new PriorityQueue<Combatiente>();
		cola.add(guerrero1);
		cola.add(guerrero2);
		
		System.out.println(cola.peek().getSalud());

		Combatiente guerrero3 = new GuerreroHack(30, 30);
		cola.add(guerrero3);


		System.out.println(cola.peek().getSalud());
		
		cola.peek().guerreroCombatio();

		System.out.println(cola.peek().getSalud());

	}
}
