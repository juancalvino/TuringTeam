package escenario;

import combatientes.ejercito.Ejercito;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Pueblo {
    private final HashMap<String, Camino> caminos = new HashMap<>();
    private Ejercito ejercito;
    private final String nombre;
    
    public Pueblo(String nombre) {
        this.nombre = nombre;
    }
    
    public Pueblo(int numeroDePueblo, Ejercito ejercito) {
        this.nombre = String.valueOf(numeroDePueblo);
        this.ejercito = ejercito;
    }
    
    public void agregarCamino(Camino camino) {
        caminos.put(camino.getPuebloDestino().nombre, camino);
    }
    
    public Map<String, Camino> obtenerCaminosAdyacentes() {
        return Collections.unmodifiableMap(caminos);
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public Ejercito getEjercito() {
        return this.ejercito;

    }
}