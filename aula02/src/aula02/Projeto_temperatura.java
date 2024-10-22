package aula02;

import javax.swing.JOptionPane;

public class Projeto_temperatura {
	public static void main(String[] args) {
		double[] temperatura = new double[7];
		double soma, media;
		int contador, dias_acima, dias_abaixo;
		soma = 0;

		for (contador = 0; contador < 7; contador++) {
			temperatura[contador] = Double
					.parseDouble(JOptionPane.showInputDialog("Digite a " + (contador + 1) + " ° temperatura: "));
			soma = soma + temperatura[contador];
		}

		media = soma / 7;
		dias_acima = 0;
		dias_abaixo = 0;

		for (contador = 0; contador < 7; contador++) {
			if (temperatura[contador] > media) {
				dias_acima = dias_acima + 1;
			}
			if (temperatura[contador] < media) {
				dias_abaixo = dias_abaixo + 1;
			}
		}
		JOptionPane.showMessageDialog(null,"A Média das temperaturas é: "+media);
		JOptionPane.showMessageDialog(null,"A quantidade de dias acima da média é: "+dias_acima);
		JOptionPane.showMessageDialog(null,"A quantidade de dias abaixo da média é: "+dias_abaixo);
	}
}
