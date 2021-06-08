package combatientes.guerrero;

import java.util.ArrayList;

import combatientes.Combatiente;

public abstract class Guerrero implements Combatiente, Comparable<Guerrero>{

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
		salud -= ataqueEnemigo;
	}
	
	@Override
	public int compareTo(Guerrero other) {
		if(this.combatio && other.getCombatio()) {
			return 0;
		}
		if(this.combatio) {
			return -1;
		}
		return 1;
	}

	@Override
	public void guerreroCombatio() {
		this.combatio = true;
	}
	
	private boolean getCombatio() {
		return this.combatio;
	}
	
	public ArrayList<Guerrero> crearLista(int cantidad){
		ArrayList<Guerrero> lista = new ArrayList<Guerrero>();
		
		for(int i=0; i<cantidad; i++) {
			lista.add(crearUnidad());
		}
		
		return lista;
	};
	
	protected abstract Guerrero crearUnidad();
	
}
