package TestGuerreros;

import org.junit.Assert;

import org.junit.Test;

import Guerreros.*;

public class RadaiteranTest {

	// Prueba crear guerrero Radaiteran
	@Test
	public void prueba000() {
		new Radaiteran();
	}

	// Prueba corroborar valores predeterminados del guerrero
	@Test
	public void prueba001() {
		Radaiteran gRadaiteran = new Radaiteran();
		Assert.assertEquals(36, gRadaiteran.getSalud());
		Assert.assertEquals(56, gRadaiteran.atacar());
	}

	// Prueba ataque Radaiteran
	@Test
	public void prueba002() {
		Radaiteran gRadaiteran = new Radaiteran();
		GuerreroRandom guerrero = new GuerreroRandom(200, 20);
		gRadaiteran.atacar(guerrero);
		Assert.assertEquals(144, guerrero.getSalud());
	}

	// Prueba ataque doble Radaiteran
	@Test
	public void prueba003() {
		Radaiteran gRadaiteran = new Radaiteran();
		GuerreroRandom guerrero = new GuerreroRandom(200, 20);
		gRadaiteran.atacar(guerrero);
		gRadaiteran.atacar(guerrero);
		Assert.assertEquals(85, guerrero.getSalud());
	}

	// Prueba ataque quintuple Radaiteran
	@Test
	public void prueba004() {
		Radaiteran gRadaiteran = new Radaiteran();
		GuerreroRandom guerrero = new GuerreroRandom(500, 20);
		gRadaiteran.atacar(guerrero);
		gRadaiteran.atacar(guerrero);
		gRadaiteran.atacar(guerrero);
		gRadaiteran.atacar(guerrero);
		gRadaiteran.atacar(guerrero);
		Assert.assertEquals(190, guerrero.getSalud());
	}

	// Prueba recibir ataque
	@Test
	public void prueba005() {
		Radaiteran gRadaiteran = new Radaiteran();
		GuerreroRandom guerrero = new GuerreroRandom(100, 20);
		guerrero.atacar(gRadaiteran);
		Assert.assertEquals(16, gRadaiteran.getSalud());
	}

	// Prueba recibir ataque triple
	@Test
	public void prueba006() {
		Radaiteran gRadaiteran = new Radaiteran();
		GuerreroRandom guerrero = new GuerreroRandom(100, 5);
		guerrero.atacar(gRadaiteran);
		guerrero.atacar(gRadaiteran);
		guerrero.atacar(gRadaiteran);
		Assert.assertEquals(21, gRadaiteran.getSalud());
	}

	// Prueba descansar
	@Test
	public void prueba007() {
		Radaiteran gRadaiteran = new Radaiteran();
		gRadaiteran.descansar();
	}

}
