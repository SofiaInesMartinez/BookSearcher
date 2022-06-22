package tpe2;

import java.util.ArrayList;
import java.util.HashSet;

public class SecuenciaAltoValor {

	private GrafoDirigido grafo;
	private HashSet<String> usados;

	public SecuenciaAltoValor(GrafoDirigido grafo) {
		this.grafo = grafo;
		this.usados = new HashSet<>();
	}

	public ArrayList<String> obtenerSecuencia(String verticeId) {
		ArrayList<String> secuencia = new ArrayList<>();
		while (verticeId != null && !usados.contains(verticeId)) {
			usados.add(verticeId);
			String ady = seleccionar(verticeId);
			secuencia.add(ady);
			verticeId = ady;
		}
		secuencia.remove(secuencia.size() - 1); // Agregué este parche para que no incluya el primer genero q se repite,
												// sino hay que hacer if cada vez antes de agregar al array resultado
		return secuencia;
	}

	private String seleccionar(String verticeId) { // Elegimos como siguiente género (candidato) el adyacente con mayor
													// arco.
		ArrayList<Arco> arcos = grafo.obtenerArcos(verticeId);
		int verticeMayorArco = 0;
		String candidato = null;
		for (int i = 0; i < arcos.size(); i++) {
			if (arcos.get(i).getEtiqueta() > verticeMayorArco) {
				verticeMayorArco = arcos.get(i).getEtiqueta();
				candidato = arcos.get(i).getVerticeDestino();
			}
		}
		return candidato;
	}

}
