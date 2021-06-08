package combatientes;


import org.junit.Assert;
import org.junit.Test;

public class EjercitoTest {

	
	@Test
	public void iniciarEjercitoPropioCon100WrivesYDesmayarAUnGuerrero() throws CreateInstanceEjercitoPropioException, NegativeNumberException{
		
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);
	
		Assert.assertEquals(jugador.getSalud(),108);
		jugador.recibirAtaque(100);

		Assert.assertEquals(jugador.cantidadDeGuerreros(), 99);

		Assert.assertEquals(jugador.getSalud(),108);
	}
	
	@Test
	public void agregarANuestroEjercitoAliadosDe100Reralopes() throws CreateInstanceEjercitoPropioException, NegativeNumberException{
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);

		jugador.agregarEjercito(new EjercitoAliado(new Reralopes(), 100));
		Assert.assertEquals(jugador.cantidadDeGuerreros(), 200);
		
	}
	
	@Test
	public void desmayar100GuerrerosReralopesAliadosDeNuestroEjercito() throws CreateInstanceEjercitoPropioException, NegativeNumberException{
		EjercitoJugador jugador = new EjercitoJugador(new Wrives(), 100);

		jugador.agregarEjercito(new EjercitoAliado(new Reralopes(), 100));
		Assert.assertEquals(jugador.cantidadDeGuerreros(), 200);
		
		Assert.assertEquals(jugador.atacar(), 27);
		
		for(int i =0; i<100; i++) {
			jugador.recibirAtaque(57);
		}
		
		Assert.assertEquals(jugador.cantidadDeGuerreros(),100 );
		
		jugador.recibirAtaque(57);
	
		Assert.assertEquals(jugador.cantidadDeGuerreros(),99 );

		Assert.assertEquals(jugador.getSalud(), 108 );

	}	
}
