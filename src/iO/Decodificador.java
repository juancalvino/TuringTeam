package iO;

import combatientes.ejercito.Ejercito;
import combatientes.ejercito.EjercitoAliado;
import combatientes.ejercito.EjercitoEnemigo;
import combatientes.ejercito.EjercitoJugador;
import combatientes.guerrero.Guerrero;
import combatientes.guerrero.Nortaichian;
import combatientes.guerrero.Radaiteran;
import combatientes.guerrero.Reralopes;
import combatientes.guerrero.Wrives;
import escenario.Escenario;
import escenario.Pueblo;

public class Decodificador {

	public void argregarInformacionDeLaLinea(String linea) {

	}

	public void decodificarLinea(String linea) throws Exception {
		String[] arregloDeDatos = linea.trim().split(" ");

		switch (arregloDeDatos.length) {
		case 1:
			cargarCantidadDePueblos(arregloDeDatos[0]);
			break;

		case 3:
			try {
				cargarCamino(arregloDeDatos);
			} catch (NumberFormatException e) {
				if (!e.equals("->")) {
					System.err.println("Este simbolo es invalido:" + e);
				} else {
					cargarRuta(arregloDeDatos[0], arregloDeDatos[2]);
				}
			}

			break;

		case 4:
			agregarUnPuebloAlEscenario(arregloDeDatos);

		default:
			break;
		}
	}

	private void cargarCamino(String[] arregloDeDatos) {
		String origen = arregloDeDatos[0];
		String destino = arregloDeDatos[1];
		int peso = Integer.parseInt(arregloDeDatos[2]);

		//TODO seguir arreglando esta clase y metodos, jajaja
		//TODO agregar el camino;
	}

	private void cargarRuta(String origen, String destino) {
		Escenario.getInstance().cargarRuta(origen, destino);
	}

	private void agregarUnPuebloAlEscenario(String[] arregloDeDatos) {

		try {
			int numeroDePueblo = Integer.parseInt(arregloDeDatos[0]);
			int cantidadDeGuerreros = Integer.parseInt(arregloDeDatos[1]);
			Guerrero guerrero = verificarGuerrero(arregloDeDatos[2]);
			Ejercito ejercito = verificarEjercito(guerrero, cantidadDeGuerreros, arregloDeDatos[3]);

			if (ejercito instanceof EjercitoJugador) {
				Escenario.getInstance().setJugador((EjercitoJugador) ejercito);
			}
			Escenario.getInstance().agregarPueblo(new Pueblo(numeroDePueblo, ejercito));

		} catch (Exception e) {
			// TODO: crear bien tipo de Excepciones.
			e.getStackTrace();
		}
	}

	private void cargarCantidadDePueblos(String dato) throws Exception {

		try {
			int cantidadDePueblos = verificarPositividad(Integer.parseInt(dato));
			Escenario.getInstance().setCantidadDePueblos(cantidadDePueblos);
		} catch (NumberFormatException e) {
			System.err.println("La cantidad de pueblos debe ser ingresada con un numero entero y se ingreso: " + dato);
			e.getStackTrace();
		} catch (RuntimeException e) {
			System.err.println("El numero ingresado deberia ser mayor a 0 y se ingreso:" + dato);
			e.getStackTrace();
		}
	}

	private Ejercito verificarEjercito(Guerrero guerrero, int cantidadDeGuerreros, String dato) throws Exception {
		switch (dato.toLowerCase()) {

		case "propio":
			return new EjercitoJugador(guerrero, cantidadDeGuerreros);

		case "aliado":
			return new EjercitoAliado(guerrero, cantidadDeGuerreros);

		case "enemigo":
			return new EjercitoEnemigo(guerrero, cantidadDeGuerreros);

		default:
			throw new Exception("El tipo de Ejercito es invalido");
		}

	}

	private int verificarPositividad(int numero) throws Exception {
		if (numero <= 0) {
			throw new Exception();
		}

		return numero;

	}

	private Guerrero verificarGuerrero(String dato) throws Exception {
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
