package razas;

public class Nortaichian extends Guerreros {

	private int salud;
	private int danioBasico;
	private int turnosEnfurecido;
	private int turnosPiedra;

	public Nortaichian() {
		this.salud = 66;
		this.danioBasico = 18;
	}

	@Override
	public int getSalud() {
		return this.salud;
	}

	@Override
	public int atacar() {

		if (turnosPiedra > 0) {
			return 0;
		}

		this.salud += salud * 0.04;

		return turnosEnfurecido-- != 0 ? this.danioBasico * 2 : this.danioBasico;
	}

	@Override
	public void recibirAtaque(int ataque) {

		if (turnosEnfurecido == 0 && turnosPiedra == 0) {
			turnosEnfurecido = 2;
		}

		if (turnosPiedra > 0) {
			this.salud -= ataque / 2;
			turnosPiedra--;
		} else {
			this.salud -= ataque;
		}
	}

	@Override
	public void descansar() {
		this.salud = 66;
		turnosPiedra = 2;
	}

}
