package tpe2;

public class Main {

	public static void main(String[] args) {

		String dataset1 = new String("C:\\Users\\maxi_\\Documents\\Sofi\\PROGRAMACION_3\\TPE\\dataset2.csv");

		GrafoDirigido grafo1 = crearGrafo(dataset1);
		System.out.println(grafo1);

		// System.out.println("Resultado" +
		// grafo1.obtenerAdyacentesTop("investigaci贸n", 9));

		GenerosMasBuscadosDesdeA top = new GenerosMasBuscadosDesdeA(grafo1);
		System.out.println("Los 6 g閚eros m醩 buscados luego de investigaci髇 " + top.obtenerAdyacentesTop("investigaci贸n", 6)); // Revisar tema caracteres especiales
		System.out.println(top.obtenerAdyacentesTop("psicolog铆a", 1));
		System.out.println(top.obtenerAdyacentesTop("ficci贸n", 1));
		System.out.println(top.obtenerAdyacentesTop("thriller", 1));
		System.out.println(top.obtenerAdyacentesTop("arte", 1));
		System.out.println(top.obtenerAdyacentesTop("ensayo", 1));
		System.out.println(top.obtenerAdyacentesTop("ciencia", 1));
		System.out.println(top.obtenerAdyacentesTop("negocios", 1));
		System.out.println(top.obtenerAdyacentesTop("romance", 1));
		System.out.println(top.obtenerAdyacentesTop("relatos", 1));
		
		SecuenciaAltoValor s = new SecuenciaAltoValor(grafo1);
		System.out.println("Secuencia de mayor valor a partir de investigaci髇 " + s.obtenerSecuencia("investigaci贸n"));

	}

	public static GrafoDirigido crearGrafo(String ruta) {
		CSVReader2 entrada = new CSVReader2(ruta);
		GrafoDirigido g = entrada.obtenerGrafo();
		return g;
	}
}
