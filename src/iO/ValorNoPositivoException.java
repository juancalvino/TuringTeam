package iO;

public class ValorNoPositivoException extends Exception {
    ValorNoPositivoException() {
        super("El valor numérico ingresado debe ser mayor a 0.");
    }
}
