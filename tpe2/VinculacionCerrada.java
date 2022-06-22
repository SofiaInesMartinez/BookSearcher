package tpe2;

import java.util.ArrayList;
import java.util.Iterator;

public class VinculacionCerrada {
	private GrafoDirigido grafo;
	private Estado estado;
	private ArrayList<ArrayList<String>> solucion;
	
	public VinculacionCerrada(GrafoDirigido grafo) {
		super();
		this.grafo = grafo;
		this.estado = new Estado();
		this.solucion = new ArrayList<ArrayList<String>>();
	}

	public ArrayList<ArrayList<String>> getVinculaciones(String generoInicio) {
		estado.setGeneroInicio(generoInicio);
		estado.add(generoInicio);
		return getVinculaciones(estado);
	}
	
	private ArrayList<ArrayList<String>> getVinculaciones(Estado e) {
		if ((e.getUltimo() == e.getGeneroInicio())&&(e.getSolucionParcial().size() > 1)){ 
			solucion.add(e.getSolucionParcial());
			e.getSolucionParcial().clear();
		}
		else {
			Iterator<String> it1 = grafo.obtenerAdyacentes(e.getUltimo());
			while (it1.hasNext()) {
				String adyacente = it1.next();
				e.getSolucionParcial().add(adyacente);
				getVinculaciones(e);
				e.getSolucionParcial().remove(adyacente);
			}
		}
		return solucion;
	}
	
}