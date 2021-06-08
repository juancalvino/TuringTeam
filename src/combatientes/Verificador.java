package combatientes;

public class Verificador {

	protected static int dePositividad(int numero) throws NegativeNumberException {
		if(numero < 0) {
			throw new NegativeNumberException();
		}
		
		return numero;
	}
	
}
