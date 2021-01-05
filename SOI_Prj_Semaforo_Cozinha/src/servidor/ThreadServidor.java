package servidor;

import java.util.concurrent.Semaphore;

public class ThreadServidor extends Thread{
	
	private int idThread;
	private double resto = idThread % 3;
	
	private Semaphore semaforo;
	
	public ThreadServidor(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	

	private void realizarCalculos() {
		System.out.println("#" + idThread + " - Realizando Cálculo...");
		if (resto == 1) {
			int tempoCalc = (int)(Math.random() * 801) + 200;
			try {
				sleep(tempoCalc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} else if (resto == 2){
			int tempoCalc = (int)(Math.random() * 1001) + 500;
			try {
				sleep(tempoCalc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (resto == 0) {
			int tempoCalc = (int)(Math.random() * 1001) + 1000;
			try {
				sleep(tempoCalc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("#" + idThread + " - Cálculo Inválido");
		}
	}

	private void realizarTransacao() {
		System.out.println("#" + idThread + " - Realizando Transação...");
		if (resto == 1) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (resto == 2 || resto == 0){
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("#" + idThread + " - Transação Inválida");
		}
	}
	
	@Override
	public void run() {
		int numTransacoes = 0;
		if (resto == 2 || resto == 0) {
			numTransacoes = 3;
		}else {
			numTransacoes = 2;
		}
		for(int i = 0; i < numTransacoes; i++) {
			realizarCalculos();
			try {
				semaforo.acquire();
				realizarTransacao();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
		System.out.println("#" + idThread + " - Finalizou");
	}


}
