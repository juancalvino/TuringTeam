package guerreros;

public abstract class Guerrero {
    // TODO: 29/5/2021 Implementar el sistema de prioridad para las colas.

    protected int salud;
    protected int danioBasico;

    
    public int getSalud() {
        return this.salud;
    }

    public void descansar() {
    }

    protected int atacar() {
        return this.danioBasico;
    }

    public void atacar(Guerrero enemigo) {
        enemigo.recibirAtaque(this.atacar());
    }

    protected void recibirAtaque(int ataqueEnemigo) {
        salud -= ataqueEnemigo;
    }
}

