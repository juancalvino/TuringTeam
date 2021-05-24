public class Reralopes extends Guerreros {
    private int contadorDeAtaques = 0;
    private int contadorDeAtaquesCriticos = 0;

    Reralopes() {
        establecerValoresIniciales();
    }

    private void establecerValoresIniciales() {
        this.salud = 53;
        this.danio = 27;
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
        int danioAtaque = erraElAtaque() ? 0 : this.danio;

        return danioAtaque * ataqueEsCritico();
    }

    /**
     * @param danioRecibido: valor entero que indica el valor del danio recibido de un ataque
     *                       post: se resta el valor de 'salud' a partir del 'danioRecibido'. Se reinicia el 'contadorDeAtaques'.
     */
    @Override
    public void recibirAtaque(int danioRecibido) {
        contadorDeAtaques = 0;
        this.salud -= danioRecibido;
    }

    /**
     * post: La unidad descansa, haciendo que sus proximos tres ataques sean criticos
     */
    @Override
    public void descansar() {
        contadorDeAtaquesCriticos = 3;
    }


    /**
     * @return Si el 'contadorDeAtaques' vale 2 o 3, devuelve TRUE, sino, devuelve FALSE
     */
    private boolean erraElAtaque() {
        if (contadorDeAtaques > 3) {
            contadorDeAtaques = 0;
        }
        return contadorDeAtaques++ > 1;
    }

    /**
     * @return Si tiene ataques criticos disponibles, devuelve 2, sino, devuelve 1
     */
    private int ataqueEsCritico() {
        return contadorDeAtaquesCriticos-- > 0 ? 2 : 1;
    }
}
