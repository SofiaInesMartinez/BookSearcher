package tpe2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSVReader2 {

	String csvFile;
	String line = "";
	String cvsSplitBy = ",";
	GrafoDirigido grafo;

	public CSVReader2(String path) {
		this.csvFile = path;
		this.grafo = new GrafoDirigido();
	}

	public GrafoDirigido obtenerGrafo() {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"))) {
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] nodos = line.split(cvsSplitBy);


				for (int i = 0; i < nodos.length; i++) {
					if (!grafo.contieneVertice(nodos[i])) {
						grafo.agregarVertice(nodos[i]);
					}
				}

				for (int i = 0; i < nodos.length-1; i++) {
					grafo.agregarArco(nodos[i], nodos[i + 1]);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grafo;
	}

}