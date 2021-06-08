package combatientes;


import org.junit.Assert;
import org.junit.Test;

public class EjercitoTest {

	@Test
	public void crearEjercitoConWrives() {
		Ejercito ejercitoDeWrives = new Ejercito(new Wrives(), 100) ;
		
		Assert.assertEquals(ejercitoDeWrives.getSalud(),108);
		ejercitoDeWrives.recibirAtaque(100);

		Assert.assertEquals(ejercitoDeWrives.devolverCantidadDeGuerreros() , 99);
		
		Assert.assertEquals(ejercitoDeWrives.getSalud(),108);
		
		ejercitoDeWrives.recibirAtaque(200);
		Assert.assertEquals(ejercitoDeWrives.devolverCantidadDeGuerreros() , 98);
		
	}
	
}
