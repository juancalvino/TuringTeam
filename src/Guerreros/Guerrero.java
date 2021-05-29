package Guerreros;

public abstract class Guerrero {
    // TODO: 29/5/2021 Implementar el sistema de prioridad para las colas.

    protected int salud, danioBasico;

    public Guerrero() {
    }

    public int getSalud() {
        return this.salud;
    }

    public int getDanioBasico() {
        return this.danioBasico;
    }

    public void descansar() {
    }

    public int atacar() {
        return danioBasico;
    }

    public void atacar(Guerrero enemigo) {
        enemigo.recibirAtaque(this.atacar());
    }

    public void recibirAtaque(int ataqueEnemigo) {
        salud -= ataqueEnemigo;
    }
}

