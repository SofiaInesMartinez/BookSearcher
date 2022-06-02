package tpe;

import ejer6.timer;

public class TPEMain {

	public static void main(String[] args) {
		
		String dataset1 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset1.csv");
		String dataset2 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset2.csv");
		String dataset3 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset3.csv");
		String dataset4 = new String("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset4.csv");
		
//		System.out.println("Tiempo ejecucion con dataset1: " + calcularTiempoConDataset(dataset1));
//		System.out.println("Tiempo ejecucion con dataset2: " + calcularTiempoConDataset(dataset2));
//		System.out.println("Tiempo ejecucion con dataset3: " + calcularTiempoConDataset(dataset3));
//		System.out.println("Tiempo ejecucion con dataset4: " + calcularTiempoConDataset(dataset4));

		
		CSVReader entrada = new CSVReader(dataset2);

		Library biblioteca = entrada.obtenerBiblioteca();

		Index indice = new Index(biblioteca);
		indice.crearIndice();
		
		System.out.println("Tiempo de búsqueda " + calcularTiempoConDataset(indice, "ciencia"));
		
		System.out.println("Altura del árbol de búsqueda " + indice.getHeight());
		
	}

	public static double calcularTiempoConDataset(Index indice, String genero) {
		timer t = new timer();
		t.start();

		NodoGenero resultado = indice.busquedaPorGenero(genero);

		double tiempo = t.stop();
		
		CSVWritter salida = new CSVWritter();
		salida.generarSalida(resultado);

		return tiempo;
	}
}
