package estruturaestatica;

public class Teste {
	public static void main(String[] args) {
		Pilha<Integer> pilha = new Pilha<Integer>();

		pilha.Empilhar(1);
		pilha.Empilhar(2);
		pilha.Empilhar(3);

		System.out.println(pilha);

		System.out.println("Desempilhar elemento " + pilha.desempilhar());

		System.out.println(pilha);
	}
}
