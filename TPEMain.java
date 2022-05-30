package tpe;

public class TPEMain {

	public static void main(String[] args) {
		CSVReader entrada = new CSVReader("C:\\Users\\Rodríguez\\Downloads\\dataset1.csv");
		
		Library biblioteca = entrada.obtenerBiblioteca();

		Index indice = new Index(biblioteca);
		
		indice.crearIndice().printInOrder();
		
		//NodoGenero resultado = indice.busquedaPorGenero("cine");

		//CSVWritter salida = new CSVWritter();

		//salida.generarSalida(resultado);

	}

}
