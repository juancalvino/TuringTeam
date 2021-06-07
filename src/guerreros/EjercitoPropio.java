package guerreros;

public class EjercitoPropio extends EjercitoAliado implements Comparable<EjercitoAliado>{

	EjercitoPropio instancia;

	private EjercitoPropio() {
		this.tipo = TipoEjercito.PROPIO;
	}

	public EjercitoPropio getEjercitoPropio() {
		if (instancia == null) {
			instancia = new EjercitoPropio();
		}
		return instancia;
	}

	public void sumarAliados(EjercitoAliado ejercitoAliados) {
		this.cola.add(ejercitoAliados);
	}

	@Override
	public int compareTo(EjercitoAliado other) {
		return other.tipo == tipo.ALIADO
				? 1 : 0;
	}

	
}
