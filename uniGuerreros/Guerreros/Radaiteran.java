package Guerreros;

public class Radaiteran extends Guerrero{

	@Override
	public void posicionar() {
		this.salud = 36;
		this.danioBasico = 56;
		this.powerUp = 0;
	}
	
	@Override
	public int atacar() {
		return super.atacar() + powerUp;
	}
	
	@Override
	public void atacar(Guerrero enemigo) {
		super.atacar(enemigo);
		powerUp += 3;
	}
	
	public boolean isActivo() {
		return activo;
	}








}
