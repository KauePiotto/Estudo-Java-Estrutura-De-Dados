package exemploGrafo;

public class ExemploGrafo {
	public static void main(String[] args) {
		Grafo<String> grafo = new Grafo<String>();

		grafo.adcionarVertice("Paulo");
		grafo.adcionarVertice("Lorenzo");
		grafo.adcionarVertice("Cleuza");
		grafo.adcionarVertice("Kleber");
		grafo.adcionarVertice("Claudio");

		grafo.adicionarAresta(2.0, "Paulo", "Lorenzo");
		grafo.adicionarAresta(3.0, "Lorenzo", "Kleber");
		grafo.adicionarAresta(1.0, "Kleber", "Cleuza");
		grafo.adicionarAresta(2.0, "Claudio", "Lorenzo");
		grafo.adicionarAresta(3.0, "Claudio", "Paulo");
	}
}