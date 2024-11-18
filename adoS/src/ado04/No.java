package ado04;

import java.util.ArrayList;
import java.util.List;

public class No {
	private String nome;
	private List<Aresta> conexoes;

	public No(String nome) {
		this.nome = nome;
		this.conexoes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Aresta> getConexoes() {
		return conexoes;
	}

	public void adicionarConexao(No destino, int peso) {
		conexoes.add(new Aresta(destino.getNome(), peso));
	}

	@Override
	public String toString() {
		return "No{" + "nome='" + nome + '\'' + ", conexoes=" + conexoes + '}';
	}
}