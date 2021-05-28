package Guerreros;

public class Wrives extends Guerrero {
 
	private boolean activo;
	private boolean atacaNormal;
	

	@Override
	public void posicionar() {
		this.salud = 108 + powerUp;
		this.danioBasico = 113;
		this.atacaNormal = true;
		this.activo = true;
	}
	

	@Override
	public int atacar() {
		if(!activo) {
			return 0;
		}
		return (atacaNormal = !atacaNormal)? super.atacar()* 2 : super.atacar();
	}

	@Override
	public void recibirAtaque (int ataqueEnemigo) {
		super.recibirAtaque(ataqueEnemigo);
		activo  = true;
	}

	@Override
	public void descansar() {
		activo = false;
		salud += 50;
		powerUp += 50;
	}
}