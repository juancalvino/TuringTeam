package Guerreros;


public class GuerreroRandom extends Guerrero{

	private final int saludPosicionada;
	private final int danioPosicionado;	

	public GuerreroRandom(int salud , int danio) {
		this.saludPosicionada = salud;
		this.danioPosicionado = danio;
		posicionar();
	}
	
	@Override
	public void posicionar() {
		 	salud = saludPosicionada;
		 	danioBasico = danioPosicionado;
	}
}
