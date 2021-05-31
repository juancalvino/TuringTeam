package guerreros;

public class Radaiteran extends Guerrero {

    private int contadorDeAtaques;

    public Radaiteran() {
        this.salud = 36;
        this.danioBasico = 56;
        this.contadorDeAtaques = 0;
    }

    @Override
    public int atacar() {
        return super.atacar() + getDanioExtraPorAtaques();
    }

    @Override
    public void atacar(Guerrero enemigo) {
        super.atacar(enemigo);
    }

    private int getDanioExtraPorAtaques() {
        return this.contadorDeAtaques++ * 3;
    }
}
