package TestGuerreros;

import Guerreros.Guerrero;
import Guerreros.Wrives;
import org.junit.Assert;
import org.junit.Test;

public class WrivesTest {

    Guerrero unWrives = new Wrives();
    Guerrero otroWrives = new Wrives();

    // Crear un guerrero Wrives

    @Test
    public void prueba001() {
        new Wrives();
    }


    /*
     * Verificar valores nominales
     * Salud Inicial = 108
     * Danio Basico = 113
     */
    @Test
    public void prueba002() {
        Assert.assertEquals(113, unWrives.getDanioBasico());
        Assert.assertEquals(108, unWrives.getSalud());
    }

    /*
     * Verificar forma de ataque
     * Hace 2 veces su danio cada 2 turnos
     */
    @Test
    public void prueba003() {
        Assert.assertEquals(113, unWrives.atacar());
        Assert.assertEquals(226, unWrives.atacar());
        Assert.assertEquals(113, unWrives.atacar());
        Assert.assertEquals(226, unWrives.atacar());
    }

    /*
     * Verificar recibir ataque
     * Recibir el ataque por 2
     */
    @Test
    public void prueba004() {
        unWrives.recibirAtaque(100);
        Assert.assertEquals(8, unWrives.getSalud());
    }

    /*
     * Verificar descansar
     */
    @Test
    public void prueba005() {
        Assert.assertEquals(108, unWrives.getSalud());

        // unWrives incrementa su salud en 50 al descansar y se pone en 'modo pacifista'
        unWrives.descansar();
        Assert.assertEquals(158, unWrives.getSalud());

        //unWrives no le quita vida al enemigo porque esta en 'modo pacifista'
        unWrives.atacar(otroWrives);
        Assert.assertEquals(108, otroWrives.getSalud());

        //unWrives recibe un ataque y se pone activo para atacar
        otroWrives.atacar(unWrives);
        Assert.assertEquals(45, unWrives.getSalud());

        //unWrives ataca al enemigo
        unWrives.atacar(otroWrives);
        Assert.assertEquals(-5, otroWrives.getSalud());
    }

}