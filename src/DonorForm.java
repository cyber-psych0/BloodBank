import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class DonorForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFname;
	private JTextField textFieldLname;
	private JTextField textFieldNum;
	private JTextField textFieldAge;
	private JTextField textFieldCity;
	private JTextField textFieldUnits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorForm frame = new DonorForm();
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
	public DonorForm() {
		connection = DBConnection.dbConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 595, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(49, 48, 79, 15);
		contentPane.add(lblFirstName);
		
		textFieldFname = new JTextField();
		textFieldFname.setBounds(136, 46, 150, 25);
		contentPane.add(textFieldFname);
		textFieldFname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(304, 48, 79, 15);
		contentPane.add(lblLastName);
		
		textFieldLname = new JTextField();
		textFieldLname.setColumns(10);
		textFieldLname.setBounds(392, 46, 150, 25);
		contentPane.add(textFieldLname);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(49, 104, 84, 15);
		contentPane.add(lblContactNo);
		
		textFieldNum = new JTextField();
		textFieldNum.setColumns(10);
		textFieldNum.setBounds(136, 99, 150, 25);
		contentPane.add(textFieldNum);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(344, 104, 45, 15);
		contentPane.add(lblSex);
		
		JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		comboBoxSex.setBounds(393, 99, 79, 24);
		contentPane.add(comboBoxSex);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(83, 160, 45, 15);
		contentPane.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(136, 155, 53, 25);
		contentPane.add(textFieldAge);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(349, 160, 45, 15);
		contentPane.add(lblCity);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(392, 155, 111, 25);
		contentPane.add(textFieldCity);
		
		JLabel lblBloodGrp = new JLabel("Blood Grp.:");
		lblBloodGrp.setBounds(39, 217, 84, 15);
		contentPane.add(lblBloodGrp);
		
		JComboBox comboBoxBgrp = new JComboBox();
		comboBoxBgrp.setMaximumRowCount(3);
		comboBoxBgrp.setModel(new DefaultComboBoxModel(new String[] {"A+", "B+", "AB+", "O+","A-","B-","AB-","O-"}));
		comboBoxBgrp.setBounds(136, 212, 53, 24);
		contentPane.add(comboBoxBgrp);
		
		JButton btnCancel = new JButton("Cancel");
		Image img = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		btnCancel.setIcon(new ImageIcon(img));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home obj = new Home();
				obj.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(99, 291, 114, 25);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		Image imge = new ImageIcon(this.getClass().getResource("/tick.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(imge));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname = textFieldFname.getText();
				String lname = textFieldLname.getText();
				String num = textFieldNum.getText();
				String city = textFieldCity.getText();
				String age = textFieldAge.getText();
				String unit = textFieldUnits.getText();
				if(fname.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "First Name is required!");
				}
				
				else if(lname.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Last Name is required!");
				}
				
				else if(num.contentEquals("") || num.length() != 10) {
					JOptionPane.showMessageDialog(null, "Contact Number invalid!");
				}
				
				else if(city.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "City Name is required!");
				}
				
				else if(age.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Age is required!");
				}
//				else if(age.length() <= 1) {
//					int x = Integer.parseInt(age);
//					if(x < 18) {
//						JOptionPane.showMessageDialog(null, "Age must be greater than 18!");
//					}
//				}
				else if(unit.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Blood Unit is required!");
				}
				else {
					int ag=18,unt=0;
					long cnum = 0;
					try {
						try {
							ag = Integer.parseInt(age);
							unt = Integer.parseInt(unit);
							cnum = Long.parseLong(num);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Invalid Inputs for Age or Blood Units or Contact number");
							return;
						}
						
						if(ag < 18) {
							JOptionPane.showMessageDialog(null, "Age must be greater than 18!");
						}
						else if(unt<0) {
							JOptionPane.showMessageDialog(null,"Blood Units must be greater than zero");
						}
						else {
							String query = "insert into Donor (FirstName,Lastname,ContactNo,Sex,Age,City,BloodGrp,BloodUnit) values (?,?,?,?,?,?,?,?)";
							String sex = comboBoxSex.getSelectedItem().toString();
							String brp = comboBoxBgrp.getSelectedItem().toString();
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1,fname);
							pst.setString(2,lname);
							pst.setString(3,num);
							pst.setString(4,sex);
							pst.setString(5,age);
							pst.setString(6,city);
							pst.setString(7,brp);
							pst.setInt(8,unt);
							
							pst.execute();
							String query2 = "select Quantity from Stock where BloodGrp=?";
							PreparedStatement pst2 = connection.prepareStatement(query2);
							pst2.setString(1,brp);
							ResultSet rst = pst2.executeQuery();
							
							int curr_st = rst.getInt("Quantity");
							curr_st+=unt;
							
							String query3 = "update Stock set Quantity = ? where BloodGrp=?";
							PreparedStatement pst3 = connection.prepareStatement(query3);
							pst3.setInt(1, curr_st);
							pst3.setString(2, brp);
							pst3.execute();
							
							JOptionPane.showMessageDialog(null, "Donated Successfully!");
							pst.close();
							pst2.close();
							pst3.close();
							
							setVisible(false);
							Home obj = new Home();
							obj.frame.setVisible(true);
						}
						
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnSubmit.setBounds(392, 291, 114, 25);
		
		contentPane.add(btnSubmit);
		
		JLabel lblBloodUnits = new JLabel("Blood Units:");
		lblBloodUnits.setBounds(293, 217, 84, 15);
		contentPane.add(lblBloodUnits);
		
		textFieldUnits = new JTextField();
		textFieldUnits.setColumns(10);
		textFieldUnits.setBounds(392, 212, 53, 25);
		contentPane.add(textFieldUnits);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 92, 92), 3, true), "Donor Form", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel.setBounds(12, 12, 568, 342);
		contentPane.add(panel);
	}
}
