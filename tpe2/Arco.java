package tpe2;

public class Arco {

	private String verticeOrigen;
	private String verticeDestino;
	private Integer etiqueta;

	public Arco(String verticeOrigen, String verticeDestino) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
	}

	public String getVerticeOrigen() {
		return verticeOrigen;
	}

	public String getVerticeDestino() {
		return verticeDestino;
	}

	public Integer getEtiqueta() {
		return etiqueta;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arco other = (Arco) obj;
		return verticeDestino == other.verticeDestino && verticeOrigen == other.verticeOrigen;
	}

	public void setEtiqueta(int i) {
		this.etiqueta = i;
	}

	@Override
	public String toString() {
		return "[" + verticeOrigen + " " + verticeDestino + " " + etiqueta + "]";
	}

}
