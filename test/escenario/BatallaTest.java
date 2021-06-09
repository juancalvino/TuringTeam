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

        ejercitoVictorioso = batalla.obtenerSobreviviente(nuestroEjercito, ejercitoEnemigo);

        Assert.assertEquals(nuestroEjercito, ejercitoVictorioso);
    }

    @Test
    public void prueba003() {
        nuestroEjercito = new EjercitoJugador(new Wrives(), 10);
        ejercitoEnemigo = new EjercitoEnemigo(new Radaiteran(), 10);

        ejercitoVictorioso = batalla.obtenerSobreviviente(nuestroEjercito, ejercitoEnemigo);

        Assert.assertEquals(nuestroEjercito, ejercitoVictorioso);
    }

    @Test
    public void prueba004() {
        nuestroEjercito = new EjercitoJugador(new Reralopes(), 20);
        ejercitoEnemigo = new EjercitoEnemigo(new Wrives(), 20);

        ejercitoVictorioso = batalla.obtenerSobreviviente(nuestroEjercito, ejercitoEnemigo);

        Assert.assertEquals(nuestroEjercito, ejercitoVictorioso);
    }
}
