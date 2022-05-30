package tpe;

public class TPEMain {

	public static void main(String[] args) {
		CSVReader entrada = new CSVReader("C:/Users/maxi_/Documents/Sofi/PROGRAMACION 3/TPE/dataset1.csv");

		Library biblioteca = entrada.obtenerBiblioteca();

		Index indice = new Index(biblioteca);

		indice.crearIndice().printInOrder();

		NodoGenero resultado = indice.busquedaPorGenero("cine");
		
		System.out.println(resultado);

		CSVWritter salida = new CSVWritter();

		salida.generarSalida(resultado);
	}
}
