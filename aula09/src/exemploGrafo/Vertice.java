package exemploGrafo;

import java.util.ArrayList;

public class Vertice<Tipo> {
	private Tipo dado;
	private ArrayList<Aresta<Tipo>> arestaEntrada;
	private ArrayList<Aresta<Tipo>> arestaSaida;
}
