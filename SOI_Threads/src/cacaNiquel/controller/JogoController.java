package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class JogoController implements ActionListener{
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnJogar;
	
	public JogoController(JLabel lblNewLabel, JLabel lblNewLabel_1, JLabel lblNewLabel_2, JButton btnJogar){
		this.lblNewLabel = lblNewLabel;
		this.lblNewLabel_1 = lblNewLabel_1;
		this.lblNewLabel_2 = lblNewLabel_2;
		this.btnJogar = btnJogar;
	}
	
	private void acaoJogar(){
		btnJogar.setEnabled(false);
		Thread n1 = new Jogando(lblNewLabel, btnJogar);
		Thread n2 = new Jogando(lblNewLabel_1, btnJogar);
		Thread n3 = new Jogando(lblNewLabel_2, btnJogar);
		n1.start();
		n2.start();
		n3.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		acaoJogar();
	}
}