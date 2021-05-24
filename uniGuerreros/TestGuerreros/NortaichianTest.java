package TestGuerreros;

import org.junit.Assert;
import org.junit.Test;
import Guerreros.*;

public class NortaichianTest {

	private Guerrero nortaichian = new Nortaichian();
	private Guerrero random = new GuerreroRandom(100,10);

	@Test
	public void prueba001() {
		Nortaichian prueba = new Nortaichian();

		Assert.assertNotNull(prueba);
	}

	/*
	 * la salud inicial de 'nortaichian' es de 66
	 */
	@Test
	public void prueba002() {
		Assert.assertEquals(66, nortaichian.getSalud());
	}

	/*
	 * se comprueba que hace 18 de da�o b�sico en su ataque
	 */
	@Test
	public void prueba003() {
		nortaichian.atacar(random); // recibe ataque de manera estandar
		// la salud inicial de un 'Random' es igual a 100
		Assert.assertEquals(82, random.getSalud());
	}

	/*
	 * 'nortaichian' cada vez que ataca se cura un 4% de su salud
	 */
	@Test
	public void prueba004() {
		nortaichian.atacar(random);
		Assert.assertEquals(68, nortaichian.getSalud());
	}

	/*
	 * 'nortaichian' ataca 3 veces, su salud incrementa un 12%
	 */
	@Test
	public void prueba005() {
		nortaichian.atacar(random);
		nortaichian.atacar(random);
		nortaichian.atacar(random);
		Assert.assertEquals(72, nortaichian.getSalud());
	}

	/*
	 * 'nortaichian' recibe un ataque de 10 y su vida queda en 56
	 */
	@Test
	public void prueba006() {
		random.atacar(nortaichian);
		Assert.assertEquals(56, nortaichian.getSalud());
	}

	/*
	 * 'nortaichian' ataca primero y cuando es atacado duplica su danio de ataque
	 */
	@Test
	public void prueba007() {
		// primer ataque inflige 18 de danio
		nortaichian.atacar(random);

		random.atacar(nortaichian);

		// segundo ataque inflige 36 de danio y recupera 4% de su salud
		nortaichian.atacar(random);

		Assert.assertEquals(46, random.getSalud());
		Assert.assertEquals(60, nortaichian.getSalud());
	}

	/*
	 * 'nortaichian' es atacado y duplica el danio de su ataque durante 2 turnos
	 */
	@Test
	public void prueba008() {
		random.atacar(nortaichian);

		nortaichian.atacar(random);
		nortaichian.atacar(random);
		nortaichian.atacar(random);// ultimo ataque vale 18

		Assert.assertEquals(10, random.getSalud());
	}

	/*
	 * 'nortaichian' recibe ataques pero luego descansa y recupera toda su salud.
	 */
	@Test
	public void prueba009() {
		nortaichian.recibirAtaque(20);
		nortaichian.recibirAtaque(20);

		Assert.assertEquals(26, nortaichian.getSalud());
		nortaichian.descansar();
		Assert.assertEquals(66, nortaichian.getSalud());
	}

	/*
	 * 'nortaichian' descansa y durante 2 turnos no puede
	 * atacar pero se reduce el danio recibido a la mitad
	 */
	@Test
	public void prueba010() {
		nortaichian.descansar();
		
		nortaichian.atacar(random);
		Assert.assertEquals(100, random.getSalud());
		
		random.atacar(nortaichian);
		Assert.assertEquals(61, nortaichian.getSalud());
		
		nortaichian.atacar(random);
		Assert.assertEquals(100, random.getSalud());
		
		random.atacar(nortaichian);
		Assert.assertEquals(51, nortaichian.getSalud());

		nortaichian.atacar(random);
		Assert.assertEquals(64, random.getSalud());
		
		random.atacar(nortaichian);
		Assert.assertEquals(43, nortaichian.getSalud());
		

	}
}
