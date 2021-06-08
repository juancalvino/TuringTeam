package escenario;
import combatientes.Ejercito;
import combatientes.EjercitoEnemigo;
import combatientes.EjercitoJugador;

public class Batalla {
	
    public Ejercito obtenerSobreviviente(EjercitoJugador ejercitoJugador, EjercitoEnemigo ejercitoEnemigo) {

    	boolean seguirBatallando = true;
    	while (seguirBatallando) {
        	
            ejercitoEnemigo.recibirAtaque(ejercitoJugador.atacar());
            seguirBatallando = ejercitoEnemigo.getSalud() < 0;
    
            ejercitoJugador.recibirAtaque(ejercitoEnemigo.atacar());
            seguirBatallando = ejercitoJugador.getSalud() < 0;
        }
    	
        return ejercitoJugador.getSalud()>= 0? ejercitoJugador : ejercitoEnemigo ;
    }

}
