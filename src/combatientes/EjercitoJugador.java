package combatientes;

public class EjercitoJugador extends Ejercito {
	
	public EjercitoJugador(Guerrero tipo, int cantidad) throws CreateInstanceEjercitoPropioException, NegativeNumberException {
		EjercitoUnico.startEjercitoPropio(tipo, cantidad);
		this.cola.add(EjercitoUnico.getEjercito());
	}
	
	public void  agregarEjercito(EjercitoAliado aliado) {
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
}
