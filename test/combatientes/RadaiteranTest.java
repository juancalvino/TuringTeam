package combatientes;

import org.junit.Assert;
import org.junit.Test;

import combatientes.Guerrero;
import combatientes.Radaiteran;

public class RadaiteranTest {

	Guerrero radaiteran = new Radaiteran();
	Guerrero enemigo = new GuerreroHack(0, 0);

	// Prueba crear guerrero Radaiteran
	@Test
	public void prueba001() {
		new Radaiteran();
	}

	// Prueba corroborar valores predeterminados del guerrero
	// Salud: 36
	@Test
	public void prueba002() {
		Assert.assertEquals(36, radaiteran.getSalud());
	}

	// Prueba ataque Radaiteran
	// Danio basico: 56
	@Test
	public void prueba003() {
		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(-56, enemigo.getSalud());
	}

	// Prueba de ataques, danio aumenta 3 por cada golpe dado anteriormente
	@Test
	public void prueba004() {
		enemigo = new GuerreroHack(310, 100);

		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(254, enemigo.getSalud());

		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(195, enemigo.getSalud());

		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(133, enemigo.getSalud());

		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(68, enemigo.getSalud());

		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(0, enemigo.getSalud());

	}

	// Descansar no modifica ningun valor
	@Test
	public void prueba005() {
		radaiteran.descansar();
		Assert.assertEquals(36, radaiteran.getSalud());

		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(-56, enemigo.getSalud());
		//prueba

	}
}