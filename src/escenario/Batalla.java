package escenario;
import combatientes.Combatiente;
import combatientes.ejercito.EjercitoEnemigo;
import combatientes.ejercito.EjercitoJugador;

public class Batalla {
	
    public Combatiente obtenerSobreviviente(EjercitoJugador ejercitoJugador, EjercitoEnemigo ejercitoEnemigo) {

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
    	
    	Combatiente ejercitoGanador = ejercitoJugador.getSalud()>= 0? ejercitoJugador : ejercitoEnemigo;
    	ejercitoGanador.guerreroCombatio();
    	
        return ejercitoGanador;
    }

}
