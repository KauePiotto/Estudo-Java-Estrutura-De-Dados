package aula03;

public class TesteObjeto {
	public static void main(String[] args) throws Exception {
		VetorObjeto vetor = new VetorObjeto(5);

		Contato c1 = new Contato("Claudio", "9999-2525", "claudio@gmail.com");
		Contato c2 = new Contato("Daniel", "9999-7213", "daniel@gmail.com");
		Contato c3 = new Contato("Miguel", "9999-0101", "miguel@gmail.com");

		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);

		System.out.println("Quantidade de dados do vetor: " + vetor.tamanho());

		System.out.println("Dados do vetor: " + vetor.toString());
	}
}
