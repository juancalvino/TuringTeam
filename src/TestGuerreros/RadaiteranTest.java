package TestGuerreros;

import Guerreros.Guerrero;
import Guerreros.Radaiteran;
import org.junit.Assert;
import org.junit.Test;

public class RadaiteranTest {

    Guerrero unRadaiteran = new Radaiteran();
    Guerrero otroRadaiteran = new Radaiteran();


    // Prueba crear guerrero Radaiteran
    @Test
    public void prueba001() {
        new Radaiteran();
    }

    // Prueba corroborar valores predeterminados del guerrero
    // Salud: 36, Danio basico: 56
    @Test
    public void prueba002() {
        Assert.assertEquals(36, unRadaiteran.getSalud());
        Assert.assertEquals(56, unRadaiteran.atacar());
    }

    // Prueba ataque Radaiteran
    @Test
    public void prueba003() {
        unRadaiteran.atacar(otroRadaiteran);
        Assert.assertEquals(-20, otroRadaiteran.getSalud());
    }

    // Prueba de ataques, danio aumenta 3 por cada golpe dado anteriormente
    @Test
    public void prueba004() {
        Assert.assertEquals(56, otroRadaiteran.atacar());
        Assert.assertEquals(59, otroRadaiteran.atacar());
        Assert.assertEquals(62, otroRadaiteran.atacar());
        Assert.assertEquals(65, otroRadaiteran.atacar());
        Assert.assertEquals(68, otroRadaiteran.atacar());

    }

    // Prueba recibir ataque
    @Test
    public void prueba005() {
        unRadaiteran.recibirAtaque(10);
        Assert.assertEquals(26, unRadaiteran.getSalud());
    }

    // Prueba recibir ataque triple, recibe danio normal sin modificacion
    @Test
    public void prueba006() {
        unRadaiteran.recibirAtaque(5);
        Assert.assertEquals(31, unRadaiteran.getSalud());
        unRadaiteran.recibirAtaque(5);
        Assert.assertEquals(26, unRadaiteran.getSalud());
        unRadaiteran.recibirAtaque(5);
        Assert.assertEquals(21, unRadaiteran.getSalud());
    }
}
