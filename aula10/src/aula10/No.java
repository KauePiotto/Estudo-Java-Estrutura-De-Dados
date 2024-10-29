package aula10;

public class No { //Classe do nó
	int info; //Informação tipo inteiro
	No left; //Filho a esquerda
	No right; //Filho a direita

	public No(int info) { //Método Construtor para Inicializar os atributos da classe
		this.info = info; //Inicializa a informação como o parametro rebifo
		this.left = null; //Inicializa o filho a esquerda como vazio
		this.right = null; //Inicializa o filho a esquerda como vazio
	}
}
