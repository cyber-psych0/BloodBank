import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 250, 718, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JButton btnRecieveBlood = new JButton("Recieve Blood");
		Image img = new ImageIcon(this.getClass().getResource("/recieve.png")).getImage();
		btnRecieveBlood.setIcon(new ImageIcon(img));
		btnRecieveBlood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ReciepentForm obj = new ReciepentForm();
				obj.setVisible(true);
			}
		});
		btnRecieveBlood.setBounds(514, 135, 170, 36);
		frame.getContentPane().add(btnRecieveBlood);
		
		JButton btnSearchDonor = new JButton("Search Donor");
		Image iMg = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnSearchDonor.setIcon(new ImageIcon(iMg));
		btnSearchDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				DisplayDonor ob = new DisplayDonor();
				ob.setVisible(true);
				
			}
		});
		btnSearchDonor.setBounds(332, 219, 170, 36);
		frame.getContentPane().add(btnSearchDonor);
		
		JButton btnAbc = new JButton("Details");
		Image Img = new ImageIcon(this.getClass().getResource("/details.png")).getImage();
		btnAbc.setIcon(new ImageIcon(Img));
		btnAbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Details obj = new Details();
				obj.setVisible(true);
			}
		});
		btnAbc.setBounds(514, 219, 170, 36);
		frame.getContentPane().add(btnAbc);
		
		JButton btnDonateBlood = new JButton("Donate Blood");
		Image imG = new ImageIcon(this.getClass().getResource("/donate.png")).getImage();
		btnDonateBlood.setIcon(new ImageIcon(imG));
		btnDonateBlood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				DonorForm obj = new DonorForm();
				obj.setVisible(true);
			}
		});
		btnDonateBlood.setBounds(332, 135, 170, 36);     
		frame.getContentPane().add(btnDonateBlood);
		
		JButton btnExit = new JButton("EXIT");
		Image imge = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(imge));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setBounds(447, 293, 137, 36);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		Image imges = new ImageIcon(this.getClass().getResource("/bld.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imges));
		lblNewLabel.setBounds(12, 12, 393, 361);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGiveTheGift = new JLabel("Give the Gift of Life...");
		lblGiveTheGift.setForeground(new Color(204, 0, 0));
		lblGiveTheGift.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 27));
		lblGiveTheGift.setBounds(380, 36, 256, 36);
		frame.getContentPane().add(lblGiveTheGift);
		
		JButton btnAbout = new JButton("About");
		Image imgE = new ImageIcon(this.getClass().getResource("/about.png")).getImage();
		btnAbout.setIcon(new ImageIcon(imgE));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				About ob = new About();
				ob.setVisible(true);
			}
		});
		btnAbout.setBounds(563, 382, 127, 36);
		frame.getContentPane().add(btnAbout);
	}
}
