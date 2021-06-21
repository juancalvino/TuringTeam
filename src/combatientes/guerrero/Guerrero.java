package combatientes.guerrero;

import java.util.ArrayList;
import combatientes.Combatiente;

public abstract class Guerrero implements Combatiente, Comparable<Guerrero> {

	protected int salud;
	protected int danioBasico;
	private boolean combatio;

	/**
	 * Inicializa al guerrero para ser utilizado
	 */
	public Guerrero() {
		this.combatio = false;
	}

	/**
	 * @return la salud del Guerrero
	 */
	public int getSalud() {
		return this.salud;
	}

	/**
	 * El guerrero descansa
	 */
	public void descansar() {
	}

	/**
	 * @return el ataque
	 */
	public int atacar() {
		return this.danioBasico;
	}

	/**
	 * Recibe un ataque externo
	 * 
	 * @param ataqueEnemigo debe ser mayor o igual que 0
	 * @throws si el 'ataqueEnemigo' es menor que 0
	 */
	public void recibirAtaque(int ataqueEnemigo) {
		if (ataqueEnemigo < 0) {
			throw new IllegalArgumentException("El ataque no puede ser menor a 0");
		}

		salud -= ataqueEnemigo;
	}

	/**
	 * Compara los tipos de guerreno para poder ordenarlos y enviar aquellos
	 * Guerreros que ya combatieron a lo ultimo.
	 */
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

	/**
	 * Cambia el estado de 'combatio' a true.
	 */
	@Override
	public void guerreroCombatio() {
		this.combatio = true;
	}

	/**
	 * @return si el Guerrero combatio
	 */
	private boolean getCombatio() {
		return this.combatio;
	}

	/**
	 * Crea una lista de Guerreros
	 * 
	 * @param cantidad debe ser mayor o igual a 0
	 * @return lista de Guerreros
	 */
	public ArrayList<Guerrero> crearLista(int cantidad) {
		ArrayList<Guerrero> lista = new ArrayList<Guerrero>();

		for (int i = 0; i < cantidad; i++) {
			lista.add(crearUnidad());
		}

		return lista;
	};

	/**
	 * Crea un guerrero
	 * 
	 * @return Guerrero
	 */
	protected abstract Guerrero crearUnidad();

}
