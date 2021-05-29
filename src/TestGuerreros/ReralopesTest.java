package TestGuerreros;

import Guerreros.Guerrero;
import Guerreros.Reralopes;
import org.junit.Assert;
import org.junit.Test;

public class ReralopesTest {

    Guerrero unaReralopes = new Reralopes();
    Guerrero otraReralopes = new Reralopes();

    // Se crea una nueva instancia de Reralopes
    @Test
    public void prueba001() {
        new Reralopes();
    }

    // Verificar que los valores básicos (salud, danio) de una Reralopes coinciden con los indicados por la consigna
    // Salud: 53, Danio basico: 27
    @Test
    public void prueba002() {
        Assert.assertEquals(53, unaReralopes.getSalud());
        Assert.assertEquals(27, unaReralopes.getDanioBasico());
    }

    // Se verifica que unaReralopes erra 2 de 4 ataques
    @Test
    public void prueba003() {
        Assert.assertEquals(27, unaReralopes.atacar());
        Assert.assertEquals(27, unaReralopes.atacar());
        Assert.assertEquals(0, unaReralopes.atacar());
        Assert.assertEquals(0, unaReralopes.atacar());
        Assert.assertEquals(27, unaReralopes.atacar());
    }


    // Se verifica que al descansar, sus siguientes 3 ataques son criticos
    @Test
    public void prueba004() {
        unaReralopes.descansar();

        Assert.assertEquals(54, unaReralopes.atacar());
        Assert.assertEquals(54, unaReralopes.atacar());

        // El tercer ataque es errado pero de todas formas consume un ataque critico
        Assert.assertEquals(0, unaReralopes.atacar());
        Assert.assertEquals(0, unaReralopes.atacar());

        Assert.assertEquals(27, unaReralopes.atacar());
    }

    // Se verifica que un ataque a otra unidad ha sido satisfactoria
    @Test
    public void prueba005() {
        unaReralopes.atacar(otraReralopes);
        Assert.assertEquals(26, otraReralopes.getSalud());
    }

    // Se verifica que unaReralopes se desconcentra luego de recibir un ataque (es decir, pierde su efecto descansado)
    @Test
    public void prueba006() {
        unaReralopes.descansar();
        Assert.assertEquals(54, unaReralopes.atacar());

        otraReralopes.atacar(unaReralopes);

        Assert.assertEquals(27, unaReralopes.atacar());
    }
}
