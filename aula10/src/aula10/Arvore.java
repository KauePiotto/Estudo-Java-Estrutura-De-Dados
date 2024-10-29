package aula10;

public class Arvore {
	No root = null; // Nó pai, ou raiz

	public void insert(int info, No place) { // algoritmo para inserir uma informação
		if (place == null) { // Se o local está vazio, então a arvore está vazia
			root = new No(info); // e o root vai receber o novo nó
			System.out.println("" + info); // Imprime a informação inserida
		} else if (info < place.info) { // Senão, se a informação é menor do que a do local
			if (place.left == null) { // Se o filho da esquerda está vazio
				place.left = new No(info); // Então insere a esquerda o novo nó
				System.out.println("" + info); // Imprime a informação inserida
			} else { // São, se não for vazio
				insert(info, place.left); // Pula para o filho a esquerda usando a recursividade
			}
		} else if (info > place.info) { // Senão, se a informação é maior que a do local
			if (place.right == null) {// Se o filho a direita está vazio
				place.right = new No(info);// Insere a informação em um novo nó a direita
				System.out.println("" + info);// e imprime a informação
			} else { // Senão, se o nó a direita não está vazio
				insert(info, place.right);// Pula para o filho a direita usando a recursividade
			}
		}
	}

	public void preOrder(No place) { // Algoritmo de navegação em pré ordem
		System.out.println("" + place.info); // Primeiro imprime a informação do nó
		if (place.left != null) { // Se o filho a esquerda não está vazio
			preOrder(place.left);// Pula para o filho a esquerda pela recursividade
		}
		if (place.right != null) { // Se filho a direita não está vazio
			preOrder(place.right);// Pula para o filho a direita pela recursividade
		}
	}

	public void inOrder(No place) { // Algoritmo de navegação em ordem
		if (place.left != null) { // Se o filho a esquerda não esta vazio
			inOrder(place.left); // Pula para o filho a esquerda pela recursividade
		}
		System.out.println("" + place.info); // Depois imprime a informação do nó
		if (place.right != null) { // Se o filho a direita não está vazio
			inOrder(place.right);// Pula para o filho a direita pela recursivade
		}
	}

	public void postOrder(No place) { // Algoritmo de navegacao em pós ordem
		if (place.left != null) { // Se o filho a esquerda não está vazio
			postOrder(place.left); // Pula para o filho a esquerda pela recursivaide
		}
		if (place.right != null) { // Se filho a direita não está vazio
			postOrder(place.right); // Pula para o filho a direita pela recursividade
		}
		System.out.println("" + place.info); // Por último, imprime a informação do nó
	}
}