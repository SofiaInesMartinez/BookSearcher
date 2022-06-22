package tpe2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GrafoDirigido {

	private HashMap<String, ArrayList<Arco>> grafo;

	public GrafoDirigido() {
		this.grafo = new HashMap<String, ArrayList<Arco>>();
	}

	public void agregarVertice(String verticeId) {
		this.grafo.put(verticeId, new ArrayList<>());
	}

	public void borrarVertice(String verticeId) {
		this.grafo.remove(verticeId);
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

	public void borrarArco(String verticeId1, String verticeId2) {
		int i = 0;
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco> arcos = grafo.get(verticeId1);
			boolean encontre = false;
			while (i < arcos.size() && encontre == false) {
				if (arcos.get(i).getVerticeDestino().equals(verticeId2)) {
					arcos.remove(i);
					encontre = true;
				}
				i++;
			}
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

	public int cantidadVertices() {
		return grafo.size();
	}

	public int cantidadArcos() {
		int contador = 0;
		for (String v : grafo.keySet()) {
			contador += grafo.get(v).size();
		}
		return contador;
	}

	public Iterator<String> obtenerVertices() {
		Set<String> vertices = grafo.keySet();
		return vertices.iterator();
	}

	public Iterator<String> obtenerAdyacentes(String verticeId) {
		ArrayList<Arco> arcos = grafo.get(verticeId);
		ArrayList<String> adyacentes = new ArrayList<>();
		for (Arco a : arcos) {
			adyacentes.add(a.getVerticeDestino());
		}
		return adyacentes.iterator();
	}

//	public ArrayList<String> obtenerAdyacentesTop(String verticeId, int ranking) {
//		ArrayList<Arco> arcos = grafo.get(verticeId);
//		ArrayList<String> adyacentes = new ArrayList<>();
//		if (arcos.size() >= ranking) {
//			Collections.sort(arcos);
//			for (int i = 0; i <= ranking - 1; i++) {
//				adyacentes.add(arcos.get(i).getVerticeDestino());
//			}
//		}
//		return adyacentes;
//	}

	public Iterator<Arco> obtenerArcos() {
		ArrayList<Arco> arcos = new ArrayList<>();
		for (String v : grafo.keySet()) {
			arcos.addAll(grafo.get(v));
		}
		return arcos.iterator();
	}

	public Iterator<Arco> obtenerArcosIt(String verticeId) {
		ArrayList<Arco> arcos = grafo.get(verticeId);
		return arcos.iterator();
	}
	
	
	public ArrayList<Arco> obtenerArcos(String verticeId) {
		ArrayList<Arco> arcos = grafo.get(verticeId);
		return arcos;
	}

	@Override
	public String toString() {
		return "GrafoDirigido [grafo=" + grafo + "]";
	}

}