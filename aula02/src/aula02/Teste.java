package aula02;

public class Teste {
	public static void main(String[] args) throws Exception {
		Vetor vetor = new Vetor(5);

		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elementos 2");
		vetor.adiciona("Elementos 3");
		vetor.adiciona("Elementos 4");
		vetor.adiciona("Elementos 5");
		vetor.adiciona("Elementos 6");
		vetor.adiciona("Elementos 7");
		
		System.out.println("A quantidade de informacoes no vetor e: "+vetor.tamanho());
		System.out.println("Dados do Veotr: "+vetor.toString());
		
		vetor.remove(3);
		
		System.out.println("A quantidade de informacoes no vetor e: "+vetor.tamanho());
		System.out.println("Dados do Veotr: "+vetor.toString());
	}
}
