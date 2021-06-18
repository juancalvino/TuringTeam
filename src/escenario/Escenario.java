package escenario;

import java.util.TreeMap;

import combatientes.ejercito.EjercitoJugador;

public class Escenario {

	private int cantidadDePueblos;
	private TreeMap<String, Pueblo> mapaDePueblos;

	private EjercitoJugador jugador;

	private String origen;
	private String destino;
	
//	List<Camino> listaDeCaminos;	
	
	private static Escenario unicaInstancia;

	private Escenario() {
		
		this.cantidadDePueblos = 0;
		this.mapaDePueblos = new TreeMap<String, Pueblo>();;
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

	public void agregarPueblo(Pueblo pueblo) {
		mapaDePueblos.put(pueblo.getNombre(), pueblo);
	}

	public void setMapaDePueblos(TreeMap<String, Pueblo> mapaDePueblos) {
		this.mapaDePueblos = mapaDePueblos;
	}

	public String getOrigen() {
		return origen;
	}

	public void cargarRuta(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public String getDestino() {
		return destino;
	}


	public EjercitoJugador getJugador() {
		return jugador;
	}

	public void setJugador(EjercitoJugador jugador) {
		this.jugador = jugador;
	}
	
	protected TreeMap<String, Pueblo> getMapaDelPueblos(){
		return mapaDePueblos;
	}
	
}
