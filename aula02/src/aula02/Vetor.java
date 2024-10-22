package aula02;

import java.util.Arrays;

public class Vetor {

	// Lista de Atributos
	private String[] elementos;
	private int tamanho;

	// Lista de Metodos
	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}

	public void adiciona(String elemento) throws Exception {
		this.aumentarCapacidade();
		this.elementos[this.tamanho] = elemento;
		this.tamanho++;
	}

	// Metodo para informar o tamanho real de um vetor
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		// Essa clase permite criar e manipular dados de String dinamicamente
		StringBuilder s = new StringBuilder();
		// O método append serve para adicionar conteudo ao final de um StringBuffer
		s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}

		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);
		}

		s.append("]");

		return s.toString();
	}

	public String buscar(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			return this.elementos[posicao];
		} else {
			throw new Exception("Posicao Invalida");
		}
	}

	public int buscar1(String elemento) {
		for (int i = 0; i < tamanho; i++) {
			if (elementos[i].equalsIgnoreCase(elemento))
				;
			return i;
		}
		return -1;
	}

	public boolean adicionaInicio(int posicao, String elemento) throws Exception {
		this.aumentarCapacidade();
		if (posicao >= 0 && posicao < tamanho) {
			for (int i = this.tamanho - 1; i >= posicao; i--) {
				this.elementos[i + 1] = this.elementos[i];
			}
			this.elementos[posicao] = elemento;
			this.tamanho++;
		}
		return true;
	}

	private void aumentarCapacidade() {
		if (this.tamanho == this.elementos.length) {
			String[] elementosNovos = new String[this.elementos.length * 2];
			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}

	public void remove(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			for (int i = posicao; i < this.tamanho - 1; i++) {
				this.elementos[i] = this.elementos[i + 1];
			}
			this.elementos[tamanho] = null;
			this.tamanho--;
		}else {
			throw new Exception("Posicao Invalida");
		}
	}
}