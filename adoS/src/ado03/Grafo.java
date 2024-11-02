package ado03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class Grafo {
	private List<Vertice> participantes;
	private List<Aresta> arestas;
	

	public Grafo() {
		this.participantes = new ArrayList();
		this.arestas = new ArrayList();
	}

	// Adiciona uma vértice ao grafo.
	public void addParticipantes(Vertice participante) {
		participantes.add(participante);
	}

	// Adiciona uma aresta ao Grafo
	public void addAesta(Vertice de, Vertice para) {
		Aresta aresta = new Aresta(de, para);
		arestas.add(aresta);
	}

	// Realiza o sorteio
	public void realizarSorteio() {
		List<Vertice> resultado = new ArrayList<>(participantes);
		
		//Embaralha para ninguem tirar si mesmo
		boolean valido = false;
		while(!valido) {
			valido = true;
			Collections.shuffle(resultado);
			for(int i = 0; i < participantes.size(); i++) {
				if(participantes.get(i).equals(resultado.get(i))) {
					valido = false;
					break;
				}
			}
		}
		
		//Cria as arestas para as conexoes de amigo secreto
		for(int i = 0; i < participantes.size(); i++) {
			addAesta(participantes.get(i), resultado.get(i));
		}
	}
		
	// Exibe as Conexões do amigo secreto
	public void mostrarConexoes() {
		StringBuilder mensagem = new StringBuilder("Conexões de Amigo Secreto:\n ");
		for (Aresta arestas : arestas) {
			mensagem.append(arestas).append("\n");
		}
		JOptionPane.showMessageDialog(null, mensagem.toString(),"Resultado do Amigo Secreto", JOptionPane.INFORMATION_MESSAGE);
	}
}