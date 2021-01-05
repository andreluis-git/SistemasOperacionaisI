package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.JogoController;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(207, 166, 89, 23);
		contentPane.add(btnJogar);
		
		lblNewLabel = new JLabel("X");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(41, 48, 71, 71);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(122, 48, 71, 71);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(207, 48, 71, 71);
		contentPane.add(lblNewLabel_2);
		
		JogoController jogoController = new JogoController(lblNewLabel, lblNewLabel_1, lblNewLabel_2, btnJogar);
		btnJogar.addActionListener(jogoController);
	}

}
