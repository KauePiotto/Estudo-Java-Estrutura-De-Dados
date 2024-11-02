package ado03;

public class Vertice {
	private String nome;

	public Vertice(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Vertice [nome=" + nome + "]";
	}
}