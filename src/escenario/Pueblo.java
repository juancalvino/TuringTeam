package escenario;

import combatientes.ejercito.Ejercito;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Pueblo {
	//TODO Preguntar que conviene mas que el camino lo tenga el escenario o el pueblo?
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

    public Map<String, Camino> getCaminosAdyacentes() {
        return Collections.unmodifiableMap(caminos);
    }

    public String getNombre() {
        return this.nombre;
    }

    public Ejercito getEjercito() {
        return this.ejercito;
    }

    public void setEjercito(Ejercito ejercito) {
        this.ejercito = ejercito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pueblo pueblo = (Pueblo) o;
        return Objects.equals(caminos, pueblo.caminos) && Objects.equals(nombre, pueblo.nombre);
    }

    public void interactuar() {
    	ejercito.interactuar();
    }
    
}