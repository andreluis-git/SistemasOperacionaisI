package cozinha;

import java.util.concurrent.Semaphore;

public class Cozinheiro {
	
	public static void main(String[] args) {
		
		int pedido;
		Semaphore semaforo = new Semaphore(1);
		
		for(int idPrato = 0; idPrato < 5; idPrato++) {
			pedido = (int)((Math.random()*2)+1);
			Thread prato = new ThreadPrato(idPrato, pedido,semaforo);
			prato.start();
		}
	}
}
