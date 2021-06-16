package combatientes.guerrero;

import org.junit.Assert;
import org.junit.Test;

public class RadaiteranTest {

	Guerrero radaiteran = new Radaiteran();
	Guerrero enemigo = new GuerreroHack(0, 0);

	@Test
	public void seCreaUnaInstanciaDeRadaiteran() {
		new Radaiteran();
	}

	@Test
	public void seVerificaLaSaludInicialDelRadaiteran() {
		Assert.assertEquals(36, radaiteran.getSalud());
	}

	@Test
	public void seVerificaElDanioBasicoDelRadaiteran() {
		enemigo = new GuerreroHack(58, 100);
		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(2, enemigo.getSalud());
	}

	@Test
	public void aumenta3deDanioPorCadaAtaqueRealizado() {
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
	
	@Test
	public void alRecibirAtaquesLoHaceNormalmente() {
		enemigo = new GuerreroHack(200, 5);
		
		radaiteran.recibirAtaque(enemigo.atacar());
		radaiteran.recibirAtaque(enemigo.atacar());
		radaiteran.recibirAtaque(enemigo.atacar());
		radaiteran.recibirAtaque(enemigo.atacar());
		
		Assert.assertEquals(16, radaiteran.getSalud());
	}

	@Test
	public void descansarNoAfectaAlGuerrero() {
		enemigo = new GuerreroHack(58, 10);
		radaiteran.recibirAtaque(enemigo.atacar());
		
		radaiteran.descansar();
		Assert.assertEquals(26, radaiteran.getSalud());

		enemigo.recibirAtaque(radaiteran.atacar());
		Assert.assertEquals(2, enemigo.getSalud());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void alRecibirUnAtaqueNegativoLanzaExcepcion() {
		radaiteran.recibirAtaque(-50);
	}
}