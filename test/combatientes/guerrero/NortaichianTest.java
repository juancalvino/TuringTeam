package combatientes.guerrero;

import org.junit.Assert;
import org.junit.Test;

public class NortaichianTest {
	Guerrero nortaichian = new Nortaichian();
	Guerrero enemigo = new GuerreroHack(0, 0);

	// Se crea una nueva instancia de Nortaichian
	@Test
	public void prueba001() {
		new Nortaichian();
	}

	// Se verifica que los valores inicializados de la instancia coincidan con los
	// senialados por la consigna
	// Salud: 66
	@Test
	public void prueba002() {
		Assert.assertEquals(66, nortaichian.getSalud());
		
		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(-18, enemigo.getSalud());
	}

	// Danio Basico: 18
	@Test
	public void prueba003() {
		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(-18, enemigo.getSalud());
	}

	/*
	 * 'unNortaichian' cada vez que ataca se cura un 4% de su salud
	 */
	@Test
	public void prueba004() {
		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(68, nortaichian.getSalud());
	}

	/*
	 * 'unNortaichian' ataca a 'otroNortaichian', 'otroNortaichian' ataca enfurecido
	 * (x2)
	 */
	@Test
	public void prueba005() {
		enemigo = new Nortaichian();

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(48, enemigo.getSalud());

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(32, nortaichian.getSalud());
		Assert.assertEquals(49, enemigo.getSalud());
	}

	/*
	 * 'unNortaichian' recibe danio, pero luego descansa y recupera toda su salud.
	 */
	@Test
	public void prueba006() {
		enemigo = new GuerreroHack(100, 65);

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(1, nortaichian.getSalud());

		nortaichian.descansar();
		Assert.assertEquals(66, nortaichian.getSalud());
	}

	/*
	 * 'unNortaichian' descansa y durante 2 turnos no puede atacar (infligen 0
	 * danio) a 'otroNortaichian', pero se reduce el danio recibido a la mitad
	 */
	@Test
	public void prueba007() {
		enemigo = new GuerreroHack(56, 20);

		nortaichian.descansar();

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(56, enemigo.getSalud());

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(56, nortaichian.getSalud());

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(56, enemigo.getSalud());

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(36, nortaichian.getSalud());

		enemigo.recibirAtaque(nortaichian.atacar());
		Assert.assertEquals(20, enemigo.getSalud());

		nortaichian.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(17, nortaichian.getSalud());
	}

}
