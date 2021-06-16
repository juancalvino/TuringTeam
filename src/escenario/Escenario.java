package escenario;

import combatientes.ejercito.EjercitoPropio;

import java.util.HashMap;

public class Escenario {

	private int cantidadDePueblos;
	private HashMap<String, Pueblo> mapaDePueblos;
	private EjercitoPropio jugador;
	private String origen;
	private String destino;

	private static Escenario unicaInstancia;

	private Escenario() {
		this.cantidadDePueblos = 0;
		this.mapaDePueblos = new HashMap<>();
		this.origen = null;
		this.destino = null;
	}

	public static Escenario getInstance() {
		if (unicaInstancia == null) {
			unicaInstancia = new Escenario();
		}
		return unicaInstancia;
	}

	public int getCantidadDePueblos() {
		return cantidadDePueblos;
	}

	public void setCantidadDePueblos(int cantidadDePueblos) {
		this.cantidadDePueblos = cantidadDePueblos;
	}

	public void setMapaDePueblos(HashMap<String, Pueblo> mapaDePueblos) {
		this.mapaDePueblos = mapaDePueblos;
	}

	public void cargarRuta(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public EjercitoPropio getJugador() {
		return jugador;
	}

	public void setJugador(EjercitoPropio jugador) {
		this.jugador = jugador;
	}

	public HashMap<String, Pueblo> getMapaDePueblos() {
		return mapaDePueblos;
	}
}