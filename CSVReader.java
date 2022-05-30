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

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);

				String titulo = items[0];
				String autor = items[1];
				String paginasStr = items[2];
				// Integer paginas = Integer.valueOf(paginasStr); //Ver porque no deja parsear
				// el string a int

				String grupoGeneros = items[3];
				String[] generos = grupoGeneros.split(generosSplitBy);

				Book b = new Book(titulo, autor, paginasStr, generos);
				biblioteca.agregarLibro(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return biblioteca;

	}

}