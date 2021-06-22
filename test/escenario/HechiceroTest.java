package escenario;

import org.junit.Assert;
import org.junit.Test;

import iO.CargaDeArchivos;

public class HechiceroTest {

	Hechicero hechicero = new Hechicero();
	CargaDeArchivos io = new CargaDeArchivos();

	@Test
	public void deberianSobrevivir75GuerrerosYHacerRecorridoDe22DiasEnArchivoConsigna() {
		io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoConsigna.txt");
		String prediccion = "Mision exitosa. Sobrevivieron: 75 guerreros. El recorrido tuvo una duracion de: 22 dias.";
		Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
	}

	@Test
	public void deberianSobrevivir2GuerrerosYHacerRecorridoDe24DiasEnArchivoCaso1() {
		io.instanciarElEscenarioEnRuta("test/archivosHechicero/caso1.txt");
		String prediccion = "Mision exitosa. Sobrevivieron: 2 guerreros. El recorrido tuvo una duracion de: 24 dias.";
		Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
	}

	@Test
	public void deberianSobrevivir27143GuerrerosYHacerRecorridoDe19Dias() {
		io.instanciarElEscenarioEnRuta("test/archivosHechicero/caso2.txt");
		String prediccion = "Mision exitosa. Sobrevivieron: 70001 guerreros. El recorrido tuvo una duracion de: 19 dias.";
		Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
	}

	@Test
	public void deberiaSerDerrotadoEnElPueblo4() {
		io.instanciarElEscenarioEnRuta("test/archivosHechicero/caso3.txt");
		String prediccion = "Mision fallida. Ultimo pueblo alcanzado: 4";
		Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
	}

	@Test
	public void deberianSobrevivir43GuerrerosYHacerRecorridoEn4Dias() {
		io.instanciarElEscenarioEnRuta("test/archivosHechicero/caso4.txt");
		String prediccion = "Mision exitosa. Sobrevivieron: 43 guerreros. El recorrido tuvo una duracion de: 4 dias.";
		Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
	}

	@Test
	public void deberiaSobrevivir7GuerrerosYHacerRecorridoEn8Dias() {
		io.instanciarElEscenarioEnRuta("test/archivosHechicero/caso5.txt");
		String prediccion = "Mision exitosa. Sobrevivieron: 7 guerreros. El recorrido tuvo una duracion de: 8 dias.";
		Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
	}

}
