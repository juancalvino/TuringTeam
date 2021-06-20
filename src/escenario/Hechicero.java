package escenario;

import iO.CargaDeArchivos;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Hechicero {

    static Escenario escenario = Escenario.getInstance();
    HashMap<String, String> recorrido = new HashMap<>();
    int tiempoDeRecorrido;

    public Hechicero() {
    }

    public String realizarPrediccionDeAventura() {
        String resultado;
        tiempoDeRecorrido = 0;
        recorrido = calcularRecorrido(dijkstra(escenario.getOrigen()));
        String puebloActual = escenario.getOrigen();

        while (!puebloActual.equals(escenario.getDestino()) && avanzarAlSiguientePueblo(puebloActual)) {
            tiempoDeRecorrido += escenario.getMapaDePueblos().get(puebloActual).getCaminosAdyacentes().get(recorrido.get(puebloActual)).getRecorridoEnDias();
            puebloActual = recorrido.get(puebloActual);
        }

        if (!puebloActual.equals(escenario.getDestino())) {
            resultado = "Mision fallida.";
        } else {
            resultado = "Mision exitosa. Sobrevivieron: " + escenario.getJugador().cantidadDeGuerreros()
                    + " guerreros. El recorrido tuvo una duracion de: " + tiempoDeRecorrido + " dias.";
        }
        return resultado;
    }

    public static void main(String[] args) {
        Hechicero hechicero = new Hechicero();
        CargaDeArchivos carga = new CargaDeArchivos();
        carga.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoConsigna.txt");
        System.out.println(hechicero.calcularRecorrido(hechicero.dijkstra("1")));
        System.out.println(hechicero.realizarPrediccionDeAventura());
    }

    private boolean avanzarAlSiguientePueblo(String actual) {
        escenario.getMapaDePueblos().get(recorrido.get(actual)).interactuar();
        return escenario.getJugador().getSalud() > 0;
    }

    private HashMap<String, String> dijkstra(String inicio) {
        HashMap<String, Boolean> visitados = new HashMap<>();
        HashMap<String, Integer> distancias = new HashMap<>();
        HashMap<String, String> camino = new HashMap<>();
        PriorityQueue<Camino> cola = new PriorityQueue<>();

        // Paso 1, 2 y 3
        for (Map.Entry<String, Pueblo> vertice : escenario.getMapaDePueblos().entrySet()) {
            distancias.put(vertice.getKey(), Integer.MAX_VALUE);
            visitados.put(vertice.getKey(), false);
            camino.put(vertice.getKey(), null);
        }

        // Paso 4
        distancias.put(inicio, 0);

        cola.add(new Camino((escenario.getMapaDePueblos().get(inicio)), 0));

        // Paso 5
        while (!cola.isEmpty()) {
            Camino caminito = cola.poll();

            if (!visitados.get(caminito.getPuebloDestino().getNombre())) {
                visitados.put(caminito.getPuebloDestino().getNombre(), true);

                for (Map.Entry<String, Camino> aristaAdyacente : caminito.getPuebloDestino().getCaminosAdyacentes().entrySet()) {
                    if (!visitados.get(aristaAdyacente.getKey())) {
                        if (caminito.getRecorridoEnDias() + aristaAdyacente.getValue().getRecorridoEnDias() < distancias.get(aristaAdyacente.getKey())) {
                            distancias.put(aristaAdyacente.getKey(), caminito.getRecorridoEnDias() + aristaAdyacente.getValue().getRecorridoEnDias());
                            camino.put(aristaAdyacente.getKey(), caminito.getPuebloDestino().getNombre());
                            cola.add(new Camino(aristaAdyacente.getValue().getPuebloDestino(), distancias.get(aristaAdyacente.getKey())));
                        }
                    }
                }
            }
        }
        return camino;
    }

    private Stack<String> calcularRecorridoYTiempoARecorrer(HashMap<String, String> camino) {
        Stack<String> recorrido = new Stack<>();
        recorrido.push(escenario.getDestino());
        String claveAuxiliar = recorrido.peek();

        while (!camino.get(claveAuxiliar).equals(escenario.getOrigen())) {
            recorrido.push(camino.get(claveAuxiliar));
            tiempoDeRecorrido += escenario.getMapaDePueblos().get(recorrido.peek()).getCaminosAdyacentes().get(claveAuxiliar).getRecorridoEnDias();
            claveAuxiliar = recorrido.peek();
        }
        return recorrido;
    }

    public HashMap<String, String> calcularRecorrido(HashMap<String, String> camino) {
        HashMap<String, String> recorrido = new HashMap<>();
        for (Map.Entry<String, String> entrada : camino.entrySet()) {
            String key = entrada.getKey();
            String value = entrada.getValue();
            recorrido.put(value, key);
        }
        return recorrido;
    }
}