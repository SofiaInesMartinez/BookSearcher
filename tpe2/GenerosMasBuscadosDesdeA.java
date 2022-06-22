package tpe2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GenerosMasBuscadosDesdeA {
	private GrafoDirigido grafo;

	public GenerosMasBuscadosDesdeA(GrafoDirigido grafo) {
		this.grafo = grafo;
	}

	public ArrayList<String> obtenerAdyacentesTop(String verticeId, int ranking) {
		Iterator<Arco> it = grafo.obtenerArcos(verticeId);
		ArrayList<Arco> arcos = new ArrayList<>();
		while (it.hasNext()) {
			Arco a = it.next();
			arcos.add(a);
		}		
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
