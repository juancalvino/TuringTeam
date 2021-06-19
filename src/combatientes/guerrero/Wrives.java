package combatientes.guerrero;

public class Wrives extends Guerrero {

	private boolean activoParaAtacar;
	private boolean atacaCritico;

	public Wrives() {
		this.salud = 108;
		this.danioBasico = 113;
		this.atacaCritico = true;
		this.activoParaAtacar = true;
	}

	@Override
	public int atacar() {
		if (!activoParaAtacar) {
			return 0;
		}
		return (atacaCritico = !atacaCritico) ? super.atacar() * 2 : super.atacar();
	}

	@Override
	public void recibirAtaque(int ataqueEnemigo) {
		super.recibirAtaque(ataqueEnemigo * 2);
		activoParaAtacar = true;
	}

	@Override
	public void descansar() {
		salud += 50;
		activoParaAtacar = false;
	}

	@Override
	protected Guerrero crearUnidad() {
		return new Wrives();
	}
}