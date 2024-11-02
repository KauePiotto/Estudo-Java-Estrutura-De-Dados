package metodo_de_ordenacao;

public class SelectionSortTime {
    // Criando um vetor de numeros inteiros com 10 posições
    int[] vetor = new int[10];

    // Inserindo valores no vetor
		for (int i = 0; i < vetor.length; i++) {
        vetor[i] = (int) (Math.random() * vetor.length);
        System.out.println(vetor[i]);
    }

    // Metodo de Ordenação Selection Sort
    int menor_posicao, aux;

		for (int k = 0; k < vetor.length; k++) {
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
