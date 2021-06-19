package combatientes.ejercito;

import combatientes.Combatiente;
import combatientes.guerrero.Guerrero;
import escenario.Escenario;

public class EjercitoPropio extends Ejercito {

	public EjercitoPropio(Guerrero tipo, int cantidad) {
		EjercitoUnico.startEjercitoPropio(tipo, cantidad);
		this.cola.add(EjercitoUnico.getEjercito());
	}

	public void agregarEjercito(EjercitoAliado aliado) {
		this.cola.add(aliado);
	}


	@Override
	public int cantidadDeGuerreros() {

		int total = 0;

		for (Combatiente combatiente : cola) {
			Ejercito ejercito = (Ejercito) combatiente;
			total += ejercito.cantidadDeGuerreros();
		}
		
		return total;
	}

	@Override
	public void interactuar() {
		// no hace nada
	}
	
}
