package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
	ArrayList<Book> libros;

	public Library() {
		this.libros = new ArrayList<>();
	}
	
	public void agregarLibro(Book b) {
		libros.add(b);
	}

	public Iterator<Book> getLibros() {
		return libros.iterator();
	}

	@Override
	public String toString() {
		return "Library [libros=" + libros + "]";
	}
	
}
