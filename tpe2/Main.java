package tpe2;

public class Main {

	public static void main(String[] args) {

		String dataset1 = new String("C:\\Users\\maxi_\\Documents\\Sofi\\PROGRAMACION_3\\TPE\\dataset1.csv");
		String dataset2 = new String("C:\\Users\\maxi_\\Documents\\Sofi\\PROGRAMACION_3\\TPE\\dataset2.csv");
		String dataset3 = new String("C:\\Users\\maxi_\\Documents\\Sofi\\PROGRAMACION_3\\TPE\\dataset3.csv");

		String dataset4 = new String("C:\\Users\\maxi_\\Documents\\Sofi\\PROGRAMACION_3\\TPE\\dataset4.csv");

		GrafoDirigido grafo1 = crearGrafo(dataset1);
		GrafoDirigido grafo2 = crearGrafo(dataset2);
		GrafoDirigido grafo3 = crearGrafo(dataset3);
		GrafoDirigido grafo5 = crearGrafo(dataset4);
		System.out.println(grafo1);

		GenerosMasBuscadosDesdeA top = new GenerosMasBuscadosDesdeA(grafo1);
		System.out.println(
				"Los 6 géneros más buscados luego de investigación " + top.obtenerAdyacentesTop("investigación", 6));

		SecuenciaAltoValor s = new SecuenciaAltoValor(grafo1);
		System.out.println("Secuencia de mayor valor a partir de investigación " + s.obtenerSecuencia("investigación"));

		GrafoDirigido grafo4 = new GrafoDirigido();
		grafo4.agregarVertice("A");
		grafo4.agregarVertice("B");
		grafo4.agregarVertice("C");
		grafo4.agregarVertice("D");
		grafo4.agregarVertice("E");
		grafo4.agregarVertice("F");
		grafo4.agregarVertice("G");
		grafo4.agregarArco("A", "B");
		grafo4.agregarArco("A", "G");
		grafo4.agregarArco("B", "E");
		grafo4.agregarArco("B", "F");
		grafo4.agregarArco("B", "C");
		grafo4.agregarArco("C", "D");
		grafo4.agregarArco("D", "B");
		grafo4.agregarArco("E", "A");

		GrafoGenerosVinculados vinculados = new GrafoGenerosVinculados(grafo5);
		System.out.println("solucion " + vinculados.getGenerosVinculados("investigación"));
		

	}

	public static GrafoDirigido crearGrafo(String ruta) {
		CSVReader2 entrada = new CSVReader2(ruta);
		GrafoDirigido g = entrada.obtenerGrafo();
		return g;
	}
}
