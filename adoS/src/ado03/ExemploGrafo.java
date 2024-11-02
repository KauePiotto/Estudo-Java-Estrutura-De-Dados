package ado03;

import javax.swing.JOptionPane;

public class ExemploGrafo {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		String nome;
		int qntParticipantes;
		
		// Solicita a quantidade de participantes
		qntParticipantes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de participantes"));

		// Le os nomes dos participantes
		for (int i = 0; i < qntParticipantes; i++) {
			nome = JOptionPane.showInputDialog("Digite o nome dos participantes " + (i + 1) + ":");
			grafo.addParticipantes(new Vertice(nome));
		}
		// Realiza o sorteio
		grafo.realizarSorteio();
		grafo.mostrarConexoes();
	}
}