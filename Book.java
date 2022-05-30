package tpe;

import java.util.Arrays;

public class Book {
	private String Titulo;
	private String Autor;
	private String Paginas; //Para cambiar cuando resolvamos el parseo en el REader
	private String[] Generos;
	
		
	public Book(String titulo, String autor, String paginas, String[] generos) {
		super();
		Titulo = titulo;
		Autor = autor;
		Paginas = paginas;
		Generos = generos;
	}
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
//	public int getPaginas() {
//		return Paginas;
//	}
//	public void setPaginas(int paginas) {
//		Paginas = paginas;
//	}
	public String[] getGeneros() {
		return Generos;
	}
	public void setGeneros(String[] generos) {
		Generos = generos;
	}

	@Override
	public String toString() { //Ver desde donde se levanta. si es directo para el resutlado tiene que quedar solo el titulo
		return "[Titulo=" + Titulo + "]";
	}
	
	

	
}