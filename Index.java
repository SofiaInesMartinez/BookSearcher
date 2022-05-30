package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class Index {

	private Library biblioteca;
	private ArbolGenero arbol;

	public Index(Library biblioteca) {
		this.biblioteca = biblioteca;
		this.arbol = new ArbolGenero();
	}

	public ArbolGenero crearIndice() {
		Iterator<Book> it = biblioteca.getLibros();
		while (it.hasNext()) {
			Book b = it.next();
			String[] generos = b.getGeneros();
			for (String genero : generos) {
				if (!arbol.hasElem(genero)) {
					arbol.add(genero);
				}
//				ArrayList<String> titulo = new ArrayList<>();
				String t = b.getTitulo();
//				titulo.add(t);
				arbol.buscarGenero(genero).agregarLibro(t);
			}
			// Busca los nodos de cada genero y agrega el titulo en cada uno x cada libro
			// Falta chequeo de si el nodo existe o lo crea
			// Ver si esto se arma con los libros o solo con los titulos
			// y dps tiene que agregar el libro en ese nodo. Podemos cambiar el metodo add
			// para retorne el nodo en lugar de q sea void
			// sino dps de crear el nodo hay q buscarlo para agregarle el libro no?

		}
		return arbol;
	}

	public NodoGenero busquedaPorGenero(String genero) {
		return arbol.buscarGenero(genero);
	}

	public ArbolGenero getArbol() {
		return arbol;
	}

}