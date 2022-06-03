package tpe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	String csvFile;
	String line = "";
	String cvsSplitBy = ",";
	String generosSplitBy = " ";
	Library biblioteca;

	public CSVReader(String path) {
		this.csvFile = path;
		this.biblioteca = new Library();
	}

	public Library obtenerBiblioteca() {

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);

				String titulo = items[0];
				String autor = items[1];
				Integer paginas = Integer.parseInt(items[2]);
				String grupoGeneros = items[3];
				String[] generos = grupoGeneros.split(generosSplitBy);

				Book b = new Book(titulo, autor, paginas, generos);
				biblioteca.agregarLibro(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return biblioteca;
	}

}