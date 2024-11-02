package ado03;

public class Aresta {
	private Vertice de;
	private Vertice para;

	public Aresta(Vertice de, Vertice para) {
		this.de = de;
		this.para = para;
	}

	public Vertice getDe() {
		return de;
	}

	public void setDe(Vertice de) {
		this.de = de;
	}

	public Vertice getPara() {
		return para;
	}

	public void setPara(Vertice para) {
		this.para = para;
	}

	@Override
	public String toString() {
		return de.getNome() + "Presenteia: " + para.getNome();
	}
}