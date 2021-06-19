package escenario;

import iO.CargaDeArchivos;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Hechicero {

    static Escenario escenario = Escenario.getInstance();
    Stack<String> recorrido;

    public String realizarPrediccionDeAventura() {
        String resultado;
        recorrido = calcularRecorrido(dijkstra(escenario.getOrigen()));

        int tiempoDeRecorrido = 0;
        while (!recorrido.isEmpty() && avanzarAlSiguientePueblo()) {
            // TODO: 19/6/2021 Implementar el calculo del tiempo de recorrido.
            tiempoDeRecorrido++;
        }

        if (!recorrido.isEmpty()) {
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
        System.out.println(hechicero.realizarPrediccionDeAventura());
    }

    private boolean avanzarAlSiguientePueblo() {
        escenario.getMapaDePueblos().get(recorrido.pop()).interactuar();
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

    private Stack<String> calcularRecorrido(HashMap<String, String> camino) {
        Stack<String> recorrido = new Stack<>();
        recorrido.push(escenario.getDestino());
        String claveAuxiliar = recorrido.peek();

        while (!camino.get(claveAuxiliar).equals(escenario.getOrigen())) {
            recorrido.push(camino.get(claveAuxiliar));
            claveAuxiliar = recorrido.peek();
        }
        return recorrido;
    }


}