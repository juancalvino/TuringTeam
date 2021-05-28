package Escenario;

import Guerreros.*;
import org.junit.Assert;
import org.junit.Test;

public class PuebloTest {
    @Test
    public void prueba001() {
        PuebloPropio algo = new PuebloPropio(2, new Radaiteran());
        PuebloEnemigo otro = new PuebloEnemigo(2, new Radaiteran());

        Batalla batalla = new Batalla(algo, otro);

        Assert.assertEquals(algo, batalla.calcularBatalla());
    }

    @Test
    public void prueba002() {
        PuebloPropio algo = new PuebloPropio(2, new Radaiteran());
        PuebloEnemigo otro = new PuebloEnemigo(2, new Reralopes());

        Batalla batalla = new Batalla(algo, otro);

        Assert.assertEquals(algo, batalla.calcularBatalla());
    }

    @Test
    public void prueba003() {
        PuebloPropio algo = new PuebloPropio(2, new Radaiteran());
        PuebloEnemigo otro = new PuebloEnemigo(2, new Reralopes());

        Batalla batalla = new Batalla(otro, algo);

        Assert.assertEquals(algo, batalla.calcularBatalla());
    }

    @Test
    public void prueba004() {
        PuebloPropio algo = new PuebloPropio(23, new Radaiteran());
        PuebloEnemigo otro = new PuebloEnemigo(30, new Reralopes());

        Batalla batalla = new Batalla(otro, algo);
        Pueblo ganador = batalla.calcularBatalla();

        ganador.devolverDatos();

        Assert.assertEquals(algo, ganador);
    }

    @Test
    public void prueba005() {
        PuebloPropio algo = new PuebloPropio(23, new Radaiteran());
        PuebloEnemigo otro = new PuebloEnemigo(1000, new Reralopes());

        Batalla batalla = new Batalla(otro, algo);
        Pueblo ganador = batalla.calcularBatalla();

        ganador.devolverDatos();

        Assert.assertEquals(otro, ganador);
    }
}
