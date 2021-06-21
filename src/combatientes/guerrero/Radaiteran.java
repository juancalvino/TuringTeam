package combatientes.guerrero;

public class Radaiteran extends Guerrero {

	private int contadorDeAtaques;

	/**
	 * Inicializa al Guerrero para ser utilizado
	 */
	public Radaiteran() {
		this.salud = 36;
		this.danioBasico = 56;
		this.contadorDeAtaques = 0;
	}

	/**
	 * Ataca y su ataque crece en 3.
	 */
	@Override
	public int atacar() {
		return super.atacar() + getDanioExtraPorAtaques();
	}

	/**
	 * Acrecienta el ataque en 3
	 * @return el crecimiento total del ataque.
	 */
	private int getDanioExtraPorAtaques() {
		return this.contadorDeAtaques++ * 3;
	}

	/**
	 * @return una nueva instancia de la clase.
	 */
	@Override
	protected Guerrero crearUnidad() {
		return new Radaiteran();
	}
}
