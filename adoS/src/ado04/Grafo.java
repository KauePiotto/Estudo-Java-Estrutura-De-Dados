package ado04;

import java.util.*;

public class Grafo {

	private Map<String, No> nos;

	public Grafo() {
		nos = new HashMap<>();
	}

	public void adicionarNo(String nome) {
		nos.putIfAbsent(nome, new No(nome));
	}

	// Adicionar uma aresta entre dois nós
	public void adicionarAresta(String origem, String destino, int peso) {
		adicionarNo(origem);
		adicionarNo(destino);
		nos.get(origem).adicionarConexao(nos.get(destino), peso);
		nos.get(destino).adicionarConexao(nos.get(origem), peso);
	}

	public List<String> menorCaminho(String inicio, String fim) {
		Map<String, Integer> distancias = new HashMap<>();
		Map<String, String> anteriores = new HashMap<>();
		PriorityQueue<Aresta> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
		Set<String> visitados = new HashSet<>();

		for (String nome : nos.keySet()) {
			distancias.put(nome, Integer.MAX_VALUE);
		}
		distancias.put(inicio, 0);

		fila.add(new Aresta(inicio, 0));

		while (!fila.isEmpty()) {
			String atual = fila.poll().destino;

			if (!visitados.add(atual)) {
				continue;
			}

			for (Aresta aresta : nos.get(atual).getConexoes()) {
				if (!visitados.contains(aresta.destino)) {
					int novaDistancia = distancias.get(atual) + aresta.peso;
					if (novaDistancia < distancias.get(aresta.destino)) {
						distancias.put(aresta.destino, novaDistancia);
						anteriores.put(aresta.destino, atual);
						fila.add(new Aresta(aresta.destino, novaDistancia));
					}
				}
			}
		}

		return reconstruirCaminho(anteriores, inicio, fim);
	}

	private List<String> reconstruirCaminho(Map<String, String> anteriores, String inicio, String fim) {
		List<String> caminho = new ArrayList<>();
		String atual = fim;
		while (atual != null) {
			caminho.add(0, atual);
			atual = anteriores.get(atual);
		}
		return caminho.get(0).equals(inicio) ? caminho : Collections.emptyList();
	}
}