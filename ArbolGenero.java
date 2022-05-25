package tpe;


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
	public NodoGenero buscarGenero(String genero) {
		return this.buscarGenero(this.root, genero);
	}

	private NodoGenero buscarGenero(NodoGenero nodo, String genero) {
		NodoGenero aux = null;
		if (nodo != null) {
			if (nodo.getGenero() == genero)
				return nodo;
			else if (nodo.getGenero().compareTo(genero) > 0)
				aux = this.buscarGenero(nodo.getHijoizq(), genero);  //Ver si anda, antes tenia return en esta linea y en ln31
			else
				aux = this.buscarGenero(nodo.getHijoder(), genero);
		}
		return aux;
	}

	// hasElem
	public boolean hasElem(String genero) {
		return this.hasElem(this.root, genero);
	}

	private boolean hasElem(NodoGenero nodo, String genero) {
		if (nodo != null) {
			if (nodo.getGenero() == genero)
				return true;
			else if (nodo.getGenero().compareTo(genero) > 0)
				return this.hasElem(nodo.getHijoizq(), genero);
			else
				return this.hasElem(nodo.getHijoder(), genero);
		}
		return false;
	}

	// isEmpty
	public boolean isEmpty() {
		return (this.root == null);
	}

	// add
	public void add(String genero) {
		if (this.root == null) {
			this.root = new NodoGenero(genero);
		} else {
			this.add(this.root, genero);
		}
	}

	private void add(NodoGenero nodo, String genero) {
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
	}

	// delete
	public boolean delete(String genero) {
		return this.delete(this.root, genero);
	}

	private boolean delete(NodoGenero nodo, String genero) {
		NodoGenero aux = nodo;
		NodoGenero padre = nodo;
		boolean esHijoizq = true;

		while (aux.getGenero() != genero) {
			padre = aux;
			if (aux.getGenero().compareTo(genero) > 0) { // Chequear signo del compareTo
				aux = aux.getHijoizq();
				esHijoizq = true;
			} else {
				aux = aux.getHijoder();
				esHijoizq = false;
			}
			if (aux == null)
				return false;
		} // sale del while con aux = al valor que estoy buscando
			// si es que lo encontró, sino retorne falso

		// CASO 1 ES HOJA
		if (aux.getHijoizq() == null && aux.getHijoder() == null) {
			if (aux == this.root)
				this.root = null;
			else if (esHijoizq)
				padre.setHijoizq(null);
			else
				padre.setHijoder(null);
		}

		// CASO 2 TIENE UN HIJO
		else if (aux.getHijoizq() != null && aux.getHijoder() == null) {
			if (aux == this.root)
				this.root = aux.getHijoizq();
			else
				padre.setHijoder(aux.getHijoizq());
		} else if (aux.getHijoizq() == null && aux.getHijoder() != null) {
			if (aux == this.root)
				this.root = aux.getHijoder();
			else
				padre.setHijoder(aux.getHijoder());
		}

		// CASO 3 TIENE DOS HIJOS
		else {
			// buscar NMI del arbol derecho
			String nmi = buscarNMIarbolDerecho(aux);
			delete(aux, nmi);
			aux.setGenero(nmi);
		}
		return true;
	}

	public String buscarNMIarbolDerecho(NodoGenero nodo) {
		NodoGenero aux = nodo.getHijoder();
		String nmi = aux.getGenero();
		while (aux.getHijoizq() != null) {
			nmi = aux.getHijoizq().getGenero();
			aux = aux.getHijoizq();
		}
		return nmi;
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
			System.out.println(node.getGenero());
			printInOrder(node.getHijoder());
		}
	}

}
