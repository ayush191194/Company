import java.awt.EventQueue;

import javax.swing.JFrame;

import java.sql.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField usernametextField;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = SqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(394, 94, 78, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(394, 174, 78, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(520, 91, 86, 20);
		frame.getContentPane().add(usernametextField);
		usernametextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon("E:\\eclipsework\\Company\\img\\ok.png"));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM EmployeeInfo WHERE username = ? and password = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernametextField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int cn = 0;
					while (rs.next()) {
						cn++;
					}
					if(cn == 1) {
						JOptionPane.showMessageDialog(null, "Login Credentials Matched...");
						frame.dispose();
						EmployeeInfo emplInfo = new EmployeeInfo();
						emplInfo.setVisible(true);
					}
					else if(cn > 1){
						JOptionPane.showMessageDialog(null, "Duplicate Login Credentials Found...");
					}
					else {
						JOptionPane.showMessageDialog(null, "Login Credentials Failed...");
					}
					rs.close();
					pst.close();
				} catch (Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setBounds(374, 245, 260, 137);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(520, 174, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\eclipsework\\Company\\img\\login.jpg"));
		lblNewLabel_2.setBounds(10, 11, 317, 296);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
