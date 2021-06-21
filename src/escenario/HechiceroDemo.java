package escenario;

import iO.CargaDeArchivos;

public class HechiceroDemo {
    public static void main(String[] args) {
        Hechicero hechicero = new Hechicero();
        CargaDeArchivos carga = new CargaDeArchivos();

        carga.instanciarElEscenarioEnRuta("test/archivosIO/pruebaArchivoConsigna.txt");
        System.out.println(hechicero.realizarPrediccionDeAventura());
        System.out.println("*************");

        carga.instanciarElEscenarioEnRuta("test/archivosHechicero/caso1.txt");
        System.out.println(hechicero.realizarPrediccionDeAventura());
        System.out.println("*************");

        carga.instanciarElEscenarioEnRuta("test/archivosHechicero/caso2.txt");
        System.out.println(hechicero.realizarPrediccionDeAventura());
        System.out.println("*************");

        carga.instanciarElEscenarioEnRuta("test/archivosHechicero/caso3.txt");
        System.out.println(hechicero.realizarPrediccionDeAventura());
        System.out.println("*************");

        carga.instanciarElEscenarioEnRuta("test/archivosHechicero/caso4.txt");
        System.out.println(hechicero.realizarPrediccionDeAventura());
        System.out.println("*************");

        carga.instanciarElEscenarioEnRuta("test/archivosHechicero/caso5.txt");
        System.out.println(hechicero.realizarPrediccionDeAventura());
        System.out.println("*************");
    }
}
