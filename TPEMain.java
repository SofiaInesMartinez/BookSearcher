package tpe;

public class TPEMain {

	public static void main(String[] args) {

		String dataset1 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset1.csv");
		String dataset2 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset2.csv");
		String dataset3 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset3.csv");
		String dataset4 = new String("C:\\Users\\Rodríguez\\OneDrive\\Documentos\\TUDAI\\ProgIII\\Trabajo\\dataset4.csv");
		
		Index indice1 = crearIndice(dataset1);
		Index indice2 = crearIndice(dataset2);
		Index indice3 = crearIndice(dataset3);
		Index indice4 = crearIndice(dataset4);
		System.out.println("Tiempo ejecucion con dataset1: " + calcularTiempoConDataset(indice1));
		System.out.println("Tiempo ejecucion con dataset2: " + calcularTiempoConDataset(indice2));
		System.out.println("Tiempo ejecucion con dataset3: " + calcularTiempoConDataset(indice3));
		System.out.println("Tiempo ejecucion con dataset4: " + calcularTiempoConDataset(indice4));

	}
	public static Index crearIndice(String ruta) {
		CSVReader entrada = new CSVReader(ruta);

		Library biblioteca = entrada.obtenerBiblioteca();

		Index indice = new Index(biblioteca);

		indice.crearIndice();
		
		return indice;
	}
	public static double calcularTiempoConDataset(Index indice) {
		Timer t = new Timer();
		t.start();

		NodoGenero resultado = indice.busquedaPorGenero("humor");

		//CSVWritter salida = new CSVWritter();
		CSVWritter salida = new CSVWritter();

		salida.generarSalida(resultado);

		//salida.generarSalida(resultado);
		return t.stop();
	}
}
