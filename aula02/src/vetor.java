package projeto_revisao_ed;

import java.util.Arrays;

public class Vetor {
	public String[] elementos;
	public int tamanho;

	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
	
    //Metodo para adicionar o elemento
	public void adiciona(String elemento) throws Exception {
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("O Vetor ja está cheio, não é possivel adiconar novos elementos");
		}
	}

	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
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

	// Buscando um dado na matriz
	public String busca(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			return this.elementos[posicao];
		} else {
			throw new Exception("Posição Inválida");
		}
	}

	// adicionando dados na posição especifica
	public boolean adicionarInicio(int posicao, String elemento) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			for (int i = this.tamanho - 1; i >= posicao; i--) {
				this.elementos[i + 1] = this.elementos[i];
			}
			this.elementos[posicao] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Posição Inválida");
		}
		return true;
	}
}