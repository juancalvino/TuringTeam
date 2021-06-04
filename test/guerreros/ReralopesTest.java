package guerreros;

import org.junit.Test;

import org.junit.Assert;

public class ReralopesTest {

	Guerrero reralopes = new Reralopes();
	Guerrero enemigo = new GuerreroHack(0, 0);

	// Se crea una nueva instancia de Reralopes
	@Test
	public void prueba001() {
		new Reralopes();
	}

	// Verificar que los valores básicos (salud, danio) de una Reralopes coinciden
	// con los indicados por la consigna
	// Salud: 53, Danio basico: 27
	@Test
	public void prueba002() {
		Assert.assertEquals(53, reralopes.getSalud());
		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(-27, enemigo.getSalud());
	}

	// Se verifica que unaReralopes erra 2 de 4 ataques
	@Test
	public void prueba003() {
		enemigo = new GuerreroHack(27 * 3, 100);

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(27 * 2, enemigo.getSalud());

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(0, enemigo.getSalud());

	}

	// Se verifica que al descansar, sus siguientes 3 ataques son criticos
	@Test
	public void prueba004() {
		enemigo = new GuerreroHack(135, 100);

		reralopes.descansar();

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(81, enemigo.getSalud());

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		// El tercer ataque es errado pero de todas formas consume un ataque critico
		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(0, enemigo.getSalud());
	}

	// Se verifica que un ataque a otra unidad ha sido satisfactoria
	@Test
	public void prueba005() {
		enemigo = new Reralopes();
		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(26, enemigo.getSalud());
	}

	// Se verifica que unaReralopes se desconcentra luego de recibir un ataque (es
	// decir, pierde su efecto descansado)
	@Test
	public void prueba006() {
		enemigo = new GuerreroHack(81, 10);

		enemigo.recibirAtaque(reralopes.atacar());
		enemigo.recibirAtaque(reralopes.atacar());

		Assert.assertEquals(27, enemigo.getSalud());

		reralopes.recibirAtaque(enemigo.atacar());
		enemigo.recibirAtaque(reralopes.atacar());
		Assert.assertEquals(0, enemigo.getSalud());
	}
}
