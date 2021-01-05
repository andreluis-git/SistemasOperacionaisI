package cruzamentoComTela;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Semaphore semaforo = new Semaphore(1);

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
		setBounds(100, 100, 460, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 141, 170, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 237, 170, 1);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(274, 237, 170, 1);
		contentPane.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(274, 141, 170, 1);
		contentPane.add(separator_1_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(169, 237, 1, 170);
		contentPane.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(274, 237, 1, 170);
		contentPane.add(separator_2_1);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_2_2.setBounds(274, -5, 1, 147);
		contentPane.add(separator_2_2);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setOrientation(SwingConstants.VERTICAL);
		separator_2_3.setBounds(169, -5, 1, 147);
		contentPane.add(separator_2_3);
		
		JLabel lblCarro1 = new JLabel("Carro3");
		lblCarro1.setBounds(274, 153, 74, 42);
		contentPane.add(lblCarro1);
		ImageIcon carImage = new ImageIcon("src/cruzamentoComTela/img-carro1.png");
		Image img = carImage.getImage();
		Image newImg = img.getScaledInstance(lblCarro1.getWidth(), lblCarro1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lblCarro1.setIcon(image);
				
		JLabel lblCarro2 = new JLabel("Carro1");
		lblCarro2.setBounds(180, 68, 42, 74);
		contentPane.add(lblCarro2);
		ImageIcon carImage2 = new ImageIcon("src/cruzamentoComTela/img-carro2.jpg");
		Image img2 = carImage2.getImage();
		Image newImg2 = img2.getScaledInstance(lblCarro2.getWidth(), lblCarro2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image2 = new ImageIcon(newImg2);
		lblCarro2.setIcon(image2);
		
		JLabel lblCarro3 = new JLabel("Carro2");
		lblCarro3.setBounds(222, 240, 42, 74);
		contentPane.add(lblCarro3);
		ImageIcon carImage3 = new ImageIcon("src/cruzamentoComTela/img-carro3.jpg");
		Image img3 = carImage3.getImage();
		Image newImg3 = img3.getScaledInstance(lblCarro3.getWidth(), lblCarro3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image3 = new ImageIcon(newImg3);
		lblCarro3.setIcon(image3);
		
		JLabel lblCarro4 = new JLabel("Carro4");
		lblCarro4.setBounds(96, 192, 74, 42);
		contentPane.add(lblCarro4);
		ImageIcon carImage4 = new ImageIcon("src/cruzamentoComTela/img-carro4.jpg");
		Image img4 = carImage4.getImage();
		Image newImg4 = img4.getScaledInstance(lblCarro4.getWidth(), lblCarro4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image4 = new ImageIcon(newImg4);
		lblCarro4.setIcon(image4);
		
		Thread cruzamentoController = new CruzamentoController(lblCarro1, lblCarro2, lblCarro3, lblCarro4, semaforo);
		cruzamentoController.start();
	}
}
