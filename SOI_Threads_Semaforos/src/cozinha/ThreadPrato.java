package cozinha;

import java.util.concurrent.Semaphore;

public class ThreadPrato extends Thread{
	
	private int idPrato;
	private Semaphore semaforo;
	private int pedido;
	private String prato;
	private int resto;

	public ThreadPrato(int idPrato, int pedido, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.pedido = pedido;
		this.semaforo = semaforo;
	}
	
	private void cozinharPrato() {
		resto = pedido % 2;
		if (resto == 0) {
			prato = "Lasanha a Bolonhesa";
			System.out.println("#" + idPrato + " Cozinhando " + prato + "...");
			int tempoPreparo = (int)((Math.random()*600)+600);
			for (int cozinhando = 0; cozinhando < tempoPreparo; cozinhando += 100) {
				try {
					sleep(100);
					int porcentagem = ((cozinhando * 100) / tempoPreparo);
					System.out.println("#" + idPrato + prato + " - " + porcentagem + "%.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		} else {
			prato = "Sopa de Cebola";
			System.out.println("#" + idPrato + " Cozinhando " + prato + "...");
			int tempoPreparo = (int)((Math.random()*300)+500);
			for (int cozinhando = 0; cozinhando < tempoPreparo; cozinhando += 100) {
				try {
					sleep(100);
					int porcentagem = (cozinhando * 100) / tempoPreparo;
					System.out.println("#" + idPrato + prato + " - " + porcentagem + "%.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		System.out.println("#" + idPrato + prato + " - 100%, o prato está pronto.");
	}
	
	private void entregarPrato() {
		try {
			System.out.println("#" + idPrato + " - Entregando prato.");
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		cozinharPrato();
		try {
			semaforo.acquire();
			entregarPrato();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

}
