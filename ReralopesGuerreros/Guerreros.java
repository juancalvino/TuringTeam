public abstract class Guerreros {

    protected int salud;
    protected int danio;

    public int getSalud() {
        return this.salud;
    }

    public int getDanio() {
        return this.danio;
    }

    public abstract int atacar();

    public abstract void recibirAtaque(int danioRecibido);

    public abstract void descansar();

}
