package escenario;

import java.util.Objects;

public class Camino implements Comparable<Camino> {
    private final Pueblo puebloDestino;
    private final Integer recorridoEnDias;

    public Camino(Pueblo destino, int dias) {
        this.puebloDestino = destino;
        this.recorridoEnDias = dias;
    }

    /**
     * @return el pueblo hacia donde va el camino
     */
    public Pueblo getPuebloDestino() {
        return this.puebloDestino;
    }

    /**
     * @return el tiempo que se tarda en realizar el camino en dias.
     */
    public int getRecorridoEnDias() {
        return this.recorridoEnDias;
    }

    
    //TODO??
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camino camino = (Camino) o;
        return Objects.equals(getPuebloDestino(), camino.getPuebloDestino()) && Objects.equals(getRecorridoEnDias(), camino.getRecorridoEnDias());
    }

    /**
     * compara dos caminos para elegir aquel que sea mas corto en cantidad de dias.
     */
    @Override
    public int compareTo(Camino otroCamino) {
        return this.recorridoEnDias.compareTo(otroCamino.getRecorridoEnDias());
    }
}
