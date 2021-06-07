package guerreros;

public class EjercitoPropio extends EjercitoAliado{

	EjercitoPropio instancia;
	
	private EjercitoPropio() {
		this.tipo = TipoEjercito.PROPIO;
	}
	
	public EjercitoPropio getEjercitoPropio(){
		if(instancia == null) {
			instancia = new EjercitoPropio();
		}
		
		return instancia;
	}

}
