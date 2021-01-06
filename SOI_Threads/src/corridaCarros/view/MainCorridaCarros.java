package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CorridaController;
import controller.ResetCorrida;

public class MainCorridaCarros extends JFrame{	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				MainCorridaCarros frame = new MainCorridaCarros();
				frame.setVisible(true);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}
	public MainCorridaCarros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setForeground(Color.BLUE);
		lblCarro1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCarro1.setBounds(10, 52, 58, 23);
		contentPane.add(lblCarro1);
		
		final JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setForeground(Color.RED);
		lblCarro2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCarro2.setBounds(10, 99, 58, 23);
		contentPane.add(lblCarro2);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(10, 227, 89, 23);
		contentPane.add(btnCorrer);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 86, 414, 2);
		contentPane.add(separator);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVencedor.setBounds(104, 159, 58, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPerdedor.setBounds(104, 190, 58, 14);
		contentPane.add(lblPerdedor);
		
		JLabel lblTxtPerdedor = new JLabel("");
		lblTxtPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtPerdedor.setBounds(172, 187, 86, 20);
		lblTxtPerdedor.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		lblTxtPerdedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblTxtPerdedor);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(109, 227, 89, 23);
		btnReset.setEnabled(false);
		contentPane.add(btnReset);
		
		JLabel lblTxtVencedor = new JLabel("");
		lblTxtVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtVencedor.setBounds(172, 159, 86, 20);
		lblTxtVencedor.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		lblTxtVencedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblTxtVencedor);
		
		CorridaController corridaController = new CorridaController(lblCarro1, lblCarro2, btnCorrer, lblTxtVencedor , 
				lblTxtPerdedor, btnReset);
		btnCorrer.addActionListener(corridaController);
		
		ResetCorrida resetCorrida = new ResetCorrida(lblCarro1, lblCarro2, btnCorrer, lblTxtVencedor, 
				lblTxtPerdedor, btnReset);
		btnReset.addActionListener(resetCorrida);
	}
	
}