package metodo_de_ordenacao;

public class BubbleSort {
	public static void main(String[] args) {
		// Criando um vetor de numeros inteiros com 10 posições
		int[] vetor = new int[10];

		// Inserindo valores no vetor
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * vetor.length);
			System.out.println(vetor[i]);
		}

		// Método de ordenação BubbleSort
		int aux;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[i] > vetor[j]) {
					aux = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = aux;
				}
			}
		}
		System.out.println("Vetor Ordenado:");
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
	}
}