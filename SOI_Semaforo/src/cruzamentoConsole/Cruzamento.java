package cruzamentoConsole;

import java.util.concurrent.Semaphore;


public class Cruzamento {
	
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		Thread tCarro1 = new ThreadCarro(1, semaforo, "Norte para Sul", 5, 0);
		Thread tCarro2 = new ThreadCarro(2, semaforo, "Sul para Norte", -5, 0);
		Thread tCarro3 = new ThreadCarro(3, semaforo, "Leste para Oeste", 0, 5);
		Thread tCarro4 = new ThreadCarro(4, semaforo, "Oeste para Leste", 0, -5);
		tCarro1.start();
		tCarro2.start();
		tCarro3.start();
		tCarro4.start();
	}
}
