package escenario;

import java.util.HashMap;
import java.util.Stack;

public class Hechicero {

	HashMap<String, Pueblo> vertices = Escenario.getInstance().getMapaDePueblos();

	public HashMap<String, String> dfs(String inicio) {
		HashMap<String, String> predecesores = new HashMap<String, String>();
		Stack<String> pila = new Stack<>();
		for (String vertice : vertices.keySet()) {
			predecesores.put(vertice, null);
		}
		pila.push(inicio);
		while (!pila.isEmpty()) {
			String vertice = pila.pop();
			for (String verticeAdyacente : vertices.get(vertice).getCaminosAdyacentes().keySet()) {
				if (predecesores.get(verticeAdyacente) == null && !verticeAdyacente.equals(inicio)) {
					predecesores.put(verticeAdyacente, vertice);
					pila.push(verticeAdyacente);
				}
			}
		}
		return predecesores;
	}
}
