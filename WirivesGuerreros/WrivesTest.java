package WirivesGuerreros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class WrivesTest {

	Wrives guerreroWrives =  new Wrives(20);
	GuerreroRandom enemigo;

	// Crear un guerrero Wrives
	@Test
	public void prueba001() {   
		new Wrives(20);
	}
	

	/*
	 * Verificar valores nominales
	 * Salud Inicial = 108
	 * Danio Basico = 113
	 */
	@Test
	public void prueba002() {   	
		assertEquals(113, guerreroWrives.atacar());	
		assertEquals(108, guerreroWrives.getSalud());
	}

	/*
	 * Verificar forma de ataque
	 * Hace 2 veces su danio cada 2 turnos 
	 */	
	@Test
	public void prueba03() {
		assertEquals(113, guerreroWrives.atacar());	
		assertEquals(226, guerreroWrives.atacar());			
		assertEquals(113, guerreroWrives.atacar());	
		assertEquals(226, guerreroWrives.atacar());			
	}

	/*
	 * Verificar recibir ataque
	 * Recibir el ataque por 2
	 */	
	@Test
	public void prueba04() {
		enemigo = new GuerreroRandom(2,100, 100);
		enemigo.atacar(guerreroWrives);
		assertEquals(8, guerreroWrives.getSalud());			
	}	
	
	/*
	 * Verificar descansar
	 */	
	@Test
	public void prueba05() {
	enemigo = new GuerreroRandom(2,113, 108);

	assertEquals(108, guerreroWrives.getSalud());	

	// guerreroWrives su salud en 50
	guerreroWrives.descansar();
	assertEquals(158, guerreroWrives.getSalud());
	
	//guerreroWrives no le quita vida al enemigo
	guerreroWrives.atacar(enemigo);
	assertEquals(113, enemigo.getSalud());	

	//guerreroWrives se pone activo para atacar
	enemigo.atacar(guerreroWrives);
	assertEquals(50, guerreroWrives.getSalud());		

	//guerreroWrives ataca al enemigo
	guerreroWrives.atacar(enemigo);
	assertEquals(0, enemigo.getSalud());	
	}	
	
}
