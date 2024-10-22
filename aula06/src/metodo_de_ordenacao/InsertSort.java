package metodo_de_ordenacao;

public class InsertSort {
	public static void main(String[] args) {
		// Criando um vetor de numeros inteiros com 10 posições
		int[] vetor = new int[10];

		// Inserindo valores no vetor
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * vetor.length);
			System.out.println(vetor[i]);
		}

		// Metodo de Ordenacao InsertSort
		int aux, j;
		for (int i = 0; i < vetor.length; i++) {
			aux = vetor[i];
			j = i - 1;

			while (j >= 0 && vetor[j] > aux) {
				vetor[j + 1] = vetor[j];
				j--;
			}
			vetor[j + 1] = aux;
		}
		System.out.println("Vetor Ordenado:");
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
	}
}
