package corredores;

import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread{
	
	private int idPessoa;
	private Semaphore semaforo;
	
	public ThreadPessoas(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
			cruzarPorta();
			portaCruzada();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void pessoaAndando() {
		int distCorredor = 200;
		int distPercorrida = 0;
		int deslocamento;
		while (distPercorrida < distCorredor) {
			deslocamento = (int)(Math.random()*5) + 2;
			distPercorrida += deslocamento;
			System.out.println("#Pessoa " + idPessoa + " andou " + distPercorrida);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#Pessoa " + idPessoa + " chegou na porta.");
	}
	

	private void cruzarPorta() {
		System.out.println("#Pessoa " + idPessoa + " cruzando a porta.");
		int tempo = (int)(Math.random()*2) +1;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void portaCruzada() {
		System.out.println("#Pessoa " + idPessoa + " cruzou a porta.");
	}
	
}
