package escenario;

import org.junit.Assert;
import org.junit.Test;

import iO.CargaDeArchivos;

public class HechiceroTest {

    CargaDeArchivos io = new CargaDeArchivos();
    Hechicero hechicero = new Hechicero();

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
        String prediccion = "Mision exitosa. Sobrevivieron: 27143 guerreros. El recorrido tuvo una duracion de: 19 dias.";
        Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
    }
}
