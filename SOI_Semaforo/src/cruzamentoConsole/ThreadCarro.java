package cruzamentoConsole;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	
	private int idCarro;
	private Semaphore semaforo;
	private String direcao;
	private int posY;
	private int posX;	
	
	public ThreadCarro(int idCarro, Semaphore semaforo, String direcao, int posY, int posX) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.direcao = direcao;
		this.posY = posY;
		this.posX = posX;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			carroAndando();
			carroAtravessou();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void carroAndando() {
		int distTotal = 10;
		int distPercorrida = 0;
		int deslocamento;
		while (distPercorrida < distTotal) {
			deslocamento = (int)(Math.random()*3)+1;
			distPercorrida += deslocamento;
			if(direcao == "Norte para Sul") {
				posY -= deslocamento;
			} else if (direcao == "Sul para Norte"){
				posY += deslocamento;
			} else if (direcao == "Leste para Oeste"){
				posX -= deslocamento;
			} else if (direcao == "Oeste para Leste"){
				posX += deslocamento;
			}
			System.out.println("#Carro " + idCarro + " cruzando " + direcao);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void carroAtravessou() {
		System.out.println("#Carro " + idCarro + " atravessou de " + direcao);
	}
	
	
}
