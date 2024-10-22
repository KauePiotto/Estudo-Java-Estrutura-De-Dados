package metodo_de_ordenacao;

public class BubbleSortTime {
	public static void main(String[] args) {
		int[] vetor = new int[100];
		// Tempo de execução para um vetor com 100 = 0
		// Tempo de execução para um vetor com 1.000 = 4
		// Tempo de execução para um vetor com 10.00= 125
		// Tempo de execução para um vetor com 100.000 = 12.037
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * vetor.length);
		}

		// Variavel que registra o tempo de execução no inicio
		long inicio = System.currentTimeMillis();

		// Metodo de Ordenação bubbleSort
		int aux;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = i; j < vetor.length; j++) {
				if (vetor[i] > vetor[j]) {
					aux = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = aux;
				}
			}
		}

		// Vrivel para registar o tempo de execução final
		long fim = System.currentTimeMillis();

		// Exibindo o tempo de execução
		System.out.println("Tempo de execução > " + (fim - inicio));
	}
}
