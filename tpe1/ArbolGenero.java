package tpe1;

import java.util.ArrayList;

public class ArbolGenero {
	private NodoGenero root;

	public ArbolGenero() {
		this.root = null;
	}

	// Buscador por genero para acceder desde el main
	public NodoGenero buscarGenero(String genero) {
		int contador = 1;
		return buscarGenero(this.root, genero, contador);
	}

	private NodoGenero buscarGenero(NodoGenero nodo, String genero, int contador) {
		if (nodo != null) {
			if (nodo.getGenero().equals(genero)) {
				System.out.println("Nodos recorridos en la búsqueda " + contador);
				return nodo;
			} else if (nodo.getGenero().compareTo(genero) > 0)
				return this.buscarGenero(nodo.getHijoizq(), genero, contador + 1);
			else
				return this.buscarGenero(nodo.getHijoder(), genero, contador + 1);
		}
		NodoGenero aux = new NodoGenero("Género no encontrado");
		return aux;
	}

	// Buscador por genero para crear el indice. Ver si vale la pena ponerlos por
	// separado o no.
	// Este genera un nodo con el string ingresado si es que no lo encuentra, y lo
	// agrega al arbol.
	// No puede accederse desde el main a traves del indice.
	protected NodoGenero buscarGeneroInterno(String genero) {
		return buscarGeneroInterno(this.root, genero);
	}

	private NodoGenero buscarGeneroInterno(NodoGenero nodo, String genero) {
		if (nodo != null) {
			if (nodo.getGenero().equals(genero)) {
				return nodo;
			} else if (nodo.getGenero().compareTo(genero) > 0)
				return this.buscarGeneroInterno(nodo.getHijoizq(), genero);
			else
				return this.buscarGeneroInterno(nodo.getHijoder(), genero);
		}
		return null;
	}

	// add
	public NodoGenero add(String genero) {
		if (this.root == null) {
			this.root = new NodoGenero(genero);
			return this.root;
		} else {
			return this.add(this.root, genero);
		}
	}

	private NodoGenero add(NodoGenero nodo, String genero) {
		if (nodo.getGenero().compareTo(genero) > 0) {
			if (nodo.getHijoizq() == null) {
				NodoGenero tmp = new NodoGenero(genero);
				nodo.setHijoizq(tmp);
			} else {
				this.add(nodo.getHijoizq(), genero);
			}
		} else if (nodo.getGenero().compareTo(genero) < 0) {
			if (nodo.getHijoder() == null) {
				NodoGenero tmp = new NodoGenero(genero);
				nodo.setHijoder(tmp);
			} else {
				this.add(nodo.getHijoder(), genero);
			}
		}
		return nodo;
	}

	// void printInOrder()

	public void printInOrder() {
		printInOrder(this.root);
	}

	private void printInOrder(NodoGenero node) {
		if (node != null) {
			printInOrder(node.getHijoizq());
			System.out.print(node.getGenero() + " ");
			ArrayList<String> libros = node.getLibros();
			for (String libro : libros) {
				System.out.print(libro + " ");
			}
			System.out.println("");
			printInOrder(node.getHijoder());
		}
	}

	// getHeight

	public int getHeight() {
		int height = getHeight(this.root, 0, 0);
		return height;
	}

	private int getHeight(NodoGenero nodo, int depth, int height) {
		if (nodo != null) {
			height = this.getHeight(nodo.getHijoizq(), depth + 1, height);
			if (depth > height)
				height = depth;
			height = this.getHeight(nodo.getHijoder(), depth + 1, height);
		}
		return height;
	}

}