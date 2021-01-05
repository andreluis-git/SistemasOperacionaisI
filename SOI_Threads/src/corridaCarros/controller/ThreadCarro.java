package controller;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;


public class ThreadCarro extends Thread {
	static int colocacao = 0;
	private JLabel lblCarro;
	private JButton btnCorrer;
	int distanciaPercorrida = 0;
	private JLabel txtVencedor;
	private JLabel txtPerdedor;
	private JButton btnReset;
	
	public ThreadCarro(JLabel lblCarro, JButton btnCorrer, JLabel txtVencedor, JLabel txtPerdedor, JButton btnReset) {
		this.lblCarro = lblCarro;
		this.btnCorrer = btnCorrer;
		this.txtVencedor = txtVencedor;
		this.txtPerdedor = txtPerdedor;
		this.btnReset = btnReset;
	}
	
	private void carroMovendo() {
		Random random = new Random();
		
		Rectangle posicao;
		posicao = lblCarro.getBounds();
		lblCarro.setBounds(posicao);
		distanciaPercorrida = posicao.x + posicao.width;
		int distancia;
		distancia = random.nextInt(20);
		if (distanciaPercorrida + distancia > 414) {
			posicao.x = 414 - posicao.width;
		} else {
			posicao.x += distancia;
		}
		lblCarro.setBounds(posicao);
		distanciaPercorrida += distancia;
	}	
	
	private void carroParado() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	private void colocacaoCarro() {
		colocacao++;
		if (colocacao == 1) {
			txtVencedor.setText(lblCarro.getText());
		} else {
			btnReset.setEnabled(true);
			txtPerdedor.setText(lblCarro.getText());
			colocacao = 0;
		}
	}
	
	@Override
	public void run() {
		btnCorrer.setEnabled(false);
		while (distanciaPercorrida <= 414) {
			carroMovendo();
			carroParado();
		}
		colocacaoCarro();
	}
}