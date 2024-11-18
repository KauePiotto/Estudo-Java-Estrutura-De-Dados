package ado04;

public class Aresta {
	String destino;
	int peso;

	public Aresta(String destino, int peso) {
		this.destino = destino;
		this.peso = peso;
	}
	
	public String getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "(" + destino + ", " + peso + "m)";
	}
}