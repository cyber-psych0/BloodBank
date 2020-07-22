import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayDonorDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDonorDetails frame = new DisplayDonorDetails();
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
	Connection connection = null;
	private JPanel panel;
	public DisplayDonorDetails() {
		connection = DBConnection.dbConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 732, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 75, 675, 313);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("Back");
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Details ob = new Details();
				ob.setVisible(true);
			}
		});
		btnHome.setBounds(25, 40, 114, 25);
		contentPane.add(btnHome);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 92, 92), 3, true), "Donor Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 92, 92)));
		panel.setBounds(12, 12, 708, 394);
		contentPane.add(panel);
		
		showItems();
	}
	
	public void showItems() {
		try {
			String query = "select * from Donor";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
			//rst.close();
			pst.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

}
