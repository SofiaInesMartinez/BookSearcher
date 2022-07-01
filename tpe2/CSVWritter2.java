package tpe2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;



public class CSVWritter2 {
	public void generarSalida(GrafoDirigido grafo, String rutaSalida) {

		BufferedWriter bw = null;
		try {
			File file = new File(rutaSalida);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			Iterator<Arco> it = grafo.obtenerArcos();

			while (it.hasNext()) {
				// Escribo cada linea del archivo salida
				String contenidoLinea1 = it.next().toString();
				bw.write(contenidoLinea1);
				bw.newLine();
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
