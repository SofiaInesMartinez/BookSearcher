package tpe2;

import java.util.ArrayList;
import java.util.Collections;

public class GenerosMasBuscadosDesdeA {
	private GrafoDirigido grafo;

	public GenerosMasBuscadosDesdeA(GrafoDirigido grafo) {
		this.grafo = grafo;
	}

	public ArrayList<String> obtenerAdyacentesTop(String verticeId, int ranking) {
		ArrayList<Arco> arcos = grafo.obtenerArcos(verticeId);	
		ArrayList<String> adyacentes = new ArrayList<>();
		if (arcos.size() >= ranking) {
			Collections.sort(arcos);
			for (int i = 0; i <= ranking - 1; i++) {
				adyacentes.add(arcos.get(i).getVerticeDestino());
			}
		}
		return adyacentes;
	}

}
