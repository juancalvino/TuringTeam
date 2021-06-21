package escenario;

import combatientes.ejercito.Ejercito;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


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

    public Map<String, Camino> getCaminosAdyacentes() {
        return Collections.unmodifiableMap(caminos);
    }

    /**
     * @return devuelve el nombre del pueblo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return devuelve el ejercito
     */
    public Ejercito getEjercito() {
        return this.ejercito;
    }

    public void setEjercito(Ejercito ejercito) {
        this.ejercito = ejercito;
    }

    /**
     * @return si otro pueblo es igual al actual a partir de su nombre y camino
     */
    @Override
    public boolean equals(Object otroPueblo) {
        if (this == otroPueblo) return true;
        if (otroPueblo == null || getClass() != otroPueblo.getClass()) return false;
        Pueblo pueblo = (Pueblo) otroPueblo;
        return Objects.equals(caminos, pueblo.caminos) && Objects.equals(nombre, pueblo.nombre);
    }
    
    public void interactuar() {
        ejercito.interactuar();
    }

}