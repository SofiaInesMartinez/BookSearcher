package tpe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {

	public void generarSalida(NodoGenero nodo) {

		BufferedWriter bw = null;
		try {
			File file = new File("C:/Users/maxi_/Documents/Sofi/PROGRAMACION 3/TPE/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			ArrayList<String> resultado = nodo.getLibros();

			int i = 0;
			while (i < resultado.size()) {
				// Escribo cada linea del archivo salida
				String contenidoLinea1 = resultado.get(i).toString();
				bw.write(contenidoLinea1);
				bw.newLine();
				i++;
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}