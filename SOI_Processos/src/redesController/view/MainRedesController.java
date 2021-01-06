package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class MainRedesController{
	
	public static void main(String[] args) {
		int User = 0;
		RedesController redesController = new RedesController();
		String os = redesController.os();
		while (User != 9) {
			User = Integer.parseInt(JOptionPane.showInputDialog("Menu"
					+ "\nDigite o numero da opcao desejada:"
					+ "\n 1 - IP"
					+ "\n 2 - Ping"
					+ "\n 9 - Finalizar"));
			switch (User) {		
			case 1:			
				redesController.ip(os);
				break;
			case 2:
				redesController.ping(os);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor digitado está fora das opcoes.");
			}
		}
	}
}