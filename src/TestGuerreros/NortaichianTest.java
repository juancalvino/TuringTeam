package TestGuerreros;

import Guerreros.Guerrero;
import Guerreros.Nortaichian;
import org.junit.Assert;
import org.junit.Test;

public class NortaichianTest {

    Guerrero unNortaichian = new Nortaichian();
    Guerrero otroNortaichian = new Nortaichian();

    // Se crea una nueva instancia de Nortaichian
    @Test
    public void prueba001() {
        Nortaichian prueba = new Nortaichian();

        Assert.assertNotNull(prueba);
    }

    // Se verifica que los valores inicializados de la instancia coincidan con los senialados por la consigna
    // Salud: 66, Danio Basico: 18
    @Test
    public void prueba002() {
        Assert.assertEquals(66, unNortaichian.getSalud());
        Assert.assertEquals(18, unNortaichian.getDanioBasico());
    }

    // Se verifica que unNortaichian ataca a otro satisfactoriamente
    @Test
    public void prueba003() {
        unNortaichian.atacar(otroNortaichian);
        // la salud inicial de un 'otroNortaichian' es igual a 66
        Assert.assertEquals(48, otroNortaichian.getSalud());
    }

    /*
     * 'unNortaichian' cada vez que ataca se cura un 4% de su salud
     */
    @Test
    public void prueba004() {
        unNortaichian.atacar(otroNortaichian);
        Assert.assertEquals(68, unNortaichian.getSalud());
    }


    /*
     * 'unNortaichian' ataca a 'otroNortaichian', 'otroNortaichian' ataca enfurecido (x2)
     */
    @Test
    public void prueba005() {
        unNortaichian.atacar(otroNortaichian);
        otroNortaichian.atacar(unNortaichian);

        Assert.assertEquals(49, otroNortaichian.getSalud());
        Assert.assertEquals(32, unNortaichian.getSalud());
    }

    /*
     * 'unNortaichian' recibe danio, pero luego descansa y recupera toda su salud.
     */
    @Test
    public void prueba006() {
        otroNortaichian.atacar(unNortaichian);

        Assert.assertEquals(48, unNortaichian.getSalud());
        unNortaichian.descansar();

        Assert.assertEquals(66, unNortaichian.getSalud());
    }

    /*
     * 'unNortaichian' descansa y durante 2 turnos no puede
     * atacar (infligen 0 danio) a 'otroNortaichian', pero se reduce el danio recibido a la mitad
     */
    @Test
    public void prueba008() {
        unNortaichian.descansar();

        unNortaichian.atacar(otroNortaichian);
        Assert.assertEquals(66, otroNortaichian.getSalud());

        otroNortaichian.atacar(unNortaichian);
        Assert.assertEquals(57, unNortaichian.getSalud());

        unNortaichian.atacar(otroNortaichian);
        Assert.assertEquals(68, otroNortaichian.getSalud());

        otroNortaichian.atacar(unNortaichian);
        Assert.assertEquals(39, unNortaichian.getSalud());

        unNortaichian.atacar(otroNortaichian);
        Assert.assertEquals(34, otroNortaichian.getSalud());

        otroNortaichian.atacar(unNortaichian);
        Assert.assertEquals(4, unNortaichian.getSalud());
    }

}
