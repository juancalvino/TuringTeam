package Guerreros;

public class Reralopes extends Guerrero {

	boolean ataca;
	int ataquesConsecutivos;
	private int concentrado = 0;
	
    public void posicionar() {
        this.salud = 53;
        this.danioBasico = 27;
        this.ataquesConsecutivos = 0;
        this.ataca = true;
    }

    /**
     * Erra 2 de cada 4 ataques. Los primeros 2 ataques (contadorDeAtaques = 0 o 1) serán satisfactorios
     * mientras que los 2 siguientes serán errados (contadorDeAtaques = 2 o 3).
     *
     * @return Devuelve el valor de danio del proximo ataque. Devuelve 0 en caso de que sea ataque errado y el daño
     * se duplica si el ataque es critico
     */
    @Override
    public int atacar() {
    	
		if (ataquesConsecutivos >= 2) {
			ataquesConsecutivos = 0;
			ataca = !ataca;
		}		
		
		int ataque = danioBasico;

		if(concentrado > 0) {
			ataque *= 2;
			concentrado--;
		}
		
		ataquesConsecutivos++;
		
    	return ataca? ataque : 0;
		
    }

    /**
     * @param danioRecibido: valor entero que indica el valor del danio recibido de un ataque
     *                       post: se resta el valor de 'salud' a partir del 'danioRecibido'. Se reinicia el 'contadorDeAtaques'.
     */
    @Override
    public void recibirAtaque(int ataqueEnemigo) {
    	super.recibirAtaque(ataqueEnemigo);
    	concentrado = 0;
    }

    /**
     * post: La unidad descansa, haciendo que sus proximos tres ataques sean criticos
     */
    @Override
    public void descansar() {
    	concentrado = 3;
    }
}


