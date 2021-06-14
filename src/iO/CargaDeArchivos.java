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

	private int cantidadTotalDePueblos;
	private final HashMap<String, Pueblo> mapaDePueblos = new HashMap<>();
	private EjercitoPropio jugador = null;
	private String origen;
	private String destino;

	public CargaDeArchivos(String pArchivo) {
		cargarArchivo(pArchivo);
		cargarDatosAlEscenario();
	}

	public static void main(String[] args) {
		Escenario escenario = Escenario.getInstance();
		CargaDeArchivos io = new CargaDeArchivos("src/archivosIO/datos.txt");
	}

	public void cargarDatosAlEscenario() {
		cargarCantidadTotalDePueblosAlEscenario();
		cargarMapaAlEscenario();
		cargarJugadorAlEscenario();
		cargarRutaObjetivoAlEscenario();
	}

	private void cargarCantidadTotalDePueblosAlEscenario() {
		Escenario.getInstance().setCantidadDePueblos(this.cantidadTotalDePueblos);
	}

	private void cargarRutaObjetivoAlEscenario() {
		Escenario.getInstance().cargarRuta(this.origen, this.destino);
	}

	private void cargarJugadorAlEscenario() {
		Escenario.getInstance().setJugador(jugador);
	}

	private void cargarMapaAlEscenario() {
		Escenario.getInstance().setMapaDePueblos(mapaDePueblos);
	}

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
					if (!trozosDeLinea[1].equals("->")) {
						System.err.println("Este simbolo es invalido:" + trozosDeLinea[1] + ". Si se busca" +
								"señalar el recorrido objetivo de la travesía usar x ej: 'a -> b'.");
					} else {
						cargarLaRutaObjetivo(trozosDeLinea[0], trozosDeLinea[2]);
					}
				}
				break;

			case 4:
				agregarUnPuebloAlEscenario(trozosDeLinea);

			default:
				break;
		}
	}

	// Caso linea de longitud 1
	private void cargarValorDeCantidadTotalDePueblos(String dato) throws Exception {
		try {
			cantidadTotalDePueblos = verificarValorNumericoPositivo(Integer.parseInt(dato));
		} catch (NumberFormatException e) {
			System.err.println("La cantidad de pueblos debe ser ingresada con un numero entero y se ingreso: " + dato);
			e.getStackTrace();
		} catch (RuntimeException e) {
			System.err.println("El numero ingresado deberia ser mayor a 0 y se ingreso:" + dato);
			e.getStackTrace();
		}
	}

	// Caso linea de longitud 3
	private void cargarLaRutaObjetivo(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
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
			int numeroDePueblo = Integer.parseInt(arregloDeDatos[0]);
			int cantidadDeGuerreros = Integer.parseInt(arregloDeDatos[1]);
			Guerrero guerrero = verificarRazaDeGuerreroDelEjercito(arregloDeDatos[2]);
			Ejercito ejercito = verificarElTipoDeEjercito(guerrero, cantidadDeGuerreros, arregloDeDatos[3]);

			if (ejercito instanceof EjercitoPropio) {
				setJugador((EjercitoPropio) ejercito);
			}
			agregarPueblo(numeroDePueblo, ejercito);

		} catch (Exception e) {
			// TODO: crear bien tipo de Excepciones.
			e.getStackTrace();
		}
	}

	private void setJugador(EjercitoPropio jugador) {
		this.jugador = jugador;
	}

	private void agregarPueblo(int numeroDePueblo, Ejercito ejercito) {
		if (!mapaDePueblos.containsKey(String.valueOf(numeroDePueblo))) {
			mapaDePueblos.put(String.valueOf(numeroDePueblo), new Pueblo(numeroDePueblo, ejercito));
		} else {
			mapaDePueblos.get(String.valueOf(numeroDePueblo)).setEjercito(ejercito);
		}
	}


	private Ejercito verificarElTipoDeEjercito(Guerrero guerrero, int cantidadDeGuerreros, String dato) throws Exception {
		switch (dato.toLowerCase()) {

			case "propio":
				return new EjercitoPropio(guerrero, cantidadDeGuerreros);

			case "aliado":
				return new EjercitoAliado(guerrero, cantidadDeGuerreros);

			case "enemigo":
				return new EjercitoEnemigo(guerrero, cantidadDeGuerreros);

			default:
				throw new Exception("El tipo de Ejercito es invalido");
		}

	}

	private int verificarValorNumericoPositivo(int numero) throws Exception {
		if (numero <= 0) {
			throw new Exception();
		}

		return numero;

	}

	private Guerrero verificarRazaDeGuerreroDelEjercito(String dato) throws Exception {
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
				throw new Exception("El tipo de guerrero es invalido");
		}
	}
}
