package escenario;

import combatientes.ejercito.*;
import combatientes.guerrero.*;
import org.junit.Assert;
import org.junit.Test;

public class BatallaTest {
    Batalla batalla = new Batalla();
    EjercitoJugador ejercitoJugador;
    EjercitoEnemigo ejercitoEnemigo;
    Ejercito ejercitoVictorioso;

    @Test
    public void prueba001() {
        new Batalla();
    }

    @Test
    public void prueba002() {
        ejercitoJugador = new EjercitoJugador(new Nortaichian(), 2);
        ejercitoEnemigo = new EjercitoEnemigo(new Reralopes(), 3);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo);

        Assert.assertEquals(ejercitoJugador, ejercitoVictorioso);
    }

    @Test
    public void prueba003() {
        ejercitoJugador = new EjercitoJugador(new Wrives(), 10);
        ejercitoEnemigo = new EjercitoEnemigo(new Radaiteran(), 10);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo);

        Assert.assertEquals(ejercitoJugador, ejercitoVictorioso);
    }

    @Test
    public void prueba004() {
        ejercitoJugador = new EjercitoJugador(new Reralopes(), 20);
        ejercitoEnemigo = new EjercitoEnemigo(new Wrives(), 20);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo);

        Assert.assertEquals(ejercitoEnemigo, ejercitoVictorioso);
    }
    
    @Test
    public void prueba005() {
        ejercitoJugador = new EjercitoJugador(new Wrives(), 5);
        ejercitoEnemigo = new EjercitoEnemigo(new Radaiteran(), 5);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo);
        int cantidadDeGuerrerosVictoriososRestantes = ejercitoVictorioso.cantidadDeGuerreros();

        Assert.assertEquals(ejercitoJugador, ejercitoVictorioso);
        Assert.assertEquals(1, cantidadDeGuerrerosVictoriososRestantes);
    }

    @Test
    public void prueba006() {
        ejercitoJugador = new EjercitoJugador(new Wrives(), 300);
        ejercitoEnemigo = new EjercitoEnemigo(new Radaiteran(), 301);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo);
        int cantidadDeGuerrerosVictoriososRestantes = ejercitoVictorioso.cantidadDeGuerreros();

        Assert.assertEquals(ejercitoEnemigo, ejercitoVictorioso);
        Assert.assertEquals(1, cantidadDeGuerrerosVictoriososRestantes);
    }
}
