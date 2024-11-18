package ado04;

import java.util.List;
import java.util.Scanner;

public class TesteGrafo {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		Scanner scanner = new Scanner(System.in);

		// Todas as possibilidades do ponto A
		grafo.adicionarAresta("A", "B", 300);
		grafo.adicionarAresta("A", "X", 317);
		grafo.adicionarAresta("A", "V", 370);

		// Todas as possibilidades do ponto B
		grafo.adicionarAresta("B", "C", 47);
		grafo.adicionarAresta("B", "A", 300);

		// Todas as possibilidades do ponto C
		grafo.adicionarAresta("C", "B", 47);
		grafo.adicionarAresta("C", "D", 62);
		grafo.adicionarAresta("C", "H", 141);

		// Todas as possibilidades do ponto D
		grafo.adicionarAresta("D", "E", 8);
		grafo.adicionarAresta("D", "C", 62);

		// Todas as possibilidades do ponto E
		grafo.adicionarAresta("E", "D", 8);
		grafo.adicionarAresta("E", "F", 13);
		grafo.adicionarAresta("E", "G", 230);

		// Todas as possibilidades do ponto F
		grafo.adicionarAresta("F", "E", 13);

		// Todas as possibilidades do ponto G
		grafo.adicionarAresta("G", "E", 230);

		// Todas as possibilidades do ponto H
		grafo.adicionarAresta("H", "C", 141);
		grafo.adicionarAresta("H", "I", 138);

		// Todas as possibilidades do ponto I
		grafo.adicionarAresta("I", "H", 138);
		grafo.adicionarAresta("I", "J", 153);

		// Todas as possibilidades do ponto J
		grafo.adicionarAresta("J", "I", 153);
		grafo.adicionarAresta("J", "K", 512);

		// Todas as possibilidades do ponto K
		grafo.adicionarAresta("K", "J", 512);
		grafo.adicionarAresta("K", "L", 135);

		// Todas as possibilidades do ponto L
		grafo.adicionarAresta("L", "K", 135);
		grafo.adicionarAresta("L", "M", 50);
		grafo.adicionarAresta("L", "N", 187);

		// Todas as possibilidades do ponto M
		grafo.adicionarAresta("M", "L", 50);

		// Todas as possibilidades do ponto N
		grafo.adicionarAresta("N", "L", 187);
		grafo.adicionarAresta("N", "O", 108);

		// Todas as possibilidades do ponto O
		grafo.adicionarAresta("O", "N", 108);
		grafo.adicionarAresta("O", "P", 82);

		// Todas as possibilidades do ponto P
		grafo.adicionarAresta("P", "O", 82);
		grafo.adicionarAresta("P", "Q", 215);

		// Todas as possibilidades do ponto Q
		grafo.adicionarAresta("Q", "P", 215);
		grafo.adicionarAresta("Q", "R", 97);

		// Todas as possibilidades do ponto R
		grafo.adicionarAresta("R", "Q", 97);
		grafo.adicionarAresta("R", "T", 243);
		grafo.adicionarAresta("R", "S", 33);

		// Todas as possibilidades do ponto S
		grafo.adicionarAresta("S", "R", 33);
		grafo.adicionarAresta("S", "T", 207);
		grafo.adicionarAresta("S", "V", 38);

		// Todas as possibilidades do ponto T
		grafo.adicionarAresta("T", "R", 243);
		grafo.adicionarAresta("T", "S", 207);
		grafo.adicionarAresta("T", "U", 22);

		// Todas as possibilidades do ponto U
		grafo.adicionarAresta("U", "T", 22);
		grafo.adicionarAresta("U", "V", 210);
		grafo.adicionarAresta("U", "X", 107);

		// Todas as possibilidades do ponto V
		grafo.adicionarAresta("V", "U", 210);
		grafo.adicionarAresta("V", "A", 307);

		// Todas as possibilidades do ponto X
		grafo.adicionarAresta("X", "U", 107);
		grafo.adicionarAresta("X", "A", 317);

		System.out.println("Digite o ponto de partida:");
		String inicio = scanner.nextLine().toUpperCase();

		System.out.println("Digite o ponto de chegada:");
		String fim = scanner.nextLine().toUpperCase();

		List<String> caminhoOriginal = grafo.menorCaminho(inicio, fim);

		if (caminhoOriginal.isEmpty()) {
			System.out.println("Não há caminho disponível entre " + inicio + " e " + fim);
		} else {
			// Exibindo o caminho original
			System.out.println("Caminho original de " + inicio + " a " + fim + ":");
			int distanciaTotal = 0;
			for (int i = 0; i < caminhoOriginal.size() - 1; i++) {
				String origem = caminhoOriginal.get(i);
				String destino = caminhoOriginal.get(i + 1);
				int distancia = grafo.calcularPeso(origem, destino);
				distanciaTotal += distancia;
				System.out.print(origem + " (" + distancia + "m) -> ");
			}
			System.out.println(caminhoOriginal.get(caminhoOriginal.size() - 1));
			System.out.println("Distância total: " + distanciaTotal + " metros");

			List<List<String>> caminhosAlternativos = grafo.caminhoAlternativo(inicio, fim, caminhoOriginal);

			if (caminhosAlternativos.isEmpty()) {
				System.out.println("Não há caminhos alternativos disponíveis entre " + inicio + " e " + fim);
			} else {
				boolean encontrouAlternativoDiferente = false;
				System.out.println("Caminhos alternativos encontrados:");
				for (int i = 0; i < Math.min(2, caminhosAlternativos.size()); i++) {
					List<String> caminhoAlternativo = caminhosAlternativos.get(i);

					if (!caminhoAlternativo.equals(caminhoOriginal)) {
						encontrouAlternativoDiferente = true;
						int distanciaTotal1 = 0;
						for (int j = 0; j < caminhoAlternativo.size() - 1; j++) {
							String origem = caminhoAlternativo.get(j);
							String destino = caminhoAlternativo.get(j + 1);
							int distancia = grafo.calcularPeso(origem, destino);
							distanciaTotal1 += distancia;
							System.out.print(origem + " (" + distancia + "m) -> ");
						}
						System.out.println(caminhoAlternativo.get(caminhoAlternativo.size() - 1));
						System.out.println("Distância total: " + distanciaTotal1 + " metros");
					}
				}

				if (!encontrouAlternativoDiferente) {
					System.out.println("Não foram encontrados caminhos alternativos diferentes do caminho original.");
				}
			}
		}
		scanner.close();
	}
}