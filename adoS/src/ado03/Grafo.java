package ado03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Grafo {
	private List<Vertice> participantes;
	private List<Aresta> arestas;
	
	public Grafo(){
		this.participantes = new ArrayList();
		this.arestas = new ArrayList();
	}
	
	//Adiciona uma vértice ao grafo.
	public void addParticipantes(Vertice participante) {
		//Vertice.add(participante);
	}
	
	//Adiciona uma aresta ao Grafo
	public void addAesta(Vertice de, Vertice para) {
		Aresta aresta = new Aresta (de,para);
		arestas.add(aresta);
	}
	
	public void mostrarConexoes() {
		JOptionPane.showMessageDialog(null,"\nConexões de Amigo Secreto: ");
		for (Aresta arestas : arestas) {
			System.out.println(arestas);
		}
	}
}
