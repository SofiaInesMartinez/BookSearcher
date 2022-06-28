package tpe2;

public class Main {

	public static void main(String[] args) {

		String dataset1 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\Datasets2daEtapa\\dataset1.csv");
		String dataset2 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\Datasets2daEtapa\\dataset2.csv");
		String dataset3 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\Datasets2daEtapa\\dataset3.csv");
		String dataset4 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\Datasets2daEtapa\\dataset4.csv");

		GrafoDirigido grafo1 = crearGrafo(dataset1);
		GrafoDirigido grafo2 = crearGrafo(dataset2);
		GrafoDirigido grafo3 = crearGrafo(dataset3);
		GrafoDirigido grafo4 = crearGrafo(dataset4);
		System.out.println(grafo1);

		GenerosMasBuscadosDesdeA top = new GenerosMasBuscadosDesdeA(grafo1);
		System.out.println(
				"Los 6 géneros más buscados luego de investigación " + top.obtenerAdyacentesTop("investigación", 6));

		SecuenciaAltoValor s = new SecuenciaAltoValor(grafo1);
		System.out.println("Secuencia de mayor valor a partir de investigación " + s.obtenerSecuencia("investigación"));

		GrafoDirigido grafo5 = new GrafoDirigido();
		grafo5.agregarVertice("A");
		grafo5.agregarVertice("B");
		grafo5.agregarVertice("C");
		grafo5.agregarVertice("D");
		grafo5.agregarVertice("E");
		grafo5.agregarVertice("F");
		grafo5.agregarVertice("G");
		grafo5.agregarArco("A", "B");
		grafo5.agregarArco("A", "G");
		grafo5.agregarArco("B", "E");
		grafo5.agregarArco("B", "F");
		grafo5.agregarArco("B", "C");
		grafo5.agregarArco("C", "D");
		grafo5.agregarArco("D", "B");
		grafo5.agregarArco("E", "A");

		GrafoGenerosVinculados vinculados = new GrafoGenerosVinculados(grafo4);
		System.out.println("solucion " + vinculados.getGenerosVinculados("investigación"));
		

	}

	public static GrafoDirigido crearGrafo(String ruta) {
		CSVReader2 entrada = new CSVReader2(ruta);
		GrafoDirigido g = entrada.obtenerGrafo();
		return g;
	}
}
