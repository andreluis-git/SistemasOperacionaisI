package view;

import javax.swing.JOptionPane;

import controller.ProcessController;

public class MainKillProcess{
	
	public static void main(String[] args) {
		ProcessController processController = new ProcessController();
		String os = processController.os();
		int User = 0;
		while (User != 9) {
			User = Integer.parseInt(JOptionPane.showInputDialog("Menu"
					+ "\nDigite o numero da opcao desejada:"
					+ "\n 1 - Mostrar Processos"
					+ "\n 2 - Matar Processo"
					+ "\n 9 - Finalizar"));
			switch (User) {
			case 1:
				processController.readProcess(os);
				break;
			case 2:
				String param = JOptionPane.showInputDialog("Digite o Nome ou PID do processo que deseja matar:");
				processController.killProcess(os, param);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor digitado esta fora das opcoes.");
			}
		}
	}
}