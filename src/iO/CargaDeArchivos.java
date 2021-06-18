package iO;

import combatientes.ejercito.Ejercito;
import combatientes.ejercito.EjercitoAliado;
import combatientes.ejercito.EjercitoEnemigo;
import combatientes.ejercito.EjercitoPropio;
import combatientes.guerrero.*;
import escenario.Camino;
import escenario.Escenario;
import escenario.Pueblo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class CargaDeArchivos {

    /**
     * Parametros utilizados para instanciar el Escenario
     */
    private int cantidadTotalDePueblos;
    private final HashMap<String, Pueblo> mapaDePueblos = new HashMap<>();
    private EjercitoPropio ejercitoPropio = null;
    private String origen;
    private String destino;

    /**
     * Parametros utilizados para verificar si es adecuado instanciar el Escenario
     */
    private boolean cantidadTotalDePueblosAlcanzada = false;
    private boolean ejercitoPropioEstablecido = false;
    private boolean rutaYaEstablecida = false;
    private int contadorDePueblosAgregadosHastaAhora = 0;


    /**
     * cantidadDeLineas: Parametro usado para devolver el numero de linea en caso de excepciones
     */
    private int cantidadDeLineas = 1;

    public CargaDeArchivos() {
    }

    public void instanciarElEscenarioEnRuta(String ruta) {
        cargarArchivo(ruta);
        verificarSiEstaListoParaInstanciar();
        cargarCantidadTotalDePueblosAlEscenario();
        cargarMapaAlEscenario();
        cargarJugadorAlEscenario();
        cargarRutaObjetivoAlEscenario();
    }

    // TODO: 16/6/2021 Implementar un metodo para verificar si la ruta objetivo es ALCANZABLE antes de instanciar

    private void verificarSiEstaListoParaInstanciar() {
        if (!rutaYaEstablecida)
            throw new RuntimeException("El Escenario no se instancio. No se ha establecido la ruta objetivo.");

        if (!cantidadTotalDePueblosAlcanzada)
            throw new RuntimeException("El Escenario no se instancio. No se han agregado pueblos suficientes acorde al total establecido.");

        if (!ejercitoPropioEstablecido) {
            throw new RuntimeException("El Escenario no se instancio. No se ha establecido un pueblo con ejercito propio");
        }
    }


    // METODOS PARA CARGAR DATOS AL ESCENARIO: BEGIN
    private void cargarCantidadTotalDePueblosAlEscenario() {
        Escenario.getInstance().setCantidadDePueblos(this.cantidadTotalDePueblos);
    }

    private void cargarRutaObjetivoAlEscenario() {
        Escenario.getInstance().cargarRuta(this.origen, this.destino);
    }

    private void cargarJugadorAlEscenario() {
        Escenario.getInstance().setJugador(ejercitoPropio);
    }

    private void cargarMapaAlEscenario() {
        Escenario.getInstance().setMapaDePueblos(mapaDePueblos);
    }
    // END

    // TODO: 16/6/2021  SI ES POSIBLE, MODULARIZAR TODO ESTE MASACOTE DE CLASE PARA DELEGAR RESPONSABILIDADES.

    public void cargarArchivo(String pArchivo) {

        FileReader archivo = null;
        BufferedReader lector;

        try {
            archivo = new FileReader(pArchivo);
            lector = new BufferedReader(archivo);
            String linea;

            while ((linea = lector.readLine()) != null) {
                try {
                    decodificarLinea(linea);
                    cantidadDeLineas++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (archivo != null)
                try {
                    archivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void decodificarLinea(String linea) throws Exception {
        String[] trozosDeLinea = linea.trim().split(" ");

        switch (trozosDeLinea.length) {
            case 1:
                cargarValorDeCantidadTotalDePueblos(trozosDeLinea[0]);
                break;

            case 3:
                try {
                    verificarSiSegundoTrozoEsParseableParaCrearCamino(trozosDeLinea[1]);
                    cargarUnCamino(trozosDeLinea);
                } catch (NumberFormatException e) {
                    try {
                        if (!trozosDeLinea[1].equals("->")) {
                            throw new FormatoDeLineaInvalidoException("Ruta objetivo ingresada invalida en la linea: " + cantidadDeLineas);
                        } else {
                            cargarLaRutaObjetivo(trozosDeLinea[0], trozosDeLinea[2]);
                            // TODO: 16/6/2021 Buscar una forma de verificar si la ruta es alcanzable al momento y guardar dicho valor en un atributo.
                        }
                    } catch (FormatoDeLineaInvalidoException fe) {
                        System.err.println("Advertencia. Problema no critico encontrado en linea: " + cantidadDeLineas + ", formato de ruta invalida.");
                        // No hace nada, no afecta el proceso.
                    }
                }
                break;

            case 4:
                agregarUnPuebloAlEscenario(trozosDeLinea);
                verificarSiSeHaAlcanzadoLaCantidadDePueblosEstablecida();
                break;

            default:
                throw new FormatoDeLineaInvalidoException("Formato de linea invalido en linea: " + cantidadDeLineas);
        }
    }

    private void verificarSiSeHaAlcanzadoLaCantidadDePueblosEstablecida() {
        cantidadTotalDePueblosAlcanzada = ++contadorDePueblosAgregadosHastaAhora == cantidadTotalDePueblos;
    }

    // Caso linea de longitud 1
    private void cargarValorDeCantidadTotalDePueblos(String dato) {
        try {
            cantidadTotalDePueblos = verificarValorNumericoPositivo(Integer.parseInt(dato));
        } catch (ValorNoPositivoException e) {
            System.err.println("El numero ingresado deberia ser mayor a 0 y se ingreso:" + dato);
            e.getStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("La cantidad de pueblos debe ser ingresada con un numero entero y se ingreso: " + dato);
            e.getStackTrace();
        }
    }

    // Caso linea de longitud 3
    private void cargarLaRutaObjetivo(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
        this.rutaYaEstablecida = true;
    }

    private void verificarSiSegundoTrozoEsParseableParaCrearCamino(String segmento) {
        Integer.parseInt(segmento);
    }

    // Caso de linea de longitud 3
    private void cargarUnCamino(String[] arregloDeDatos) {
        String origen = arregloDeDatos[0];
        String destino = arregloDeDatos[1];
        int peso = Integer.parseInt(arregloDeDatos[2]);

        agregarCamino(origen, destino, peso);
    }

    private void agregarCamino(String origen, String destino, int peso) {
        if (!mapaDePueblos.containsKey(origen)) {
            mapaDePueblos.put(origen, new Pueblo(origen));
        }
        if (!mapaDePueblos.containsKey(destino)) {
            mapaDePueblos.put(destino, new Pueblo(destino));
        }
        mapaDePueblos.get(origen).agregarCamino(new Camino(mapaDePueblos.get(destino), peso));
    }

    // Caso de linea de longitud 4
    private void agregarUnPuebloAlEscenario(String[] arregloDeDatos) {

        try {
            int numeroDePueblo = verificarValorNumericoPositivo(Integer.parseInt(arregloDeDatos[0]));
            int cantidadDeGuerreros = verificarValorNumericoPositivo(Integer.parseInt(arregloDeDatos[1]));
            Guerrero guerrero = verificarRazaDeGuerreroDelEjercito(arregloDeDatos[2]);
            Ejercito ejercito = verificarElTipoDeEjercito(guerrero, cantidadDeGuerreros, arregloDeDatos[3]);

            if (ejercito instanceof EjercitoPropio) {
                setEjercitoPropio((EjercitoPropio) ejercito);
                this.ejercitoPropioEstablecido = true;
            }
            agregarPueblo(numeroDePueblo, ejercito);

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Se ingreso un valor de numero de pueblo o cantidad de guerreros invalido. No es numerico.");
        } catch (ValorNoPositivoException | FormatoDeLineaInvalidoException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * post: Guarda el valor de ejercitoPropio para pasarlo despues en el respectivo atributo de Escenario
     */
    private void setEjercitoPropio(EjercitoPropio ejercitoPropio) {
        this.ejercitoPropio = ejercitoPropio;
    }

    private void agregarPueblo(int numeroDePueblo, Ejercito ejercito) {
        if (!mapaDePueblos.containsKey(String.valueOf(numeroDePueblo))) {
            mapaDePueblos.put(String.valueOf(numeroDePueblo), new Pueblo(numeroDePueblo, ejercito));
        } else {
            mapaDePueblos.get(String.valueOf(numeroDePueblo)).setEjercito(ejercito);
        }
    }


    private Ejercito verificarElTipoDeEjercito(Guerrero guerrero, int cantidadDeGuerreros, String dato) throws FormatoDeLineaInvalidoException {
        switch (dato.toLowerCase()) {

            case "propio":
                return new EjercitoPropio(guerrero, cantidadDeGuerreros);

            case "aliado":
                return new EjercitoAliado(guerrero, cantidadDeGuerreros);

            case "enemigo":
                return new EjercitoEnemigo(guerrero, cantidadDeGuerreros);

            default:
                throw new FormatoDeLineaInvalidoException("El tipo de Ejercito ingresado: " + dato + " en la linea: " + cantidadDeLineas + "es invalido.");
        }

    }

    private int verificarValorNumericoPositivo(int numero) throws ValorNoPositivoException {
        if (numero <= 0) {
            throw new ValorNoPositivoException();
        }
        return numero;

    }

    private Guerrero verificarRazaDeGuerreroDelEjercito(String dato) throws FormatoDeLineaInvalidoException {
        switch (dato.toLowerCase()) {

            case "wrives":
                return new Wrives();

            case "reralopes":
                return new Reralopes();

            case "radaiteran":
                return new Radaiteran();

            case "nortaichian":
                return new Nortaichian();

            default:
                throw new FormatoDeLineaInvalidoException("El tipo de guerrero: " + dato + " en la linea: " + cantidadDeLineas + "es invalido.");
        }
    }
}
