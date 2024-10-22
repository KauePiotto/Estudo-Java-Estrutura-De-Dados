package exemploGrafo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grafo<TIPO> {
	private ArrayList<Vertice<TIPO>> vertices;
	private ArrayList<Aresta<TIPO>> Arestas;

	public Grafo() {
		this.vertices = new ArrayList<Vertice<TIPO>>();
		this.Arestas = new ArrayList<Aresta<TIPO>>();
	}

	public void adcionarVertice(TIPO dado) {
		Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
		this.vertices.add(novoVertice);
	}

	public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim) {
		Vertice<TIPO> inicio = this.getVertice(dadoInicio);
		Vertice<TIPO> fim = this.getVertice(dadoFim);
		Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
		inicio.adicionarArestaSaida(aresta);
		fim.adicionarArestaSaida(aresta);
		this.Arestas.add(aresta);
	}

	public Vertice<TIPO> getVertice(TIPO dado) {
		Vertice<TIPO> vertice = null;
		for (int i = 0; i < this.vertices.size(); i++) {
			if (this.vertices.get(i).getDado().equals(dado)) {
				vertice = this.vertices.get(i);
				break;
			}
		}
		return vertice;
	}

	public void BuscarLargura() {
		ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
		ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
		Vertice<TIPO> atual = this.vertices.get(0);
		marcados.add(atual);
		JOptionPane.showMessageDialog(null, atual.getDado());
		fila.add(atual);
		while (fila.size() > 0) {
			Vertice<TIPO> visitado = fila.get(0);
			for (int i = 0; i < visitado.getArestaSaida().size(); i++) {
				Vertice<TIPO> proximo = visitado.getArestaSaida().get(i).getFim();
				if (!marcados.contains(proximo)) {
					marcados.add(proximo);
					JOptionPane.showMessageDialog(null, proximo.getDado());
					fila.add(proximo);
				}
			}
			fila.remove(0);
		}
	}
}