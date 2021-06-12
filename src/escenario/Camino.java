package escenario;

public class Camino {
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
}
