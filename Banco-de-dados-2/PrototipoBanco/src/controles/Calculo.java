package controles;

import java.util.Random;

public class Calculo {
	public Calculo() {

	}

	public static int Calcular(String nome, String bairro, String cidade, String email) {
		int a, b, c, d;
		for (a = 0; a < nome.length(); a++) {
		}
		for (b = 0; b < bairro.length(); b++) {
		}
		for (c = 0; c < cidade.length(); c++) {
		}
		for (d = 0; d < email.length(); d++) {
		}
		int result = formula(a, b, c, d);
		return result;
	}

	private static int formula(int a, int b, int c, int d) {
		Random alea = new Random();
		int part1 = a / 2;
		int part2 = c + d;
		int part3 = part2 * alea.nextInt(21);
		System.out.println(part3 - part1 + " COLD");
		return part3 - part1;
	}

}
