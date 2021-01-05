package controller;

public class SomaVetor extends Thread {
	
	private int linha;
	private int[] vetor = new int [5];

	public SomaVetor(int linha, int[] vetor) {
		this.vetor = vetor;
		this.linha = linha;
	}

	public void run() {
		int soma = 0;
		for (int i : vetor) {
			soma += i;
		}
		System.out.println("Linha: " + linha + "\nSoma: " + soma);
	}
	
}