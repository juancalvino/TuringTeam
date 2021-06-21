package combatientes.ejercito;

import combatientes.Combatiente;
import combatientes.guerrero.Guerrero;
import escenario.Escenario;

public class EjercitoPropio extends Ejercito {

	/**
	 * Inicializa la instancia para ser utilizada. 
	 * @param tipo
	 * @param cantidad debe ser mayo o igual a 0.
	 */
	public EjercitoPropio(Guerrero tipo, int cantidad) {
		EjercitoUnico.startEjercitoPropio(tipo, cantidad);
		this.cola.add(EjercitoUnico.getEjercito());
	}

	/**
	 * Agrega a un EjercitoAliado a nuestro Ejercito.
	 * @param aliado
	 */
	public void agregarEjercito(EjercitoAliado aliado) {
		this.cola.add(aliado);
	}

	/**
	 * @return cantidad total de guerreros en nuestro ejercito, tanto aliados como
	 *         propios.
	 */
	@Override
	public int cantidadDeGuerreros() {

		int total = 0;

		for (Combatiente combatiente : cola) {
			Ejercito ejercito = (Ejercito) combatiente;
			total += ejercito.cantidadDeGuerreros();
		}

		return total;
	}

	/**
	 * No hace nada.
	 */
	@Override
	public void interactuar() {
		// no hace nada
	}

}
