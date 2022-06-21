package tpe1;

import java.util.ArrayList;

public class NodoGenero {

	private NodoGenero hijoder;
	private NodoGenero hijoizq;
	private String genero;
	private ArrayList<String> libros;

	public NodoGenero(String genero) {
		this.hijoder = null;
		this.hijoizq = null;
		this.genero = genero;
		this.libros = new ArrayList<>();
	}

	public NodoGenero getHijoder() {
		return hijoder;
	}

	public void setHijoder(NodoGenero hijoder) {
		this.hijoder = hijoder;
	}

	public NodoGenero getHijoizq() {
		return hijoizq;
	}

	public void setHijoizq(NodoGenero hijoizq) {
		this.hijoizq = hijoizq;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return (genero + " Libros: " + libros.toString());
	}

	public ArrayList<String> getLibros() {
		return libros;
	}

	public void agregarLibro(String titulo) { // Se puede agregar control de que el libro no esté ya cargado
		this.libros.add(titulo); // Ver complejidad
	}

}