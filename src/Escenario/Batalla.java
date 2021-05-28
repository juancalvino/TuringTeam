package Escenario;

public class Batalla {

    private Pueblo numeroUno;
    private Pueblo numeroDos;

    public Batalla(Pueblo algo, Pueblo otro) {
        this.numeroDos = otro;
        this.numeroUno = algo;
    }

    public Pueblo calcularBatalla() {
        while (numeroUno.getCantidad() > 0 && numeroDos.getCantidad() > 0) {
            numeroUno.pelear(numeroDos);
            if (numeroDos.getRaza().getSalud() <= 0) {
                numeroDos.desmayarUno();
                if (numeroDos.getCantidad() == 0) {
                    return numeroUno;
                }
            }
            numeroDos.pelear(numeroUno);
            if (numeroUno.getRaza().getSalud() <= 0) {
                numeroUno.desmayarUno();
                if (numeroUno.getCantidad() == 0) {
                    return numeroDos;
                }
            }
        }
        return null;
    }
}
