package combatientes.guerrero;

import org.junit.Test;
import org.junit.Assert;

public class ReralopesTest {

	Guerrero reralope = new Reralopes();
	Guerrero enemigo = new GuerreroHack(0, 0);

	@Test
	public void seCreaUnaInstanciaDeReralopes() {
		new Reralopes();
	}
	
	@Test
	public void seVerificaLaSaludInicialDelReralope() {
		Assert.assertEquals(53, reralope.getSalud());
	}
	
	@Test
	public void seVerificaElDanioBasicoDelReralope() {
		enemigo = new GuerreroHack(127, 100);
		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(100, enemigo.getSalud());
	}

	@Test
	public void alAtacarErra2deCada4Ataques() {
		enemigo = new GuerreroHack(81, 100);

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(54, enemigo.getSalud());

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(0, enemigo.getSalud());
	}

	@Test
	public void alDescansarAtacaElDoblePor3turnosPropios() {
		enemigo = new GuerreroHack(135, 100);

		reralope.descansar();

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(81, enemigo.getSalud());

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		// El tercer ataque es errado pero de todas formas consume un ataque critico
		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(0, enemigo.getSalud());
	}
	
	// un Reralopes se desconcentra luego de recibir un ataque (es
	// decir, pierde su efecto descansado de inflijir tres golpes criticos (x2))
	@Test
	public void seDesconcentraAlSerAtacado() {
		enemigo = new GuerreroHack(135, 10);
		reralope.descansar();
		
		enemigo.recibirAtaque(reralope.atacar());
		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());

		reralope.recibirAtaque(enemigo.atacar());
		enemigo.recibirAtaque(reralope.atacar());
		Assert.assertEquals(27, enemigo.getSalud());
	}

	@Test(expected = IllegalArgumentException.class)
	public void alRecibirUnAtaqueNegativoLanzaExcepcion() {
		reralope.recibirAtaque(-50);
	}
}
