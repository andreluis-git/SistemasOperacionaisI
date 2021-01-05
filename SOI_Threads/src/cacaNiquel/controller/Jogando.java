package controller;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Jogando extends Thread {
	
	static int status = 0;
	private JLabel lblNewLabel;
	private JButton btnJogar;
	private int contador = 1;
	
	public Jogando(JLabel lblNewLabel, JButton btnJogar) {
		this.lblNewLabel = lblNewLabel;
		this.btnJogar = btnJogar;
	}
	
	private void numerosRodada() {
		btnJogar.setEnabled(false);
		String texto = "";
		switch (contador) {
			case 1:
				texto = "1";
				break;
			case 2:
				texto = "2";
				break;
			case 3:
				texto = "3";
				break;
			case 4:
				texto = "4";
				break;
			case 5:
				texto = "5";
				break;
			case 6:
				texto = "6";
				break;
			case 7:
				texto = "7";
				break;
		}
		lblNewLabel.setText(texto);
		contador++;
		if (contador == 7) {
			contador = 1;
		}
	}
	
	private void mostraNumero() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	private void verificaStatus() {
		status++;
		if (status == 3) {
			btnJogar.setEnabled(true);
			status = 0;
		}
	}
	
	@Override
	public void run() {
		Random random = new Random();
		int rodadas = random.nextInt(150)+1;
		for (int i = 0; i < rodadas; i++) {
			numerosRodada();
			mostraNumero();
		}
		verificaStatus();
	}
}