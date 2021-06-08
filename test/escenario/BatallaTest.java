package escenario;

import combatientes.ejercito.EjercitoEnemigo;
import combatientes.ejercito.EjercitoJugador;
import combatientes.guerrero.Nortaichian;
import combatientes.guerrero.Reralopes;

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
    
    @Test
    public void prueba004() {
        nuestroEjercito = new EjercitoJugador(new Reralopes(), 200);
        ejercitoEnemigo = new EjercitoEnemigo(new Nortaichian(), 3);
        Assert.assertEquals(nuestroEjercito, batalla.obtenerSobreviviente(nuestroEjercito, ejercitoEnemigo));
    }
}
