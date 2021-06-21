package combatientes.guerrero;

import org.junit.Assert;
import org.junit.Test;

public class NortaichianTest {
	Guerrero nortaichian = new Nortaichian();
	Guerrero enemigo = new GuerreroHack(0, 0);

	@Test
	public void seCreaUnaInstanciaDeNortaichian() {
		new Nortaichian();
	}

	@Test
	public void seVerificaLaSaludInicialDelNortaichian() {
		Assert.assertEquals(66, nortaichian.getSalud());
	}

	@Test
	public void seVerificaElDanioBasicoDelNortaichian() {
		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(-18, enemigo.getSalud());
	}

	@Test
	public void unNortaichianSeCura4porcientoPorCadaAtaque() {
		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(68, nortaichian.getSalud());
	}

	// Al recibir un ataque se enfurece y sus ataques multiplican por 2 su daño
	// (dura 2 turnos propios).
	@Test
	public void unNortaichianAlRecibirAtaqueSeEnfurece() {
		enemigo = new GuerreroHack(208, 10);

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(190, enemigo.getSalud()); // Nortaichian ataca danio basico

		nortaichian.recibirAtaque(enemigo.atacar()); // Nortaichian recibe el ataque y se enfurece

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(154, enemigo.getSalud()); // Nortaichian ataca el doble de su danio basico

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(118, enemigo.getSalud()); // Nortaichian ataca el doble de su danio basico

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(100, enemigo.getSalud()); // Nortaichian ataca danio basico
	}

	@Test(expected = IllegalArgumentException.class)
	public void alRecibirUnAtaqueNegativoLanzaExcepcion() {
		nortaichian.recibirAtaque(-50);
	}

	@Test
	public void alDescansarRecuperaTodaSuSalud() {
		enemigo = new GuerreroHack(100, 65);

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(1, nortaichian.getSalud());

		nortaichian.descansar();
		Assert.assertEquals(66, nortaichian.getSalud());
	}

	@Test
	public void luegoDeDescansarNoPuedeAtacarPorDosTurnos() {
		enemigo = new GuerreroHack(56, 20);

		nortaichian.descansar();

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(56, enemigo.getSalud());

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(56, enemigo.getSalud());

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(38, enemigo.getSalud());
	}

	@Test
	public void cuandoDescansaRecibeLaMitadDelDanioPorDosTurnos() {
		enemigo = new GuerreroHack(56, 20);

		nortaichian.descansar();

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(56, nortaichian.getSalud());

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(46, nortaichian.getSalud());

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(26, nortaichian.getSalud());
	}
}
