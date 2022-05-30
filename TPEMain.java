package tpe;

public class TPEMain {

	public static void main(String[] args) {
		CSVReader entrada = new CSVReader("C:/Users/maxi_/Documents/Sofi/PROGRAMACION_3/TPE/dataset3.csv");

		Library biblioteca = entrada.obtenerBiblioteca();

		Index indice = new Index(biblioteca);

		indice.crearIndice();

		NodoGenero resultado = indice.busquedaPorGenero("cine");
		
		System.out.println(resultado);

		//CSVWritter salida = new CSVWritter();

		//salida.generarSalida(resultado);
	}
}
