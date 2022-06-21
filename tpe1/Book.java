package tpe1;

public class Book {
	private String titulo;
	private String autor;
	private int paginas;
	private String[] generos;

	public Book(String titulo, String autor, Integer paginas, String[] generos) {
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.generos = generos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return this.paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String[] getGeneros() {
		return generos;
	}

	public void setGeneros(String[] generos) {
		this.generos = generos;
	}

	@Override
	public String toString() {
		return titulo;
	}

}