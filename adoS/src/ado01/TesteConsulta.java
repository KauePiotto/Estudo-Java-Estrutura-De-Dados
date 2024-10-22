package ado01;

import javax.swing.JOptionPane;

public class TesteConsulta {
	public static void main(String[] args) throws Exception {

		Vetor vetor = new Vetor(10);

		int indice, indiceBuscar, indiceAlterar;
		String opcao, nome, telefone, data, hora, novaData, novoTelefone, novoNome, novaHora;
		Consulta buscar;

		do {
			opcao = JOptionPane.showInputDialog(null,
					"Escolha uma opção:\n 1 - Marcar Consulta\n 2 - Buscar Consulta \n 3 - Alterar Consulta\n 4 - Cancelar Consulta\n 5 - Sair ");

			switch (opcao) {
			case "1": // Marcar Consulta
				nome = JOptionPane.showInputDialog("Informe o nome");
				telefone = JOptionPane.showInputDialog("Informe o telefone");
				data = JOptionPane.showInputDialog("Informe a data da consulta");
				hora = JOptionPane.showInputDialog("Informe a hora da consulta");

				vetor.MarcarConsulta(new Consulta(nome, telefone, data, hora));

				JOptionPane.showMessageDialog(null, "Dados da Consulta\nNome: " + nome + "\nTelefone: " + telefone
						+ "\nData da Consulta: " + data + "\nHora da Consulta:" + hora);
				break;
			case "2":// Buscar Consulta

				indiceBuscar = Integer.parseInt(JOptionPane.showInputDialog("Índice consulta que deseja buscar: "));

				buscar = vetor.BuscarConsulta(indiceBuscar);

				JOptionPane.showMessageDialog(null, buscar != null ? buscar : "Consulta não encontrada");
			case "3":// Alterar Consulta
				indiceAlterar = Integer.parseInt(JOptionPane.showInputDialog("Índice da consulta que deseja alterar: "));
				novoNome = JOptionPane.showInputDialog("Novo Nome:");
				novoTelefone = JOptionPane.showInputDialog("Novo Telefone:");
				novaData = JOptionPane.showInputDialog("Nova Data:");
				novaHora = JOptionPane.showInputDialog("Nova Hora:");

				vetor.AlterarConsulta(indiceAlterar, new Consulta(novoNome, novoTelefone, novaData, novaHora));
				break;

			case "4":// Cancelar Consulta
				indice = Integer.parseInt(JOptionPane.showInputDialog("Índice da consulta que deseja excluir: "));
				vetor.ExcluirConsulta(indice);
				
				break;

			case "5":// Sair
				break;

			default:
				JOptionPane.showMessageDialog(null,"Escolha uma das opções acima!");
			}
		} while (!opcao.equals("5"));
	}
}
