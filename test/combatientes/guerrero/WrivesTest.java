package combatientes.guerrero;

import org.junit.Assert;
import org.junit.Test;

public class WrivesTest {

	Guerrero wrive = new Wrives();
	Guerrero enemigo = new GuerreroHack(0, 0);

	@Test
	public void seCreaUnaInstanciaDeWrives() {
		new Wrives();
	}

	@Test
	public void seVerificaLaSaludInicialDelWrive() {
		Assert.assertEquals(108, wrive.getSalud());
	}
	
	@Test
	public void seVerificaElDanioBasicoDelWrive() {
		enemigo = new GuerreroHack(116, 100);
		enemigo.recibirAtaque(wrive.atacar());
		Assert.assertEquals(3, enemigo.getSalud());
	}

	@Test
	public void hace2VecesSuDanioCada2Ataques() {
		enemigo = new GuerreroHack(678, 100);

		enemigo.recibirAtaque(wrive.atacar());
		Assert.assertEquals(565, enemigo.getSalud());

		enemigo.recibirAtaque(wrive.atacar());
		Assert.assertEquals(339, enemigo.getSalud());

		enemigo.recibirAtaque(wrive.atacar());
		Assert.assertEquals(226, enemigo.getSalud());

		enemigo.recibirAtaque(wrive.atacar());
		Assert.assertEquals(0, enemigo.getSalud());

	}

	@Test
	public void alRecibirUnAtaqueLoHace2VecesElDanio() {
		enemigo = new GuerreroHack(100, 4);
		wrive.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(100, wrive.getSalud());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void alRecibirUnAtaqueNegativoLanzaExcepcion() {
		wrive.recibirAtaque(-50);
	}
	
	@Test
	public void alDescansarAumentaSuSaludEn50() {
		enemigo = new GuerreroHack(113, 4);

		Assert.assertEquals(108, wrive.getSalud());

		wrive.descansar();
		Assert.assertEquals(158, wrive.getSalud());
	}
	
	@Test
	public void alDescansarNoAtacaHastaQueLoAtaquen() {
		enemigo = new GuerreroHack(113, 4);
		
		wrive.descansar();
		Assert.assertEquals(158, wrive.getSalud());

		// wrives no le quita vida al enemigo porque esta en 'modo pacifista'
		enemigo.recibirAtaque(wrive.atacar());
		Assert.assertEquals(113, enemigo.getSalud());

		// wrives recibe un ataque y se pone activo para atacar
		wrive.recibirAtaque(enemigo.atacar());
		Assert.assertEquals(150, wrive.getSalud());

		// wrives ataca al enemigo
		enemigo.recibirAtaque(wrive.atacar());
		Assert.assertEquals(0, enemigo.getSalud());
	}
}
