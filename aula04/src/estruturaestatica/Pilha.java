package estruturaestatica;

public class Pilha<T> extends EstruturaEstaticas<T> {
	
	public Pilha() {
		super();
	}
	
	public Pilha(int capacidade) {
		super(capacidade);
	}
	
	public void Empilhar (T elemento) {
		//dessa forma estamos reutilizando o código da classe pai
		super.adiciona(elemento);
	}
	
	public T topo() {
		if(this.estaVazia()) {
			return null;
		}else {
		  return this.elementos[tamanho - 1];
		}
	}
	
	public T desempilhar() {
		if(this.estaVazia()) {
			return null;
		}
		
		T elemento = this.elementos[tamanho - 1];
		tamanho--;
		return elemento;
	}
}
