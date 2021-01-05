package f1;

import java.util.concurrent.Semaphore;

public class ThreadEscuderia extends Thread{
	
	private int idEscuderia;
	private int idCarro;
	static int indice;
	static double[][] tempoVolta = new double[3][14];
	private double tempoVoltaIndividual = 0;
	private Semaphore carrosPista;
	private Semaphore carroEscuderia;
	private Semaphore tabela;
	
//	linha 0 -> Escuderia
//	linha 1 -> Carro
//	linha 2 -> Tempo de volta
	
	public ThreadEscuderia(int idEscuderia, int idCarro, Semaphore carrosPista, Semaphore carroEscuderia, Semaphore tabela) {
		this.idEscuderia = idEscuderia;
		this.idCarro = idCarro;
		this.carrosPista = carrosPista;
		this.carroEscuderia = carroEscuderia;
		this.tabela = tabela;
	}
	
	public void run() {
		try {
			carrosPista.acquire();
			carroEscuderia.acquire();
			carroCorrendo();
			tabela.acquire();
			salvarTempo();
			if(indice == 14) {
				organizaTabela();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			carrosPista.release();
			carroEscuderia.release();
			tabela.release();
		}
	}

	private void carroCorrendo() {
		int distPista = 2000;
		int distPercorrida = 0;
		int deslocamento;
		int voltas;
		double tempoInicial;
		double tempoFinal;
		double tempoTotal;
		for (voltas = 0; voltas < 3; voltas++) {
//			System.out.println("#Carro " + idCarro + " | Escuderia " + idEscuderia + " está na pista");
			tempoInicial = System.nanoTime();
			while (distPercorrida < distPista) {
				deslocamento = (int)((Math.random()*151)+100);
				distPercorrida += deslocamento;
			}
			tempoFinal = System.nanoTime();
			tempoTotal = tempoFinal - tempoInicial;
			tempoTotal /= Math.pow(10, 9);
			System.out.println("#Carro " + idCarro + " | Escuderia " + idEscuderia + " fez a volta " + voltas + " em " + tempoTotal);
			if (tempoVoltaIndividual == 0 || tempoTotal < tempoVoltaIndividual) {
				tempoVoltaIndividual = tempoTotal;
			}
			try {
				sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("#Carro " + idCarro + " | Escuderia " + idEscuderia + " saiu da pista");
	}

	
	private void organizaTabela() {
		
		double auxEscuderia;
		double auxCarro;
		double auxTempo;
		
		int tamanhoTabela = tempoVolta[0].length;
		
		for(int i = 0; i < tamanhoTabela-1; i++) {
			for(int j = i+1; j < tamanhoTabela; j++) {
				if(tempoVolta[2][i] > tempoVolta[2][j]) {
					auxEscuderia = tempoVolta[0][i];
					auxCarro = tempoVolta[1][i];
					auxTempo = tempoVolta[2][i];
					tempoVolta[0][i] = tempoVolta[0][j];
					tempoVolta[1][i] = tempoVolta[1][j];
					tempoVolta[2][i] = tempoVolta[2][j];
					tempoVolta[0][j] = auxEscuderia;
					tempoVolta[1][j] = auxCarro;
					tempoVolta[2][j] = auxTempo;
				}
			}
		}
//		System.out.println(Arrays.deepToString(tempoVolta));
		System.out.println("---------------------Grid de largada ---------------------------");
		for (int i = 0; i < 14; i++) {
			System.out.println(i+1 + "a. posição - Carro " + tempoVolta[1][i] + " | Escuderia " + tempoVolta[0][i]);
		}
	}

	private void salvarTempo() {
		tempoVolta[0][indice] = idEscuderia;
		tempoVolta[1][indice] = idCarro;
		tempoVolta[2][indice] = tempoVoltaIndividual;
		indice++;
	}
}
