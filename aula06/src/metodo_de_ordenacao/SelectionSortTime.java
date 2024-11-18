package metodo_de_ordenacao;

public class SelectionSortTime {
	public static void main(String[] args) {
		// Criando um vetor de numeros inteiros com 10 posições
		int[] vetor = new int[10];

		// Inserindo valores no vetor
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * vetor.length);
			System.out.println(vetor[i]);
		}

		System.out.println();

		// Metodo de Ordenação Selection Sort
		int menor_posicao, aux;

		for (int i = 0; i < vetor.length; i++) {
			menor_posicao = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[menor_posicao]) {
					menor_posicao = j;
				}
			}
			aux = vetor[menor_posicao];
			vetor[menor_posicao] = vetor[i];
		}

	}
}