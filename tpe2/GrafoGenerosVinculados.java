package tpe2;

import java.util.ArrayList;
import java.util.HashSet;

public class GrafoGenerosVinculados {
	private GrafoDirigido grafo;
	private HashSet<Arco> visitados;
	private HashSet<String> afines;
	private GrafoDirigido solucion;

	public GrafoGenerosVinculados(GrafoDirigido grafo) {
		super();
		this.grafo = grafo;
		this.visitados = new HashSet<>();
		this.afines = new HashSet<>();
		this.solucion = new GrafoDirigido();
	}

	public GrafoDirigido getGenerosVinculados(String origen) {
		visitados.clear();
		afines.clear();
		ArrayList<Arco> arcos = grafo.obtenerArcos(origen); // recorremos desde los arcos que salen de origen
		ArrayList<Arco> camino = new ArrayList<>();
		int i = 0;
		if (arcos != null) {
			while (i < arcos.size()) {
				Arco arcoId = arcos.get(i);
				camino.add(arcoId);
				if (!visitados.contains(arcoId)) {
					vinculados_visit(arcoId, origen, camino);
				}
				i++;
			}
		}
		return solucion;

	}

	private void vinculados_visit(Arco arcoId, String destino, ArrayList<Arco> camino) {
		this.visitados.add(arcoId); // Si llega a un arco afin sabemos que llega a destino
		if (arcoId.getVerticeDestino().equals(destino) || afines.contains(arcoId.getVerticeDestino())) {
			ArrayList<Arco> nuevoCamino = new ArrayList<>();
			nuevoCamino.addAll(camino);
			agregarASolucion(nuevoCamino);
			for (Arco a : camino) {
				String vertice = a.getVerticeOrigen();
				afines.add(vertice);
			}
			camino.clear();
		} else {
			String vertice = arcoId.getVerticeDestino(); // levantamos el vertice al que apunta el arco
			if (!afines.contains(vertice)) { //Si el vertice es afin no lo recorremos para evitar
												// bucles.
				ArrayList<Arco> arcosSiguientes = grafo.obtenerArcos(vertice); // recorremos todos los arcos que salen
																				// de ese vertice
				int i = 0;
				while (i < arcosSiguientes.size()) {
					if (!this.visitados.contains(arcosSiguientes.get(i))) {
						camino.add(arcosSiguientes.get(i));
						vinculados_visit(arcosSiguientes.get(i), destino, camino);
						if (camino.size() > 0) {
							camino.remove(camino.size() - 1);
						}
					}
					i++;
				}
			}
		}
		visitados.remove(arcoId);
	}
	
	
	private void agregarASolucion(ArrayList<Arco> lista) {
		for(Arco a:lista) {
			String origen = a.getVerticeOrigen();
			String destino = a.getVerticeDestino();
			if(!solucion.contieneVertice(origen)){
				solucion.agregarVertice(origen);				
			}
			if(!solucion.contieneVertice(destino)){
				solucion.agregarVertice(destino);				
			}
			solucion.agregarArco(origen, destino);
		}
	}

}
