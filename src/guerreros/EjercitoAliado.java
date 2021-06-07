package guerreros;

public class EjercitoAliado extends Ejercito implements Comparable<EjercitoAliado>{

	public EjercitoAliado() {
		this.tipo = TipoEjercito.ALIADO;
	}
	

	@Override
	public int compareTo(EjercitoAliado other) {
		return other.tipo == tipo.ALIADO
				? 1 : -1;
	}
}
