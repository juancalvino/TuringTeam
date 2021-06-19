package escenario;

import java.util.Objects;

public class Camino implements Comparable<Camino> {
    private final Pueblo puebloDestino;
    private final Integer recorridoEnDias;

    public Camino(Pueblo destino, int dias) {
        this.puebloDestino = destino;
        this.recorridoEnDias = dias;
    }

    public Pueblo getPuebloDestino() {
        return this.puebloDestino;
    }

    public int getRecorridoEnDias() {
        return this.recorridoEnDias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camino camino = (Camino) o;
        return Objects.equals(getPuebloDestino(), camino.getPuebloDestino()) && Objects.equals(getRecorridoEnDias(), camino.getRecorridoEnDias());
    }

    @Override
    public int compareTo(Camino otroCamino) {
        return this.recorridoEnDias.compareTo(otroCamino.getRecorridoEnDias());
    }
}
