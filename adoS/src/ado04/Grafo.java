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

	public void adicionarAresta(String origem, String destino, int peso) {
		adicionarNo(origem);
		adicionarNo(destino);
		nos.get(origem).adicionarConexao(nos.get(destino), peso);
		nos.get(destino).adicionarConexao(nos.get(origem), peso);
	}

	public List<String> menorCaminho(String inicio, String fim) {
		Map<String, Integer> distancias = new HashMap<>();
		Map<String, String> anteriores = new HashMap<>();

		PriorityQueue<String> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

		Set<String> visitados = new HashSet<>();

		for (String nome : nos.keySet()) {
			distancias.put(nome, Integer.MAX_VALUE);
		}
		distancias.put(inicio, 0);

		fila.add(inicio);

		while (!fila.isEmpty()) {
			String atual = fila.poll();
			if (!visitados.add(atual)) {
				continue;
			}
			for (Aresta aresta : nos.get(atual).getConexoes()) {
				String destino = aresta.getDestino();
				int peso = aresta.getPeso();
				if (visitados.contains(destino)) {
					continue;
				}
				int novaDistancia = distancias.get(atual) + peso;
				if (novaDistancia < distancias.get(destino)) {
					distancias.put(destino, novaDistancia);
					anteriores.put(destino, atual);
					fila.add(destino);
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

	public int calcularPeso(String origem, String destino) {
		for (Aresta aresta : nos.get(origem).getConexoes()) {
			if (aresta.getDestino().equals(destino)) {
				return aresta.getPeso();
			}
		}
		return Integer.MAX_VALUE;
	}

	public List<List<String>> caminhoAlternativo(String inicio, String fim, List<String> caminhoOriginal) {
		List<List<String>> caminhosAlternativos = new ArrayList<>();

		// Definir um conjunto de arestas visitadas (aquelas do caminho original)
		Set<String> arestasUsadas = new HashSet<>();
		for (int i = 0; i < caminhoOriginal.size() - 1; i++) {
			String origem = caminhoOriginal.get(i);
			String destino = caminhoOriginal.get(i + 1);
			arestasUsadas.add(origem + destino);
			arestasUsadas.add(destino + origem);
		}

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

			// Evita que nós no caminho original sejam visitados
			if (visitados.contains(atual)) {
				continue;
			}

			visitados.add(atual);

			for (Aresta aresta : nos.get(atual).getConexoes()) {
				// Ignora arestas que já foram usadas no caminho original
				String conexao = atual + aresta.destino;
				if (arestasUsadas.contains(conexao)) {
					continue;
				}

				int novaDistancia = distancias.get(atual) + aresta.peso;
				if (novaDistancia < distancias.get(aresta.destino)) {
					distancias.put(aresta.destino, novaDistancia);
					anteriores.put(aresta.destino, atual);
					fila.add(new Aresta(aresta.destino, novaDistancia));
				}
			}
		}

		List<String> caminho = reconstruirCaminho(anteriores, inicio, fim);
		if (!caminho.isEmpty()) {
			caminhosAlternativos.add(caminho);
		}

		return caminhosAlternativos;
	}
}