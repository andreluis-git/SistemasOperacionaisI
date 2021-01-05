package controller;

import java.util.Random;

public class CorridaSapos extends Thread{	
	
	String sapo;
	static int colocacao;
	int distanciaPercorrida = 0;
	int distanciaTotal = 30;
	Random random = new Random();
	int pulo;
	
	public CorridaSapos(int idThread) {
		this.sapo = "Sapo " + idThread;
	}
	
	private void sapoPulando() {
		pulo = random.nextInt(6);
		distanciaPercorrida += pulo;
	}
	
	private void situacao() {
		System.out.println(sapo + " pulou: " + pulo + " metros. Distância percorrida: " + distanciaPercorrida + " metros.");
	}
	
	private void descansa() {
		yield();
	}
	
	private void colocacaoSapo() {
		colocacao++;
		System.out.println(sapo + " foi o " + colocacao + "º colocado.");
//		System.out.println(MessageFormat.format("{0} foi o {1}º colocado.", sapo, colocacao));
//		System.out.println(String.format("%s foi o %x colocado.", sapo, colocacao));
	}
	
	@Override
	public void run() {
		while (distanciaPercorrida < distanciaTotal) {
			sapoPulando();
			situacao();
			descansa();
		}
		colocacaoSapo();
	}
}