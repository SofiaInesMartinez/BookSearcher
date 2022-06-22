package tpe2;

import java.util.ArrayList;

public class Estado {
	private ArrayList<String> solucionParcial;
	private String generoInicio;
	
	public Estado() {
		super();
		this.solucionParcial = new ArrayList<String>();
		this.generoInicio = "";
	}

	public ArrayList<String> getSolucionParcial() {
		return solucionParcial;
	}

	public String getGeneroInicio() {
		return generoInicio;
	}
	
	public void setGeneroInicio(String generoInicio) {
		this.generoInicio = generoInicio;
	}

	public void add(String genero) {
		solucionParcial.add(genero);
	}
	
	public void remove(String genero) {
		solucionParcial.remove(genero);
	}
	
	public String getUltimo() {
		return solucionParcial.get(solucionParcial.size() - 1);
	}
}
