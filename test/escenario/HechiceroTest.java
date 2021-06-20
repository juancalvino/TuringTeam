package escenario;

import org.junit.Assert;
import org.junit.Test;

import iO.CargaDeArchivos;

public class HechiceroTest {

    CargaDeArchivos io = new CargaDeArchivos();
    Hechicero hechicero = new Hechicero();

    @Test
    public void hechiceroUno() {
        io.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoConsigna.txt");
        String prediccion = "Mision exitosa. Sobrevivieron: 75 guerreros. El recorrido tuvo una duracion de: 22 dias.";
        Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
    }

    @Test
    public void hechiceroDos() {
        io.instanciarElEscenarioEnRuta("test/archivosHechicero/pruebaCaso1.txt");
        String prediccion = "null";
        Assert.assertEquals(prediccion, hechicero.realizarPrediccionDeAventura());
    }
}
