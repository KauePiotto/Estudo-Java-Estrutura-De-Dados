package aula001;

import java.util.Scanner;

public class Aula001 {
	public static void main(String[] args) {
	
	double [] temperatura = new double [7];
 	int contador = 0,acima ,abaixo;
 	double soma = 0, media ;
 	Scanner scan = new Scanner(System.in);
 	
 	for(int i = 0; i < temperatura.length; i++) {
	 System.out.println("Digite a "+(i+1)+"º temperatura");
	 temperatura[i] = scan.nextDouble();
	 soma = soma + temperatura[i];
 	}
 	
 	media = soma / 7;
 	acima = 0;
 	abaixo = 0;
 	
 	for(int i = 0; i < temperatura.length; i++) {
 		if(temperatura[i] > media) {
 			acima = acima + 1;
 		}
 		if(temperatura[i] < media) {
 			abaixo = abaixo + 1;
 		}
 	}
 	System.out.println("Total de dias que a temperatura ficou acima da média "+acima);
 	System.out.println("Total de dias que a temperatura ficou abaixo da média "+abaixo);
  }
}