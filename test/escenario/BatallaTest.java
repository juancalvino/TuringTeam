package escenario;

import combatientes.*;
import org.junit.Assert;
import org.junit.Test;

public class BatallaTest {
    Batalla batalla = new Batalla();
    EjercitoJugador nuestroEjercito;
    EjercitoEnemigo ejercitoEnemigo;

    @Test
    public void prueba001() {
        new Batalla();
    }

    @Test
    public void prueba002() {
        nuestroEjercito = new EjercitoJugador(new Nortaichian(), 2);
        ejercitoEnemigo = new EjercitoEnemigo(new Reralopes(), 3);
        Assert.assertEquals(nuestroEjercito, batalla.obtenerSobreviviente(nuestroEjercito, ejercitoEnemigo));
    }
}
