import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Details extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details frame = new Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(680, 250, 440, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JButton btnHome = new JButton("Home");
		Image img = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob = new Home();
				ob.frame.setVisible(true);
			}
		});
		btnHome.setBounds(22, 22, 114, 25);
		contentPane.add(btnHome);
		
		JButton btnDonorDetails = new JButton("Donor Details");
		btnDonorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DisplayDonorDetails ob = new DisplayDonorDetails();
				ob.setVisible(true);
			}
		});
		btnDonorDetails.setBounds(145, 68, 153, 34);
		contentPane.add(btnDonorDetails);
		
		JButton btnReciepentDetails = new JButton("Recipient Details");
		btnReciepentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DisplayReciepent ob = new DisplayReciepent();
				ob.setVisible(true);
			}
		});
		btnReciepentDetails.setBounds(145, 129, 153, 34);
		contentPane.add(btnReciepentDetails);
		
		JButton btnBloodStock = new JButton("Blood Stock");
		btnBloodStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DisplayStock ob = new DisplayStock();
				ob.setVisible(true);
			}
		});
		btnBloodStock.setBounds(145, 191, 153, 34);
		contentPane.add(btnBloodStock);
		
		JLabel lblNewLabel = new JLabel("");
		Image imges = new ImageIcon(this.getClass().getResource("/pulse.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imges));
		lblNewLabel.setBounds(152, 251, 133, 81);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.desktop, 3, true));
		panel.setBounds(12, 10, 416, 325);
		contentPane.add(panel);
	}

}
