package tpe2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido {

	private HashMap<String, ArrayList<Arco>> grafo;

	public GrafoDirigido() {
		this.grafo = new HashMap<String, ArrayList<Arco>>();
	}

	public void agregarVertice(String verticeId) {
		this.grafo.put(verticeId, new ArrayList<>());
	}

	public void agregarArco(String verticeId1, String verticeId2) {
		if (!existeArco(verticeId1, verticeId2)) {
			if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
				Arco a = new Arco(verticeId1, verticeId2);
				a.setEtiqueta(1);
				this.grafo.get(verticeId1).add(a);
			}
		} else {
			Arco a = obtenerArco(verticeId1, verticeId2);
			a.setEtiqueta(a.getEtiqueta() + 1);
		}
	}


	public boolean contieneVertice(String verticeId) {
		return this.grafo.containsKey(verticeId);
	}

	public boolean existeArco(String verticeId1, String verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			ArrayList<Arco> arcos = grafo.get(verticeId1);
			for (Arco a : arcos) {
				if (a.getVerticeDestino().equals(verticeId2)) {
					return true;
				}
			}
		}
		return false;
	}

	public Arco obtenerArco(String verticeId1, String verticeId2) {
		if ((this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2))) {
			ArrayList<Arco> arcos = this.grafo.get(verticeId1);
			for (int i = 0; i < arcos.size(); i++) {
				if ((arcos.get(i).getVerticeOrigen().equals(verticeId1))
						&& (arcos.get(i).getVerticeDestino().equals(verticeId2)))
					return arcos.get(i);
			}
		}
		return null;
	}

	public Iterator<String> obtenerAdyacentes(String verticeId) {
		ArrayList<Arco> arcos = grafo.get(verticeId);
		ArrayList<String> adyacentes = new ArrayList<>();
		for (Arco a : arcos) {
			adyacentes.add(a.getVerticeDestino());
		}
		return adyacentes.iterator();
	}

	public ArrayList<Arco> obtenerArcos(String verticeId) {
		return grafo.get(verticeId);
	}

	public Iterator<Arco> obtenerArcosIt(String verticeId) {
		return grafo.get(verticeId).iterator();
	}

	@Override
	public String toString() {
		return "GrafoDirigido [grafoDirigido = " + grafo + "]";
	}

}