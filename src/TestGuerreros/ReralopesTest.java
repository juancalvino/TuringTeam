package TestGuerreros;

import org.junit.Assert;
import org.junit.Test;
import Guerreros.*;

public class ReralopesTest {

    Guerrero reralopes = new Reralopes();
    Guerrero enemigo = new GuerreroRandom(300, 10);
    // Crear una instancia de Reralopes
    @Test
    public void prueba001() {
        new Reralopes();
    }

    // Verificar que los valores básicos (salud, danio) de una Reralopes coinciden con los indicados por la consigna
    // Salud: 53, Danio basico: 27
    @Test
    public void prueba002() {
    	reralopes.atacar(enemigo);
    	
        Assert.assertEquals(53, reralopes.getSalud());
        Assert.assertEquals(273, enemigo.getSalud());        
    }
    
    // Se verifica que unaReralopes erra 2 de 4 ataques
    @Test
    public void prueba003() {
        Assert.assertEquals(27, reralopes.atacar());
        Assert.assertEquals(27, reralopes.atacar());
        Assert.assertEquals(0, reralopes.atacar());
        Assert.assertEquals(0, reralopes.atacar());
        Assert.assertEquals(27, reralopes.atacar());
    }


    // unaReraloples ataca, pero luego es atacada, por lo que su 'contadorDeAtaques' se reinicia y los siguientes
    // dos ataques son satisfactorios
    @Test
    public void prueba004() {
        Assert.assertEquals(27, reralopes.atacar());

        enemigo.atacar(reralopes);

        Assert.assertEquals(27, reralopes.atacar());
        Assert.assertEquals(0, reralopes.atacar());
    }

    // Se verifica que al descansar, sus siguientes 3 ataques son criticos
    @Test
    public void prueba005() {
        reralopes.descansar();

        Assert.assertEquals(54, reralopes.atacar());
        Assert.assertEquals(54, reralopes.atacar());
        
        // El tercer ataque es errado pero de todas formas consume un ataque critico
        Assert.assertEquals(0, reralopes.atacar());
        Assert.assertEquals(0, reralopes.atacar());

        Assert.assertEquals(27, reralopes.atacar());
    }

    // Se verifica que un ataque a otra unidad ha sido satisfactoria
    @Test
    public void prueba006() {
        Reralopes otraReralopes = new Reralopes();

        reralopes.atacar(otraReralopes);

        Assert.assertEquals(26,otraReralopes.getSalud());
    }


}
