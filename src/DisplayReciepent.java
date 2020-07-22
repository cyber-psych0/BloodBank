import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class DisplayReciepent extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayReciepent frame = new DisplayReciepent();
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
	public DisplayReciepent() {
		connection = DBConnection.dbConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 732, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JButton btnB = new JButton("Back");
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnB.setIcon(new ImageIcon(img));
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Details ob = new Details();
				ob.setVisible(true);
			}
		});
		btnB.setBounds(25, 40, 114, 25);
		contentPane.add(btnB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 75, 675, 313);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 92, 92), 3, true), "Recipient Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 92, 92)));
		panel.setBounds(12, 12, 708, 394);
		contentPane.add(panel);
		
		showItems();
	}
	
	public void showItems() {
		try {
			String query = "select * from Reciepent";
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
