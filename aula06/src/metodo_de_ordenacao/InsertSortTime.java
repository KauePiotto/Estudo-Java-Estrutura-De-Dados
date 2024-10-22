package metodo_de_ordenacao;

public class InsertSortTime {
		public static void main(String[] args) {
			
			// Criando um vetor de numeros inteiros
			int[] vetor = new int[100];
			// Tempo de execução para um vetor com 100 = 
			// Tempo de execução para um vetor com 1.000 = 
			// Tempo de execução para um vetor com 10.00= 
			// Tempo de execução para um vetor com 100.000 = 
			
			// Inserindo valores no vetor
			for (int i = 0; i < vetor.length; i++) {
				vetor[i] = (int) (Math.random() * vetor.length);
			}

			// Variavel que registra o tempo de execução no inicio
			long inicio = System.currentTimeMillis();

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
			
			// Vrivel para registar o tempo de execução final
			long fim = System.currentTimeMillis();
			
			System.out.println("Tempo de execução > " + (fim - inicio));
		}
	}