package tpe2;

public class Main {

	public static void main(String[] args) {

		String dataset1 = new String("C:\\Users\\maxi_\\Documents\\Sofi\\PROGRAMACION_3\\TPE\\dataset2.csv");

		GrafoDirigido grafo1 = crearGrafo(dataset1);
		System.out.println(grafo1);

		//System.out.println("Resultado" + grafo1.obtenerAdyacentesTop("investigación", 9));
		
		
		GenerosMasBuscadosDesdeA top = new GenerosMasBuscadosDesdeA(grafo1);
		System.out.println(top.obtenerAdyacentesTop("investigación", 9));


	}

	public static GrafoDirigido crearGrafo(String ruta) {
		CSVReader2 entrada = new CSVReader2(ruta);
		GrafoDirigido g = entrada.obtenerGrafo();
		return g;
	}
}
