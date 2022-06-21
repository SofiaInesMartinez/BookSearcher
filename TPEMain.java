package tpe;

public class TPEMain {

	public static void main(String[] args) {

		String dataset1 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset1.csv");
		//String dataset2 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset2.csv");
		//String dataset3 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset3.csv");
		//String dataset4 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset4.csv");

		Index indice1 = crearIndice(dataset1);
		//Index indice2 = crearIndice(dataset2);
		//Index indice3 = crearIndice(dataset3);
		//Index indice4 = crearIndice(dataset4);
		
		/*System.out.println("Tiempo ejecucion con dataset1: " + calcularTiempoConDataset(indice1));
		System.out.println("Tiempo ejecucion con dataset1: " + calcularTiempoConDataset(indice1));
		System.out.println("Tiempo ejecucion con dataset2: " + calcularTiempoConDataset(indice2));
		System.out.println("Tiempo ejecucion con dataset3: " + calcularTiempoConDataset(indice3));
		System.out.println("Tiempo ejecucion con dataset4: " + calcularTiempoConDataset(indice4));*/
		
		generarSalida(indice1.busquedaPorGenero("thriller"));
	}

	public static Index crearIndice(String ruta) {
		CSVReader entrada = new CSVReader(ruta);
		Library biblioteca = entrada.obtenerBiblioteca();
		Index indice = new Index(biblioteca);
		indice.crearIndice();
		return indice;
	}

	public static double calcularTiempoConIndice(Index indice) {
		Timer t = new Timer();
		t.start();
		indice.busquedaPorGenero("humor");
		return t.stop();
	}

	public static void generarSalida(NodoGenero resultado) {
		CSVWritter salida = new CSVWritter();
		String rutaSalida = "C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\salida.csv";
		salida.generarSalida(resultado, rutaSalida);
	}
}