import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 730, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblVersion = new JLabel("Version: 1.0");
		lblVersion.setForeground(SystemColor.activeCaption);
		lblVersion.setFont(new Font("Dialog", Font.BOLD, 18));
		lblVersion.setBounds(572, 27, 128, 36);
		contentPane.add(lblVersion);
		
		JButton btnBack = new JButton("Back");
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob = new Home();
				ob.frame.setVisible(true);
			}
		});
		btnBack.setBounds(27, 32, 114, 28);
		contentPane.add(btnBack);
		
		JLabel lblDevelopedBy = new JLabel("Developed By:");
		lblDevelopedBy.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDevelopedBy.setBounds(302, 68, 162, 36);
		contentPane.add(lblDevelopedBy);
		
		JLabel lblShubham = new JLabel("");
		Image imges = new ImageIcon(this.getClass().getResource("/shubham.png")).getImage();
		lblShubham.setIcon(new ImageIcon(imges));
		lblShubham.setBounds(27, 128, 152, 160);
		contentPane.add(lblShubham);
		
		JLabel labelAyush = new JLabel("");
		Image imges2 = new ImageIcon(this.getClass().getResource("/ayushman.png")).getImage();
		labelAyush.setIcon(new ImageIcon(imges2));
		labelAyush.setBounds(200, 128, 152, 160);
		contentPane.add(labelAyush);
		
		JLabel labelKunal = new JLabel("");
		Image imges3 = new ImageIcon(this.getClass().getResource("/kunal.png")).getImage();
		labelKunal.setIcon(new ImageIcon(imges3));
		labelKunal.setBounds(376, 128, 152, 160);
		contentPane.add(labelKunal);
		
		JLabel labelNaimish = new JLabel("");
		Image imges4 = new ImageIcon(this.getClass().getResource("/naimish.png")).getImage();
		labelNaimish.setIcon(new ImageIcon(imges4));
		labelNaimish.setBounds(554, 128, 152, 160);
		contentPane.add(labelNaimish);
		
		JLabel lblShubhamKumar = new JLabel("Shubham Kumar");
		lblShubhamKumar.setBounds(27, 299, 152, 28);
		contentPane.add(lblShubhamKumar);
		
		JLabel lblLit = new JLabel("LIT2018015");
		lblLit.setBounds(27, 324, 152, 28);
		contentPane.add(lblLit);
		
		JLabel lblAyushmanVerma = new JLabel("Ayushman Verma");
		lblAyushmanVerma.setBounds(200, 300, 152, 28);
		contentPane.add(lblAyushmanVerma);
		
		JLabel lblLit_1 = new JLabel("LIT2018011");
		lblLit_1.setBounds(200, 324, 152, 28);
		contentPane.add(lblLit_1);
		
		JLabel lblKunalKumar = new JLabel("Kunal Kumar");
		lblKunalKumar.setBounds(376, 300, 152, 28);
		contentPane.add(lblKunalKumar);
		
		JLabel lblLit_2 = new JLabel("LIT2018046");
		lblLit_2.setBounds(376, 324, 152, 28);
		contentPane.add(lblLit_2);
		
		JLabel lblNaimishRastogi = new JLabel("Naimish Rastogi");
		lblNaimishRastogi.setBounds(554, 300, 152, 28);
		contentPane.add(lblNaimishRastogi);
		
		JLabel lblLit_3 = new JLabel("LIT2018009");
		lblLit_3.setBounds(554, 324, 152, 28);
		contentPane.add(lblLit_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 92, 92), 3, true), "About", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel.setBounds(12, 12, 708, 361);
		contentPane.add(panel);
	}
}
