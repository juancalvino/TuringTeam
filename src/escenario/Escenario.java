package escenario;

import combatientes.ejercito.EjercitoPropio;

import java.util.HashMap;

public class Escenario {

    private HashMap<String, Pueblo> mapaDePueblos;
    private EjercitoPropio jugador;
    private String origen;
    private String destino;

    private static Escenario unicaInstancia;

    /**
     * Inicializa el Escenario
     */
    private Escenario() {
        this.mapaDePueblos = new HashMap<>();
        this.origen = null;
        this.destino = null;
    }

    /**
     * se crea una instancia unica del escenario.
     * @return el escenario
     */
    public static Escenario getInstance() {
        if (unicaInstancia == null) {
            unicaInstancia = new Escenario();
        }
        return unicaInstancia;
    }

    /**
     * @return la cantidad de pueblos 
     */
    public int getCantidadDePueblos() {
        return mapaDePueblos.size();
    }

    /**
     * Cambia el mapa de pueblos.
     * @param mapaDePueblos
     */
    public void setMapaDePueblos(HashMap<String, Pueblo> mapaDePueblos) {
        this.mapaDePueblos = mapaDePueblos;
    }

    /**
     * Cambia el origen y el destino del Escenario.
     * @param origen
     * @param destino
     */
    public void cargarRuta(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    /**
     * @return el origen 
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @return el destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @return el ejercito del jugador.
     */
    public EjercitoPropio getJugador() {
        return jugador;
    }

    /**
     * Cambia el ejercito del jugador.
     * @param jugador
     */
    public void setJugador(EjercitoPropio jugador) {
        this.jugador = jugador;
    }

    /**
     * @return el mapa de los pueblos.
     */
    public HashMap<String, Pueblo> getMapaDePueblos() {
        return mapaDePueblos;
    }
}
