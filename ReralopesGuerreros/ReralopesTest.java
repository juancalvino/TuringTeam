import org.junit.Assert;
import org.junit.Test;

public class ReralopesTest {

    Guerreros unaReralopes = new Reralopes();

    // Crear una instancia de Reralopes
    @Test
    public void prueba001() {
        new Reralopes();
    }

    // Verificar que los valores básicos (salud, danio) de una Reralopes coinciden con los indicados por la consigna
    // Salud: 53, Danio basico: 27
    @Test
    public void prueba002() {
        Assert.assertEquals(53, unaReralopes.getSalud());
        Assert.assertEquals(27, unaReralopes.getDanio());
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


    // unaReraloples ataca, pero luego es atacada, por lo que su 'contadorDeAtaques' se reinicia y los siguientes
    // dos ataques son satisfactorios
    @Test
    public void prueba004() {
        Assert.assertEquals(27, unaReralopes.atacar());

        unaReralopes.recibirAtaque(1);

        Assert.assertEquals(27, unaReralopes.atacar());

        Assert.assertEquals(27, unaReralopes.atacar());
    }

    // Se verifica que al descansar, sus siguientes 3 ataques son criticos
    @Test
    public void prueba005() {
        unaReralopes.descansar();

        Assert.assertEquals(54, unaReralopes.atacar());
        Assert.assertEquals(54, unaReralopes.atacar());
        // El tercer ataque es errado pero de todas formas consume un ataque critico
        Assert.assertEquals(0, unaReralopes.atacar());
    }

    // Se verifica que un ataque a otra unidad ha sido satisfactorio
    @Test
    public void prueba006() {
        Reralopes otraReralopes = new Reralopes();

        unaReralopes.atacar(otraReralopes);

        Assert.assertEquals(26,otraReralopes.getSalud());
    }


}
