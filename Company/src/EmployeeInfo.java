import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JLabel lblEid;
	private JTextField EIDtextField;
	private JLabel lblName;
	private JTextField NametextField;
	private JLabel lblSurname;
	private JTextField SurnametextField;
	private JLabel lblAge;
	private JTextField AgetextField;
	private JButton btnSave;
	/**
	 * Create the frame.
	 */
	public EmployeeInfo() {
		connection = SqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadEmployeeData = new JButton("Load Employee Data");
		btnLoadEmployeeData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT EID, Name, Surname, Age FROM EmployeeInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadEmployeeData.setBounds(489, 29, 131, 23);
		contentPane.add(btnLoadEmployeeData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 76, 457, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = table.getSelectedRow(); 
					String EID = (table.getModel().getValueAt(row, 0)).toString();
					String query = "SELECT EID, Name, Surname, Age FROM EmployeeInfo WHERE EID = ?";
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.setString(1, EID);
					ResultSet rs = pst1.executeQuery();
					while(rs.next()) {
						EIDtextField.setText(rs.getString("EID"));
						NametextField.setText(rs.getString("Name"));
						SurnametextField.setText(rs.getString("Surname"));
						AgetextField.setText(rs.getString("Age"));
					}
					pst1.close();
					rs.close();
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		scrollPane.setViewportView(table);
		
		lblEid = new JLabel("EID");
		lblEid.setBounds(10, 91, 46, 14);
		contentPane.add(lblEid);
		
		EIDtextField = new JTextField();
		EIDtextField.setBounds(84, 87, 198, 23);
		contentPane.add(EIDtextField);
		EIDtextField.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 125, 46, 14);
		contentPane.add(lblName);
		
		NametextField = new JTextField();
		NametextField.setBounds(84, 121, 198, 23);
		contentPane.add(NametextField);
		NametextField.setColumns(10);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 159, 64, 14);
		contentPane.add(lblSurname);
		
		SurnametextField = new JTextField();
		SurnametextField.setBounds(84, 155, 198, 23);
		contentPane.add(SurnametextField);
		SurnametextField.setColumns(10);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(10, 193, 46, 14);
		contentPane.add(lblAge);
		
		AgetextField = new JTextField();
		AgetextField.setBounds(84, 189, 198, 23);
		contentPane.add(AgetextField);
		AgetextField.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "INSERT INTO EmployeeInfo(EID, Name, Surname, Age) values(?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, EIDtextField.getText());
					pst.setString(2, NametextField.getText());
					pst.setString(3, SurnametextField.getText());
					pst.setString(4, AgetextField.getText());
					pst.execute();
					pst.close();
					query = "SELECT EID, Name, Surname, Age FROM EmployeeInfo";
					PreparedStatement pst1 = connection.prepareStatement(query);
					ResultSet rs = pst1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst1.close();
					rs.close();
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSave.setBounds(74, 246, 89, 23);
		contentPane.add(btnSave);
	}
}
