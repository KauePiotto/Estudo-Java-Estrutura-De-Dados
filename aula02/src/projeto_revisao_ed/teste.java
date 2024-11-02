package projeto_revisao_ed;

public class teste {
   
	public static void main(String[] args)throws Exception {
		Vetor vetor = new Vetor(500);

			vetor.adiciona("Elemento 1");
			vetor.adiciona("Elemento 2");
			
			System.out.println("A quantidade de informações no vetor é: "+ vetor.tamanho());
			System.out.println("Dados do vetor: "+vetor.toString());
			System.out.println("Informação na posição: "+vetor.busca(1));
			System.out.println("----------------------------------------------------------");
			vetor.adicionarInicio(0, "Elemento 0");
			System.out.println("A quantidade de informações no vetor é: "+ vetor.tamanho());
			System.out.println("Dados do vetor: "+vetor.toString());
			System.out.println("Informação na posição: "+vetor.busca(1));
			
  }
}