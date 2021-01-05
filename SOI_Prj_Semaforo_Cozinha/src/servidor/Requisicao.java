package servidor;

import java.util.concurrent.Semaphore;

public class Requisicao {
	
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int idThread = 1; idThread <= 21; idThread++) {
			Thread tRequisicao = new ThreadServidor(idThread, semaforo);
			tRequisicao.start();
		}
	}

}
