package escenario;

import combatientes.ejercito.EjercitoAliado;
import combatientes.ejercito.EjercitoEnemigo;
import combatientes.ejercito.EjercitoPropio;
import combatientes.guerrero.Nortaichian;
import combatientes.guerrero.Reralopes;
import combatientes.guerrero.Wrives;
import iO.CargaDeArchivos;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EscenarioTest {

	Escenario escenario = Escenario.getInstance();
	CargaDeArchivos io = new CargaDeArchivos();

	@Test
	public void deberiaInstanciarUnEscenarioAdecuadamente() {
		EjercitoPropio propio = new EjercitoPropio(new Wrives(), 100);
		EjercitoAliado aliado = new EjercitoAliado(new Reralopes(), 30);
		EjercitoEnemigo enemigo1 = new EjercitoEnemigo(new Nortaichian(), 40);
		EjercitoEnemigo enemigo2 = new EjercitoEnemigo(new Nortaichian(), 60);

		Pueblo pueblo1 = new Pueblo(1, propio);
		Pueblo pueblo2 = new Pueblo(2, aliado);
		Pueblo pueblo3 = new Pueblo(3, enemigo1);
		Pueblo pueblo4 = new Pueblo(4, enemigo2);

		Camino camino1A2 = new Camino(pueblo2, 10);
		pueblo1.agregarCamino(camino1A2);
		Camino camino1A3 = new Camino(pueblo3, 20);
		pueblo1.agregarCamino(camino1A3);
		Camino camino2A3 = new Camino(pueblo3, 5);
		pueblo2.agregarCamino(camino2A3);
		Camino camino3A4 = new Camino(pueblo4, 7);
		pueblo3.agregarCamino(camino3A4);

		HashMap<String, Pueblo> mapaDePueblos = new HashMap<>();
		mapaDePueblos.put("1", pueblo1);
		mapaDePueblos.put("2", pueblo2);
		mapaDePueblos.put("3", pueblo3);
		mapaDePueblos.put("4", pueblo4);

		io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoConsigna.txt");

		assertEquals(4, escenario.getCantidadDePueblos());
		assertEquals(mapaDePueblos, escenario.getMapaDePueblos());
		assertEquals("1", escenario.getOrigen());
		assertEquals("4", escenario.getDestino());
		assertEquals(0, propio.compareTo(escenario.getJugador()));
		assertEquals(0, pueblo2.getEjercito().compareTo(escenario.getMapaDePueblos().get("2").getEjercito()));
		assertEquals(0, pueblo3.getEjercito().compareTo(escenario.getMapaDePueblos().get("3").getEjercito()));
		assertEquals(0, pueblo4.getEjercito().compareTo(escenario.getMapaDePueblos().get("4").getEjercito()));
	}

	@Test
	public void deberiaInstanciarAunqueElArchivoEsteDesordenado() {
		EjercitoPropio propio = new EjercitoPropio(new Nortaichian(), 10);
		EjercitoAliado aliado = new EjercitoAliado(new Reralopes(), 4);
		EjercitoEnemigo enemigo = new EjercitoEnemigo(new Wrives(), 12);

		Pueblo pueblo1 = new Pueblo(1, propio);
		Pueblo pueblo2 = new Pueblo(2, aliado);
		Pueblo pueblo3 = new Pueblo(3, enemigo);

		Camino camino1A2 = new Camino(pueblo2, 3);
		pueblo1.agregarCamino(camino1A2);
		Camino camino1A3 = new Camino(pueblo3, 10);
		pueblo1.agregarCamino(camino1A3);
		Camino camino2A3 = new Camino(pueblo3, 5);
		pueblo2.agregarCamino(camino2A3);

		HashMap<String, Pueblo> mapaDePueblos = new HashMap<>();
		mapaDePueblos.put("1", pueblo1);
		mapaDePueblos.put("2", pueblo2);
		mapaDePueblos.put("3", pueblo3);

		io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoLineasDesordenadas.txt");

		assertEquals(mapaDePueblos, escenario.getMapaDePueblos());
		assertEquals("1", escenario.getOrigen());
		assertEquals("3", escenario.getDestino());
		assertEquals(0, propio.compareTo(escenario.getJugador()));
		assertEquals(0, pueblo2.getEjercito().compareTo(escenario.getMapaDePueblos().get("2").getEjercito()));
		assertEquals(0, pueblo3.getEjercito().compareTo(escenario.getMapaDePueblos().get("3").getEjercito()));
	}

	@Test(expected = RuntimeException.class)
	public void noDeberiaInstanciarEscenarioSinRutaObjetivo() {
		System.out.println("PRUEBA EXPECTED");
		io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoRutaObjetivoFaltante.txt");
	}

	@Test(expected = RuntimeException.class)
	public void noDeberiaInstanciarPorqueFaltanPueblos() {
		System.out.println("PRUEBA EXPECTED");
		io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoPueblosFaltantes.txt");
	}

	@Test(expected = RuntimeException.class)
	public void noDeberiaInstanciarUnEscenarioSinEjercitoPropio() {
		System.out.println("PRUEBA EXPECTED");
		io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoEjercitoPropioFaltante.txt");
	}

	@Test
	public void deberiaInstanciarCorrectamenteYAvisarDeUnaLineaInvalidaQueNoAfecta() {
		io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoCorrectoPeroUnaRutaInvalidaDeMas.txt");
		assertTrue(elEscenarioFueInstanciadoAdecuadamente());
	}

	private boolean elEscenarioFueInstanciadoAdecuadamente() {
		return escenario.getMapaDePueblos() != null && escenario.getCantidadDePueblos() != 0
				&& escenario.getOrigen() != null && escenario.getDestino() != null && escenario.getJugador() != null;
	}
}
