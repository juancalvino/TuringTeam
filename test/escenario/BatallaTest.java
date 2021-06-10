package escenario;

import combatientes.Combatiente;
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
    
    @Test
    public void prueba007() {
        ejercitoJugador = new EjercitoJugador(new Nortaichian(), 2);
        ejercitoEnemigo = new EjercitoEnemigo(new Reralopes(), 3);

        Assert.assertEquals(ejercitoJugador, batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo));
        
        ejercitoJugador.agregarEjercito(new EjercitoAliado(new Wrives(), 5));
        ejercitoEnemigo = new EjercitoEnemigo(new Reralopes(), 3);
        Assert.assertEquals(ejercitoJugador, batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo));

        ejercitoEnemigo = new EjercitoEnemigo(new Wrives(), 4);
        Assert.assertEquals(ejercitoJugador, batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo));

        Assert.assertEquals(2, ejercitoJugador.cantidadDeGuerreros());
    }
    
    @Test
    public void prueba008() {
        ejercitoJugador = new EjercitoJugador(new GuerreroHack(100,50), 4);
        ejercitoEnemigo = new EjercitoEnemigo(new GuerreroHack(100,50), 2);

        Assert.assertEquals(ejercitoJugador, batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo));
        Assert.assertEquals(3, ejercitoJugador.cantidadDeGuerreros());
        Assert.assertEquals(100, ejercitoJugador.getSalud());
        
        ejercitoEnemigo = new EjercitoEnemigo(new GuerreroHack(100,50), 2);
        Assert.assertEquals(ejercitoJugador, batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo));
        Assert.assertEquals(2, ejercitoJugador.cantidadDeGuerreros());
        Assert.assertEquals(50, ejercitoJugador.getSalud());

        ejercitoEnemigo = new EjercitoEnemigo(new GuerreroHack(100,50), 1);
        Assert.assertEquals(ejercitoJugador, batalla.obtenerSobreviviente(ejercitoJugador, ejercitoEnemigo));        
        Assert.assertEquals(1, ejercitoJugador.cantidadDeGuerreros());
        Assert.assertEquals(50, ejercitoJugador.getSalud());

    }
    
    @Test
    public void prueba009() {
      ejercitoJugador = new EjercitoJugador(new GuerreroHack(100,100), 4);
      
      EjercitoAliado  ejercitoAliadoUno= new EjercitoAliado(new GuerreroHack(200,200), 4);
      ejercitoJugador.agregarEjercito(ejercitoAliadoUno);
      Assert.assertEquals(200, ejercitoJugador.getSalud());

     
      EjercitoAliado  ejercitoAliadoDos= new EjercitoAliado(new GuerreroHack(300,300), 4);
      ejercitoJugador.agregarEjercito(ejercitoAliadoDos);
      Assert.assertEquals(200, ejercitoJugador.getSalud());
     
    }
    
   }
