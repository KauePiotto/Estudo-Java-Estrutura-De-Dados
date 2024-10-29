package aula10;

import java.util.Random; //Usa a biblioteca de randomização

public class exemplo_arvore {
	public static void main(String[] args) {
		Random rand = new Random(); // Inicializa a randomizzação
		Arvore arvore = new Arvore(); // Cria uma árvore binária

		for (int i = 0; i < 10; i++) { //Fazer 10 vezes
			arvore.insert(rand.nextInt(100), arvore.root);//Insere um elemento aleatorio de 0 até 99
		}
		
	}
}
