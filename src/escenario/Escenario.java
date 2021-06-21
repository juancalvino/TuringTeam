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
<<<<<<< HEAD
     * Inicializa el Escenario
=======
     * Inicializa el escenario.
>>>>>>> branch 'IO-Escenario' of https://github.com/juancalvino/TuringTeam.git
     */
    private Escenario() {
        this.mapaDePueblos = new HashMap<>();
        this.origen = null;
        this.destino = null;
    }

    /**
<<<<<<< HEAD
     * @return el Escenario
=======
     * se crea una instancia unica del escenario.
     * @return el escenario
>>>>>>> branch 'IO-Escenario' of https://github.com/juancalvino/TuringTeam.git
     */
    public static Escenario getInstance() {
        if (unicaInstancia == null) {
            unicaInstancia = new Escenario();
        }
        return unicaInstancia;
    }

    /**
<<<<<<< HEAD
     * @return la cantidad de pueblos 
=======
     * @return la cantidad de pueblos.
>>>>>>> branch 'IO-Escenario' of https://github.com/juancalvino/TuringTeam.git
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
<<<<<<< HEAD
     * @return el mapa de los pueblos.
=======
     * @return el mapa de los pueblos
>>>>>>> branch 'IO-Escenario' of https://github.com/juancalvino/TuringTeam.git
     */
    public HashMap<String, Pueblo> getMapaDePueblos() {
        return mapaDePueblos;
    }
}
