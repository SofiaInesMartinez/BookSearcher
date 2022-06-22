package tpe2;

public class Main {

	public static void main(String[] args) {

		String dataset1 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\Datasets2daEtapa\\dataset1.csv");

		GrafoDirigido grafo1 = crearGrafo(dataset1);
		System.out.println(grafo1);

		GenerosMasBuscadosDesdeA top = new GenerosMasBuscadosDesdeA(grafo1);
		System.out.println("Los 6 géneros más buscados luego de investigación " + top.obtenerAdyacentesTop("investigación", 6)); // Revisar tema caracteres especiales
		
		SecuenciaAltoValor s = new SecuenciaAltoValor(grafo1);
		System.out.println("Secuencia de mayor valor a partir de investigación " + s.obtenerSecuencia("investigación"));

	}

	public static GrafoDirigido crearGrafo(String ruta) {
		CSVReader2 entrada = new CSVReader2(ruta);
		GrafoDirigido g = entrada.obtenerGrafo();
		return g;
	}
}
