package tpe;

import ejer6.timer;

public class TPEMain {

	public static void main(String[] args) {
		
		String dataset1 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset1.csv");
		String dataset2 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset2.csv");
		String dataset3 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset3.csv");
		String dataset4 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset4.csv");
		
		System.out.println("Tiempo ejecucion con dataset1: " + calcularTiempoConDataset(dataset1));
		System.out.println("Tiempo ejecucion con dataset2: " + calcularTiempoConDataset(dataset2));
		System.out.println("Tiempo ejecucion con dataset3: " + calcularTiempoConDataset(dataset3));
		System.out.println("Tiempo ejecucion con dataset4: " + calcularTiempoConDataset(dataset4));

	}

	public static double calcularTiempoConDataset(String ruta) {
		timer t = new timer();
		t.start();
		CSVReader entrada = new CSVReader(ruta);

		Library biblioteca = entrada.obtenerBiblioteca();

		Index indice = new Index(biblioteca);
		indice.crearIndice();

		NodoGenero resultado = indice.busquedaPorGenero("cine");

		CSVWritter salida = new CSVWritter();

		salida.generarSalida(resultado);

		return t.stop();
	}
}
