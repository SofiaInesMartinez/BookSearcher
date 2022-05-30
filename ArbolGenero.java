package tpe;

import java.util.ArrayList;

public class ArbolGenero {
	private NodoGenero root;

	public ArbolGenero() {
		this.root = null;
	}

	public String getRoot() {
		if (this.root != null)
			return this.root.getGenero();
		else
			return null;
	}

	// Buscador por genero
	public NodoGenero buscarGenero(String genero) { // Se puede crear un metodo parecido pero sin el add en el private
		return buscarGenero(this.root, genero); // para que no puedan crear nodos con cualquier cosa desde afuera
	} // al realizar las busquedas

	private NodoGenero buscarGenero(NodoGenero nodo, String genero) {
		if (nodo != null) {
			if (nodo.getGenero().equals(genero)) {
				return nodo;
			} else if (nodo.getGenero().compareTo(genero) > 0)
				return this.buscarGenero(nodo.getHijoizq(), genero);
			else
				return this.buscarGenero(nodo.getHijoder(), genero);
		}
		NodoGenero aux = this.add(genero);
		return aux;
	}

	// hasElem
//	public boolean hasElem(String genero) {
//		return this.hasElem(this.root, genero);
//	}
//
//	private boolean hasElem(NodoGenero nodo, String genero) {
//		if (nodo != null) {
//			if (nodo.getGenero() == genero)
//				return true;
//			else if (nodo.getGenero().compareTo(genero) > 0)
//				return this.hasElem(nodo.getHijoizq(), genero);
//			else
//				return this.hasElem(nodo.getHijoder(), genero);
//		}
//		return false;
//	}

	// isEmpty
//	public boolean isEmpty() {
//		return (this.root == null);
//	}

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
		if (nodo.getGenero().compareTo(genero) > 0) { // Para chequear < o > porque suelo pifiarle
			if (nodo.getHijoizq() == null) {
				NodoGenero tmp = new NodoGenero(genero);
				nodo.setHijoizq(tmp);
			} else {
				this.add(nodo.getHijoizq(), genero);
			}
		} else if (nodo.getGenero().compareTo(genero) < 0) { // Chequear signo del compareTo
			if (nodo.getHijoder() == null) {
				NodoGenero tmp = new NodoGenero(genero);
				nodo.setHijoder(tmp);
			} else {
				this.add(nodo.getHijoder(), genero);
			}
		}
		return nodo;
	}

	// void printPosOrder()

	public void printPosOrder() {
		this.printPosOrder(this.root);
	}

	private void printPosOrder(NodoGenero node) {
		if (node != null) {
			printPosOrder(node.getHijoizq());
			printPosOrder(node.getHijoizq());
			System.out.println(node);
		}
	}

	// void printPreOrder()

	public void printPreOrder() {
		printPreOrder(this.root);
	}

	private void printPreOrder(NodoGenero node) {
		if (node != null) {
			System.out.println(node);
			printPreOrder(node.getHijoizq());
			printPreOrder(node.getHijoder());
		} else {
			System.out.println("- ");
		}
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

}