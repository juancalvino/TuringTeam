package guerreros;

import org.junit.Assert;
import org.junit.Test;

public class WrivesTest {

	Guerrero wrives = new Wrives();
	Guerrero enemigo = new GuerreroHack(0, 0);

	// Crear un guerrero Wrives

	@Test
	public void prueba001() {
		new Wrives();
	}

	/*
	 * Verificar valores nominales Salud Inicial = 108 Danio Basico = 113
	 */
	@Test
	public void prueba002() {
		Assert.assertEquals(108, wrives.getSalud());

		wrives.atacar(enemigo);
		Assert.assertEquals(-113, enemigo.getSalud());
	}

	/*
	 * Verificar forma de ataque Hace 2 veces su danio cada 2 turnos
	 */
	@Test
	public void prueba003() {
		enemigo = new GuerreroHack(113 * 6, 100);

		wrives.atacar(enemigo);
		Assert.assertEquals(113 * 5, enemigo.getSalud());

		wrives.atacar(enemigo);
		Assert.assertEquals(113 * 3, enemigo.getSalud());

		wrives.atacar(enemigo);
		Assert.assertEquals(113 * 2, enemigo.getSalud());

		wrives.atacar(enemigo);
		Assert.assertEquals(0, enemigo.getSalud());

	}

	/*
	 * Verificar recibir ataque Recibir el ataque por 2
	 */
	@Test
	public void prueba004() {
		enemigo = new GuerreroHack(100, 4);
		enemigo.atacar(wrives);
		Assert.assertEquals(100, wrives.getSalud());
	}

	/*
	 * Verificar descansar
	 */
	@Test
	public void prueba005() {
		enemigo = new GuerreroHack(113, 4);

		Assert.assertEquals(108, wrives.getSalud());

		// wrives incrementa su salud en 50 al descansar y se pone en 'modo pacifista'
		wrives.descansar();
		Assert.assertEquals(158, wrives.getSalud());

		// wrives no le quita vida al enemigo porque esta en 'modo pacifista'
		wrives.atacar(enemigo);
		Assert.assertEquals(113, enemigo.getSalud());

		// wrives recibe un ataque doble y se pone activo para atacar
		enemigo.atacar(wrives);
		Assert.assertEquals(150, wrives.getSalud());

		// wrives ataca al enemigo
		wrives.atacar(enemigo);
		Assert.assertEquals(0, enemigo.getSalud());
	}
}
