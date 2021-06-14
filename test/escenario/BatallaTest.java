package escenario;

import combatientes.ejercito.*;
import combatientes.guerrero.*;
import org.junit.Assert;
import org.junit.Test;

public class BatallaTest {
    Batalla batalla = new Batalla();
    EjercitoPropio ejercitoPropio;
    EjercitoEnemigo ejercitoEnemigo;
    Ejercito ejercitoVictorioso;

    @Test
    public void prueba001() {
        new Batalla();
    }

    @Test
    public void prueba002() {
        ejercitoPropio = new EjercitoPropio(new Nortaichian(), 2);
        ejercitoEnemigo = new EjercitoEnemigo(new Reralopes(), 3);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo);

        Assert.assertEquals(ejercitoPropio, ejercitoVictorioso);
    }

    @Test
    public void prueba003() {
        ejercitoPropio = new EjercitoPropio(new Wrives(), 10);
        ejercitoEnemigo = new EjercitoEnemigo(new Radaiteran(), 10);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo);

        Assert.assertEquals(ejercitoPropio, ejercitoVictorioso);
    }

    @Test
    public void prueba004() {
        ejercitoPropio = new EjercitoPropio(new Reralopes(), 20);
        ejercitoEnemigo = new EjercitoEnemigo(new Wrives(), 20);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo);

        Assert.assertEquals(ejercitoEnemigo, ejercitoVictorioso);
    }
    
    @Test
    public void prueba005() {
        ejercitoPropio = new EjercitoPropio(new Wrives(), 5);
        ejercitoEnemigo = new EjercitoEnemigo(new Radaiteran(), 5);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo);
        int cantidadDeGuerrerosVictoriososRestantes = ejercitoVictorioso.cantidadDeGuerreros();

        Assert.assertEquals(ejercitoPropio, ejercitoVictorioso);
        Assert.assertEquals(1, cantidadDeGuerrerosVictoriososRestantes);
    }

    @Test
    public void prueba006() {
        ejercitoPropio = new EjercitoPropio(new Wrives(), 300);
        ejercitoEnemigo = new EjercitoEnemigo(new Radaiteran(), 301);

        ejercitoVictorioso = (Ejercito) batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo);
        int cantidadDeGuerrerosVictoriososRestantes = ejercitoVictorioso.cantidadDeGuerreros();

        Assert.assertEquals(ejercitoEnemigo, ejercitoVictorioso);
        Assert.assertEquals(1, cantidadDeGuerrerosVictoriososRestantes);
    }
    
    @Test
    public void prueba007() {
        ejercitoPropio = new EjercitoPropio(new Nortaichian(), 2);
        ejercitoEnemigo = new EjercitoEnemigo(new Reralopes(), 3);

        Assert.assertEquals(ejercitoPropio, batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo));

        ejercitoPropio.agregarEjercito(new EjercitoAliado(new Wrives(), 5));
        ejercitoEnemigo = new EjercitoEnemigo(new Reralopes(), 3);
        Assert.assertEquals(ejercitoPropio, batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo));

        ejercitoEnemigo = new EjercitoEnemigo(new Wrives(), 4);
        Assert.assertEquals(ejercitoPropio, batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo));

        Assert.assertEquals(2, ejercitoPropio.cantidadDeGuerreros());
    }
    
    @Test
    public void prueba008() {
        ejercitoPropio = new EjercitoPropio(new GuerreroHack(100, 50), 4);
        ejercitoEnemigo = new EjercitoEnemigo(new GuerreroHack(100, 50), 2);

        Assert.assertEquals(ejercitoPropio, batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo));
        Assert.assertEquals(3, ejercitoPropio.cantidadDeGuerreros());
        Assert.assertEquals(100, ejercitoPropio.getSalud());

        ejercitoEnemigo = new EjercitoEnemigo(new GuerreroHack(100, 50), 2);
        Assert.assertEquals(ejercitoPropio, batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo));
        Assert.assertEquals(2, ejercitoPropio.cantidadDeGuerreros());
        Assert.assertEquals(50, ejercitoPropio.getSalud());

        ejercitoEnemigo = new EjercitoEnemigo(new GuerreroHack(100, 50), 1);
        Assert.assertEquals(ejercitoPropio, batalla.obtenerSobreviviente(ejercitoPropio, ejercitoEnemigo));
        Assert.assertEquals(1, ejercitoPropio.cantidadDeGuerreros());
        Assert.assertEquals(50, ejercitoPropio.getSalud());

    }
    
    @Test
    public void prueba009() {
        ejercitoPropio = new EjercitoPropio(new GuerreroHack(100, 100), 4);

        EjercitoAliado ejercitoAliadoUno = new EjercitoAliado(new GuerreroHack(200, 200), 4);
        ejercitoPropio.agregarEjercito(ejercitoAliadoUno);
        Assert.assertEquals(200, ejercitoPropio.getSalud());


        EjercitoAliado ejercitoAliadoDos = new EjercitoAliado(new GuerreroHack(300, 300), 4);
        ejercitoPropio.agregarEjercito(ejercitoAliadoDos);
        Assert.assertEquals(200, ejercitoPropio.getSalud());

    }
    
   }
