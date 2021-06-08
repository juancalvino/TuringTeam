package combatientes;


import org.junit.Assert;
import org.junit.Test;

public class EjercitoTest {

	
	@Test
	public void iniciarEjercitoPropioConWrives() throws CreateInstanceEjercitoPropioException, NegativeNumberException{
		
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);
	
		Assert.assertEquals(jugador.getSalud(),108);
		jugador.recibirAtaque(100);

		Assert.assertEquals(jugador.cantidadDeGuerreros(), 99);

		Assert.assertEquals(jugador.getSalud(),108);

		jugador.recibirAtaque(100);
		Assert.assertEquals(jugador.cantidadDeGuerreros(), 98);
	
	}
	
	@Test
	public void agregarANuestroEjercitoAliadosDe100Reralopes() throws CreateInstanceEjercitoPropioException, NegativeNumberException{
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);
		
		Assert.assertEquals(jugador.getSalud(),108);
		jugador.recibirAtaque(100);

		jugador.agregarEjercito(new EjercitoAliado(new Reralopes(), 100));
		Assert.assertEquals(jugador.cantidadDeGuerreros(), 199);
		
		Assert.assertEquals(jugador.atacar(), 27);
		
		for(int i =0; i<99; i++) {
			jugador.recibirAtaque(57);
		}
		
		Assert.assertEquals(jugador.cantidadDeGuerreros(),100 );
		
		jugador.recibirAtaque(57);
	
		Assert.assertEquals(jugador.cantidadDeGuerreros(),99 );

		Assert.assertEquals(jugador.getSalud(), 108 );

		
	}
	
}
