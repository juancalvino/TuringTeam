package combatientes.guerrero;


public class Nortaichian extends Guerrero {

	private int turnosEnfurecido;
	private int turnosPiedra;

	public Nortaichian() {
		this.salud = 66;
		this.danioBasico = 18;
		this.turnosEnfurecido = 0;
		this.turnosPiedra = 0;
	}

	@Override
	public int atacar() {
		
		if (turnosPiedra > 0) {
			turnosPiedra--;
			return 0;
		}

		--turnosEnfurecido;
		this.salud += salud * 0.04;
		
		return (turnosEnfurecido >= 0) ? super.atacar() * 2 : super.atacar();
	}

	
	@Override
	public void recibirAtaque(int ataque) {
		turnosEnfurecido = 2;

		int ataqueRecibido = ataque;

		if (turnosPiedra > 0) {
			ataqueRecibido = ataque / 2;
		}

		super.recibirAtaque(ataqueRecibido);
		turnosPiedra--; 
	}

	@Override
	public void descansar() {
		this.salud = 66;
		turnosPiedra = 2;
	}
	
	@Override
	protected Guerrero crearUnidad() {
		return new Nortaichian();
	}
}
