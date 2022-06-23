package tpe2;

public class Main {

	public static void main(String[] args) {

		String dataset2 = new String("C:\\Users\\Rodr�guez\\OneDrive\\Documentos\\TUDAI\\Datasets2daEtapa\\dataset2.csv");

		GrafoDirigido grafo1 = crearGrafo(dataset2);
		System.out.println(grafo1);

		GenerosMasBuscadosDesdeA top = new GenerosMasBuscadosDesdeA(grafo1);
		System.out.println("Los 6 g�neros m�s buscados luego de investigaci�n " + top.obtenerAdyacentesTop("investigaci�n", 6));
		
		SecuenciaAltoValor s = new SecuenciaAltoValor(grafo1);
		System.out.println("Secuencia de mayor valor a partir de investigaci�n " + s.obtenerSecuencia("investigaci�n"));
		
		GrafoDirigido grafo2 = new GrafoDirigido();
		grafo2.agregarVertice("A");
		grafo2.agregarVertice("B");
		grafo2.agregarVertice("C");
		grafo2.agregarVertice("D");
		grafo2.agregarVertice("E");
		grafo2.agregarVertice("F");
		grafo2.agregarVertice("G");
		grafo2.agregarArco("A", "B");
		grafo2.agregarArco("A", "G");
		grafo2.agregarArco("B", "E");
		grafo2.agregarArco("B", "F");
		grafo2.agregarArco("B", "C");
		grafo2.agregarArco("C", "D");
		grafo2.agregarArco("D", "B");
		grafo2.agregarArco("E", "A");
		GrafoGenerosVinculados grafo3 = new GrafoGenerosVinculados(grafo2);
		System.out.println("Vinculaciones cerradas de investigaci�n " + grafo3.getGenerosVinculados("investigaci�n"));
	}

	public static GrafoDirigido crearGrafo(String ruta) {
		CSVReader2 entrada = new CSVReader2(ruta);
		GrafoDirigido g = entrada.obtenerGrafo();
		return g;
	}
}
