package escenario;
import combatientes.Combatiente;
import combatientes.ejercito.Ejercito;
import combatientes.ejercito.EjercitoEnemigo;
import combatientes.ejercito.EjercitoJugador;

public class Batalla {
	
    public Ejercito obtenerSobreviviente(EjercitoJugador ejercitoJugador, EjercitoEnemigo ejercitoEnemigo) {

    	boolean seguirBatallando = true;
    	Combatiente atacante = ejercitoJugador;
    	Combatiente receptor = ejercitoEnemigo;
    	
    	while (seguirBatallando) {
    		
            receptor.recibirAtaque(atacante.atacar());
            seguirBatallando = receptor.getSalud() > 0;
    
            Combatiente aux = atacante;
            atacante = receptor;
            receptor = aux;
    	}
    	
        return ejercitoJugador.getSalud()>= 0? ejercitoJugador : ejercitoEnemigo ;
    }

}
