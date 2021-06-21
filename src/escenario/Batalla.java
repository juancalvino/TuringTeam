package escenario;
import combatientes.Combatiente;
import combatientes.ejercito.EjercitoEnemigo;
import combatientes.ejercito.EjercitoPropio;

public class Batalla {

	/**
	 * Los ejercitos ingresados como parametros combaten.
	 * @param ejercitoPropio
	 * @param ejercitoEnemigo
	 * @return el ejercito sobreviviente
	 */
    public static Combatiente obtenerSobreviviente(EjercitoPropio ejercitoPropio, EjercitoEnemigo ejercitoEnemigo) {

        boolean seguirBatallando = true;
        Combatiente atacante = ejercitoPropio;
        Combatiente receptor = ejercitoEnemigo;

        while (seguirBatallando) {

            receptor.recibirAtaque(atacante.atacar());
            seguirBatallando = receptor.getSalud() > 0;

            Combatiente aux = atacante;
            atacante = receptor;
            receptor = aux;
        }

        Combatiente ejercitoGanador = ejercitoPropio.getSalud() >= 0 ? ejercitoPropio : ejercitoEnemigo;
        ejercitoGanador.guerreroCombatio();

        return ejercitoGanador;
    }

}
