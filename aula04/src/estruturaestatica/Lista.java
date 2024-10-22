package estruturaestatica;

public class Lista<T> extends EstruturaEstaticas<T> {

	// Método Construtor com parâmetro o super porque esta herdando...
	public Lista(int capacidade) {
		super(capacidade);
	}

	// Métoddo Construtor sem Parâmetros
	public Lista() {
		super();
	}

	public boolean adiciona(T elemento) {
		return super.adiciona(elemento);
	}

	public boolean adiciona(int posicao, T elemento) {
		return super.adiciona(posicao, elemento);
	}
}
