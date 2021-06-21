package combatientes.guerrero;

public class Wrives extends Guerrero {

	private boolean activoParaAtacar;
	private boolean atacaCritico;

	/**
	 * Inicializa al Guerrero para ser utilizado
	 */
	public Wrives() {
		this.salud = 108;
		this.danioBasico = 113;
		this.atacaCritico = true;
		this.activoParaAtacar = true;
	}

	/**
	 * Si esta inactivo su danio es 0.
	 * Hace con 2 veces su daño, cada 2 ataques
	 * @return ataque.
	 */
	@Override
	public int atacar() {
		if (!activoParaAtacar) {
			return 0;
		}
		return (atacaCritico = !atacaCritico) ? super.atacar() * 2 : super.atacar();
	}

	/**
	 * Al recibir un 'ataqueEnemigo' recibe 2 veces el daño
	 */
	@Override
	public void recibirAtaque(int ataqueEnemigo) {
		super.recibirAtaque(ataqueEnemigo * 2);
		activoParaAtacar = true;
	}

	/**
	 * Descansa.
	 * Su salud maxima aumenta en 50.
	 * Camba su estado 'activoParaAtacar' en False.
	 */
	@Override
	public void descansar() {
		salud += 50;
		activoParaAtacar = false;
	}
	
	
	/**
	 * @return una nueva instancia de la clase.
	 */
	@Override
	protected Guerrero crearUnidad() {
		return new Wrives();
	}
}