package tpe;

import java.util.Iterator;

public class Index {

	private Library biblioteca;
	private ArbolGenero arbol;

	public Index(Library biblioteca) {
		this.biblioteca = biblioteca;
		this.arbol = new ArbolGenero();
	}

	public void crearIndice() {
		Iterator<Book> it = biblioteca.getLibros();
		while (it.hasNext()) {
			Book b = it.next();
			String[] generos = b.getGeneros(); // Por cada libro, busca el nodo correspondiente a cada genero y agrega
												// ese libro.
			for (String genero : generos) {
				String t = b.getTitulo();
				arbol.buscarGeneroInterno(genero).agregarLibro(t);
			}
		}
	}

	public NodoGenero busquedaPorGenero(String genero) {
		return arbol.buscarGenero(genero);
	}

	public int getHeight() {
		return this.arbol.getHeight();
	}

	public ArbolGenero getArbol() {
		return arbol;
	}
	
	

}