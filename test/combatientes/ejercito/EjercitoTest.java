package combatientes.ejercito;


import org.junit.Assert;
import org.junit.Test;

import combatientes.guerrero.GuerreroHack;
import combatientes.guerrero.Nortaichian;
import combatientes.guerrero.Reralopes;
import combatientes.guerrero.Wrives;
import escenario.Batalla;

public class EjercitoTest {

	
	@Test
	public void iniciarEjercitoPropioCon100WrivesYDesmayarAUnGuerrero(){
		
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);
	
		Assert.assertEquals(jugador.getSalud(),108);
		jugador.recibirAtaque(100);

		Assert.assertEquals(jugador.cantidadDeGuerreros(), 99);

		Assert.assertEquals(jugador.getSalud(),108);
	}
	
	@Test
	public void agregarANuestroEjercitoAliadosDe100Reralopes() {
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);

		jugador.agregarEjercito(new EjercitoAliado(new Reralopes(), 100));
		Assert.assertEquals(jugador.cantidadDeGuerreros(), 200);
		
	}
	
	@Test
	public void desmayar100GuerrerosReralopesAliadosDeNuestroEjercito() {
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);

		jugador.agregarEjercito(new EjercitoAliado(new Reralopes(), 100));
		Assert.assertEquals(jugador.cantidadDeGuerreros(), 200);
		
		Assert.assertEquals(jugador.atacar(), 27);
		
		for(int i =0; i<100; i++) {
			jugador.recibirAtaque(57);
		}
		
		Assert.assertEquals(jugador.cantidadDeGuerreros(),100 );
		
		jugador.recibirAtaque(57);
	
		Assert.assertEquals(jugador.cantidadDeGuerreros(),99 );

		Assert.assertEquals(jugador.getSalud(), 108 );

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void crearEjercitoConCantidadNegativaLanzaExcepcion() {
		new EjercitoJugador(new Wrives(), -10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recibirAtaqueNegativoLanzaExcepcion() {
		new EjercitoJugador(new Wrives(), 10).recibirAtaque(-50);
	}
	
	
	@Test
	public void descansarEjercitoDeNortaichian() {
		// Cuando descansa, recupera toda su salud
		
		EjercitoJugador jugador = new EjercitoJugador(new Nortaichian(), 2);
		EjercitoEnemigo enemigo = new EjercitoEnemigo(new GuerreroHack(20, 20), 1);
		
		Batalla batallar = new Batalla();
		Assert.assertEquals(batallar.obtenerSobreviviente(jugador, enemigo), jugador);
		
		Assert.assertEquals(jugador.getSalud(), 66);
		
		EjercitoEnemigo otroEnemigo = new EjercitoEnemigo(new GuerreroHack(40, 67), 1);
		Assert.assertEquals(batallar.obtenerSobreviviente(jugador, otroEnemigo), jugador);
		
		Assert.assertEquals(jugador.cantidadDeGuerreros(), 2);
		Assert.assertEquals(jugador.getSalud(), 49);
		
		jugador.descansar();
		Assert.assertEquals(jugador.getSalud(), 66);
	}

	@Test
	public void descansarEjercitoWrives() {
		// Cuando descansa aumenta su salud y su salud m�xima en 50.

		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 2);
		EjercitoEnemigo enemigo = new EjercitoEnemigo(new GuerreroHack(300, 50), 1);

		Batalla batallar = new Batalla();
		Assert.assertEquals(batallar.obtenerSobreviviente(jugador, enemigo), jugador);
		
		Assert.assertEquals(jugador.getSalud(), 108);
		
		jugador.descansar();
		Assert.assertEquals(jugador.getSalud(), 158);
	}
	
	@Test
	public void descansarEjercitoReralopes() {
		//Cuando descansa, se concentra y sus pr�ximos 3 ataques (de esa unidad) da�an el doble del valor correspondiente
		
		EjercitoJugador jugador = new EjercitoJugador(new Reralopes(), 2);
		EjercitoEnemigo enemigo = new EjercitoEnemigo(new GuerreroHack(200, 30), 1);
		
		enemigo.recibirAtaque(jugador.atacar());
		enemigo.recibirAtaque(jugador.atacar());
		Assert.assertEquals(enemigo.getSalud(), 146);
		
		//ataques errados
		enemigo.recibirAtaque(jugador.atacar()); enemigo.recibirAtaque(jugador.atacar());
		
		jugador.descansar();		
		
		enemigo.recibirAtaque(jugador.atacar());
		enemigo.recibirAtaque(jugador.atacar());
		enemigo.recibirAtaque(jugador.atacar());
		Assert.assertEquals(enemigo.getSalud(), 38);	
	}
	
}
