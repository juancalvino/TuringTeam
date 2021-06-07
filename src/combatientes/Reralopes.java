package combatientes;

public class Reralopes extends Guerrero {

	private boolean ataqueEsSatisfactorio;
	private int ataquesConsecutivos;
	private int ataquesConcentrados;

	public Reralopes() {
		this.salud = 53;
		this.danioBasico = 27;
		this.ataquesConsecutivos = 0;
		this.ataquesConcentrados = 0;
		this.ataqueEsSatisfactorio = true;
	}

	/**
	 * Erra 2 de cada 4 ataques. Los primeros 2 ataques (ataquesConsecutivos = 0 o
	 * 1) serán satisfactorios mientras que los 2 siguientes serán errados
	 * (ataquesConsecutivos = 2 o 3).
	 *
	 * @return Devuelve el valor de danio del proximo ataque. Devuelve 0 en caso de
	 *         que sea ataque errado y el daño se duplica si el ataque es critico
	 */
	@Override
	public int atacar() {
		if (ataquesConsecutivos >= 2) {
			ataquesConsecutivos = 0;
			ataqueEsSatisfactorio = !ataqueEsSatisfactorio;
		}

		int ataque = super.atacar();

		if (ataquesConcentrados > 0) {
			ataque *= 2;
			ataquesConcentrados--;
		}

		ataquesConsecutivos++;

		return ataqueEsSatisfactorio ? ataque : 0;
	}

	/**
	 * @param danioDeAtaque: valor entero que indica el valor del danio recibido de
	 *                       un ataque post: se resta el valor de 'salud' a partir
	 *                       del 'danioDeAtaque'. Se reinicia 'ataquesConcentrados'.
	 */
	@Override
	public void recibirAtaque(int danioDeAtaque) {
		super.recibirAtaque(danioDeAtaque);
		ataquesConcentrados = 0;
	}

	/**
	 * post: La unidad descansa, haciendo que sus proximos tres ataques sean
	 * criticos
	 */
	@Override
	public void descansar() {
		ataquesConcentrados = 3;
	}
	
	@Override
	protected Guerrero crearUnidad() {
		return new Reralopes();
	}
}