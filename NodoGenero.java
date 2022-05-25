package tpe;

import java.util.ArrayList;

public class NodoGenero {

	private NodoGenero hijoder;
	private NodoGenero hijoizq;
	private String genero;
	private ArrayList<Book> libros; //Ver si el array es de libros o de string de titulos

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
		return genero + " ";
	}

	public ArrayList<Book> getLibros() {
		return libros;
	}

	public void agregarLibro(Book b) { //Se puede agregar control de que el libro no esté ya cargado
		this.libros.add(b);
	}

}
