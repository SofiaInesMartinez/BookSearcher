package tpe2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GrafoGenerosVinculados {
	private GrafoDirigido grafo;
	private HashSet<Arco> visitados;
	private HashSet<String> afines;
	private GrafoDirigido solucion;
	private String origen;
	
	public GrafoGenerosVinculados(GrafoDirigido grafo) {
		super();
		this.grafo = grafo;
		this.visitados = new HashSet<>();
		this.afines = new HashSet<>();
		this.solucion = null;
		this.origen = "";
	}
	
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public GrafoDirigido getGenerosVinculados(String origen) {
		visitados.clear();
		afines.clear();
		this.setOrigen(origen);
		solucion = vinculados_visit(origen);
		return solucion;
	}
	
	private GrafoDirigido vinculados_visit(String vertice) {
		ArrayList<Arco> arcos = grafo.obtenerArcos(vertice);
		ArrayList<Arco> aux = new ArrayList<Arco>();
		int i = 0;
		while (i < arcos.size()) {
			visitados.add(arcos.get(i));
			String adyacente = arcos.get(i).getVerticeDestino();
			vinculados_visit(adyacente);
			if (adyacente.equals(origen)) {
				aux.add(grafo.obtenerArco(vertice, adyacente));
			}
			if(colores.get(adyacente).equals("blanco")) {
				encontre = dfs_visit2(adyacente); 
				
				if(encontre) {
					//System.out.println(vertice);
					System.out.println(adyacente);
				}
			}else if(colores.get(adyacente).equals("amarillo")) {
				System.out.println(adyacente);
				encontre = true;
			}
			i++;
		}
		//System.out.println(vertice);
		colores.put(vertice, "negro");
		
		return new GrafoDirigido();
	}
}
