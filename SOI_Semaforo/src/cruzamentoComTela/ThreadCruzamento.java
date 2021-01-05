package cruzamentoComTela;

import java.awt.Rectangle;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class ThreadCruzamento extends Thread{
	
	private JLabel lblCarro;
	private Semaphore semaforo;
	
	
	public ThreadCruzamento(JLabel lblCarro, Semaphore semaforo) {
		this.lblCarro = lblCarro;
		this.semaforo = semaforo;
	}
	
	private void carroAndando() {
		Rectangle posicao;
		posicao = lblCarro.getBounds();
		lblCarro.setBounds(posicao);
		
		int distTotal = 240;
		int distPercorrida = 0;
		int deslocamento;
		while (distPercorrida < distTotal) {
			deslocamento = (int)(Math.random()*3)+1;
			distPercorrida += deslocamento;
			if(lblCarro.getText() == "Carro2") {
				posicao.y -= deslocamento;
				lblCarro.setBounds(posicao);
			} else if (lblCarro.getText() == "Carro1"){
				posicao.y += deslocamento;
				lblCarro.setBounds(posicao);
			} else if (lblCarro.getText() == "Carro3"){
				posicao.x -= deslocamento;
				lblCarro.setBounds(posicao);
			} else if (lblCarro.getText() == "Carro4"){
				posicao.x += deslocamento;
				lblCarro.setBounds(posicao);
			}
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			carroAndando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

}
