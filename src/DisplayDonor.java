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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class DisplayDonor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDonor frame = new DisplayDonor();
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
	private JButton btnHome;
	private JPanel panel;
	public DisplayDonor() {
		connection = DBConnection.dbConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 780, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JComboBox comboBoxSearch = new JComboBox();
		comboBoxSearch.setModel(new DefaultComboBoxModel(new String[] {"FirstName", "LastName", "Age", "BloodGrp"}));
		comboBoxSearch.setBounds(417, 23, 103, 32);
		contentPane.add(comboBoxSearch);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String sel = comboBoxSearch.getSelectedItem().toString();
					String query = "select * from Donor where "+sel+" LIKE ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textField.getText()+"%");
					ResultSet rst = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rst));
					//rst.close();
					pst.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textField.setBounds(561, 24, 157, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 94, 703, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnHome = new JButton("Home");
		Image img = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob = new Home();
				ob.frame.setVisible(true);
			}
		});
		btnHome.setBounds(37, 27, 122, 32);
		contentPane.add(btnHome);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.desktop, 3, true));
		panel.setBounds(12, 12, 756, 379);
		contentPane.add(panel);
	}
}
