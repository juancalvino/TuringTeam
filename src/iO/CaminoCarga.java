package iO;

public class CaminoCarga {
	private final String destino;
	private final int longitudTrayecto;

	public CaminoCarga(String destino, int longitudTrayecto) {
		this.destino = destino;
		this.longitudTrayecto = longitudTrayecto;
	}

	public String getPuebloDestino() {
		return this.destino;
	}

	public int getRecorridoEnDias() {
		return this.longitudTrayecto;
	}
}
