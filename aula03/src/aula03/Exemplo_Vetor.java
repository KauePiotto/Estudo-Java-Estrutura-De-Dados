package aula03;

import java.util.ArrayList;

public class Exemplo_Vetor {
	public static void main(String[] args) {
		ArrayList<String> vetor = new ArrayList<String>();

		vetor.add("Claudio");
		vetor.add("Miguel");
		vetor.add("Ana");

		System.out.println("A quantidade de infromações no vetor: " + vetor.size());

		System.out.println("Dados do vetor: " + vetor.toString());
	}
}
