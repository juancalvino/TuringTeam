package iO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import combatientes.ejercito.Ejercito;
import combatientes.guerrero.Guerrero;
import escenario.Camino;


public class CargaDeArchivos {
	
	Decodificador decodificador;
	
	public CargaDeArchivos() {
		this.decodificador =  new Decodificador();
	}
	
	
	public int cargarArchivo(String pArchivo) {

		FileReader archivo = null;
		BufferedReader lector = null;

		try {
			archivo = new FileReader(pArchivo);
			lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
				try {
					//TODO separar datos con split();
					//TODO armar metodo que determine como vamos a usar el dato
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null)
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}

	
	
}
