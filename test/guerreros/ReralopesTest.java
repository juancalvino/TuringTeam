package guerreros;

import org.junit.Test;

import org.junit.Assert;

public class ReralopesTest {

	Guerrero reralopes = new Reralopes();
	Guerrero enemigo = new GuerreroTest(0, 0);

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
		reralopes.atacar(enemigo);
		Assert.assertEquals(-27, enemigo.getSalud());
	}

	// Se verifica que unaReralopes erra 2 de 4 ataques
	@Test
	public void prueba003() {
		enemigo = new GuerreroTest(27 * 3, 100);

		reralopes.atacar(enemigo);
		Assert.assertEquals(27 * 2, enemigo.getSalud());

		reralopes.atacar(enemigo);
		Assert.assertEquals(27, enemigo.getSalud());

		reralopes.atacar(enemigo);
		Assert.assertEquals(27, enemigo.getSalud());

		reralopes.atacar(enemigo);
		Assert.assertEquals(27, enemigo.getSalud());

		reralopes.atacar(enemigo);
		Assert.assertEquals(0, enemigo.getSalud());

	}

	// Se verifica que al descansar, sus siguientes 3 ataques son criticos
	@Test
	public void prueba004() {
		enemigo = new GuerreroTest(135, 100);

		reralopes.descansar();

		reralopes.atacar(enemigo);
		Assert.assertEquals(81, enemigo.getSalud());

		reralopes.atacar(enemigo);
		Assert.assertEquals(27, enemigo.getSalud());

		// El tercer ataque es errado pero de todas formas consume un ataque critico
		reralopes.atacar(enemigo);
		Assert.assertEquals(27, enemigo.getSalud());

		reralopes.atacar(enemigo);
		Assert.assertEquals(27, enemigo.getSalud());

		reralopes.atacar(enemigo);
		Assert.assertEquals(0, enemigo.getSalud());
	}

	// Se verifica que un ataque a otra unidad ha sido satisfactoria
	@Test
	public void prueba005() {
		enemigo = new Reralopes();
		reralopes.atacar(enemigo);
		Assert.assertEquals(26, enemigo.getSalud());
	}

	// Se verifica que unaReralopes se desconcentra luego de recibir un ataque (es
	// decir, pierde su efecto descansado)
	@Test
	public void prueba006() {
		enemigo = new GuerreroTest(81, 10);

		reralopes.descansar();
		reralopes.atacar(enemigo);

		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.atacar(reralopes);
		reralopes.atacar(enemigo);
		Assert.assertEquals(0, enemigo.getSalud());
	}
}
