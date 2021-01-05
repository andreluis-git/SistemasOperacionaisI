package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CorridaController implements ActionListener{
	
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JButton btnCorrer;
	private JLabel txtVencedor;
	private JLabel txtPerdedor;
	private JButton btnReset;
	
	public CorridaController(JLabel lblCarro1,JLabel lblCarro2, JButton btnCorrer, JLabel txtVencedor, 
			JLabel txtPerdedor, JButton btnReset) {
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.btnCorrer = btnCorrer;
		this.txtVencedor = txtVencedor;
		this.txtPerdedor = txtPerdedor;
		this.btnReset = btnReset;
	}
	
	private void botaoCorrer(){
		Thread t1 = new ThreadCarro(lblCarro1, btnCorrer, txtVencedor, txtPerdedor, btnReset);
		Thread t2 = new ThreadCarro(lblCarro2, btnCorrer, txtVencedor, txtPerdedor, btnReset);
		t1.start();
		t2.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		botaoCorrer();
	}
}