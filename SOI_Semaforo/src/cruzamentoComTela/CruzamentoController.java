package cruzamentoComTela;

import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class CruzamentoController extends Thread{
	
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JLabel lblCarro3;
	private JLabel lblCarro4;
	private Semaphore semaforo;
	
	public CruzamentoController(JLabel lblCarro1, JLabel lblCarro2, JLabel lblCarro3, JLabel lblCarro4, Semaphore semaforo) {
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.lblCarro3 = lblCarro3;
		this.lblCarro4 = lblCarro4;
		this.semaforo = semaforo;
	}
	
	private void iniciaThread() {
		Thread tCarro1 = new ThreadCruzamento(lblCarro1, semaforo);
		Thread tCarro2 = new ThreadCruzamento(lblCarro2, semaforo);
		Thread tCarro3 = new ThreadCruzamento(lblCarro3, semaforo);
		Thread tCarro4 = new ThreadCruzamento(lblCarro4, semaforo);
		tCarro1.start();
		tCarro2.start();
		tCarro3.start();
		tCarro4.start();
	}

	@Override
	public void run() {
		iniciaThread();
	}
}
