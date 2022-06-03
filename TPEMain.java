package tpe;

public class TPEMain {

	public static void main(String[] args) {

		String dataset1 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset1.csv");
		String dataset2 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset2.csv");
		String dataset3 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset3.csv");
		String dataset4 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset4.csv");

		Index indice1 = crearIndice(dataset1);
		Index indice2 = crearIndice(dataset2);
		Index indice3 = crearIndice(dataset3);
		Index indice4 = crearIndice(dataset4);
		
		System.out.println("Tiempo ejecucion con dataset1: " + calcularTiempoConIndice(indice1));
		System.out.println("Tiempo ejecucion con dataset1: " + calcularTiempoConIndice(indice1));
		System.out.println("Tiempo ejecucion con dataset2: " + calcularTiempoConIndice(indice2));
		System.out.println("Tiempo ejecucion con dataset3: " + calcularTiempoConIndice(indice3));
		System.out.println("Tiempo ejecucion con dataset4: " + calcularTiempoConIndice(indice4));

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

	public void generarSalida(NodoGenero resultado) {
		CSVWritter salida = new CSVWritter();
		salida.generarSalida(resultado);
	}
}