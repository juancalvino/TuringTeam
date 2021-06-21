package combatientes.guerrero;


public class Nortaichian extends Guerrero {

	private int turnosEnfurecido;
	private int turnosPiedra;

	/**
	 * Inicializa al Guerrero para ser utilizado
	 */
	public Nortaichian() {
		this.salud = 66;
		this.danioBasico = 18;
		this.turnosEnfurecido = 0;
		this.turnosPiedra = 0;
	}

	/**
	 * Cuando un Nortaichian esta hecho piedra su danio es 0.
	 * Si esta enfurecido ataca el doble.
	 * Recupera un 4% de su salud
	 * 
	 * @return el ataque
	 */
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

	/**
	 * Recibe un 'ataque' externo
	 * Se enfurece.
	 * Y si se encuentra hecho piedra recibe la mitad del 'ataque'.
	 */
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

	/**
	 * Descansa
	 * Recupera su salud inicial
	 * Se convierte en piedra por 2 turnos
	 */
	@Override
	public void descansar() {
		this.salud = 66;
		turnosPiedra = 2;
	}
	
	/**
	 * @return una nueva instancia de la clase.
	 */
	@Override
	protected Guerrero crearUnidad() {
		return new Nortaichian();
	}
}
