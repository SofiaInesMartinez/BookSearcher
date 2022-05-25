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
			String[] generos = b.getGeneros();
			int i = 0;
			while (i < generos.length) {
				//Bsca los nodos de cada genero y agrega el titulo en cada uno x cada libro			
				NodoGenero nodo = arbol.buscarGenero(generos[i]); //Falta chequeo de si el nodo existe o lo crea
				if(nodo!= null) {
				nodo.agregarLibro(b); //Ver si esto se arma con los libros o solo con los titulos
				} else {
					arbol.add(generos[i]);
					//y dps tiene que agregar el libro en ese nodo. Podemos cambiar el metodo add para retorne el nodo en lugar de q sea void
					//sino dps de crear el nodo hay q buscarlo para agregarle el libro no?
				}
			}
		}
	}

	public NodoGenero busquedaPorGenero(String genero) {
		return arbol.buscarGenero(genero);
	}
	
	

}
