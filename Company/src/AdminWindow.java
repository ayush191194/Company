

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JTabbedPane;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.Color;

public class AdminWindow {

	private JFrame frmBillingDesk;
	private JTable table_order;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow();
					window.frmBillingDesk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBillingDesk = new JFrame();
		frmBillingDesk.setTitle("Billing Desk");
		frmBillingDesk.setBounds(0, 0, 1366, 728);
		frmBillingDesk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frmBillingDesk.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frmBillingDesk.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel_billing = new JPanel();
		tabbedPane.addTab("Billing", null, panel_billing, null);
		panel_billing.setLayout(null);
		
		JPanel panel_tables = new JPanel();
		panel_tables.setBounds(10, 5, 1325, 94);
		panel_tables.setBorder(new TitledBorder(null, "Tables", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_billing.add(panel_tables);
		
		JButton btn_tabl1 = new JButton("1");
		
		JButton btn_tabl2 = new JButton("2");
		
		JButton btn_tabl3 = new JButton("3");
		
		JButton btn_tabl4 = new JButton("4");
		
		JButton btn_tabl5 = new JButton("5");
		
		JButton btn_tabl6 = new JButton("6");
		
		JButton btn_tabl7 = new JButton("7");
		
		JButton btn_tabl8 = new JButton("8");
		
		JButton btn_tabl9 = new JButton("9");
		
		JButton btn_tabl10 = new JButton("10");
		
		JButton btn_tabl11 = new JButton("11");
		
		JButton btn_tabl12 = new JButton("12");
		
		JButton btn_tabl13 = new JButton("13");
		
		JButton btn_tabl14 = new JButton("14");
		
		JButton btn_tabl15 = new JButton("15");
		
		JButton btn_tabl16 = new JButton("16");
		
		JButton btn_tabl17 = new JButton("17");
		
		JButton btn_tabl18 = new JButton("18");
		
		JButton btn_tabl19 = new JButton("19");
		
		JButton btn_tabl20 = new JButton("20");
		
		JButton btn_tabl21 = new JButton("21");
		
		JButton btn_tabl22 = new JButton("22");
		
		JButton btn_tabl23 = new JButton("23");
		
		JButton btn_tabl24 = new JButton("24");
		
		JButton btn_tabl25 = new JButton("25");
		
		JButton btn_tabl26 = new JButton("26");
		panel_tables.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_tables.add(btn_tabl1);
		panel_tables.add(btn_tabl2);
		panel_tables.add(btn_tabl3);
		panel_tables.add(btn_tabl4);
		panel_tables.add(btn_tabl5);
		panel_tables.add(btn_tabl6);
		panel_tables.add(btn_tabl7);
		panel_tables.add(btn_tabl8);
		panel_tables.add(btn_tabl9);
		panel_tables.add(btn_tabl10);
		panel_tables.add(btn_tabl11);
		panel_tables.add(btn_tabl12);
		panel_tables.add(btn_tabl13);
		panel_tables.add(btn_tabl14);
		panel_tables.add(btn_tabl15);
		panel_tables.add(btn_tabl16);
		panel_tables.add(btn_tabl17);
		panel_tables.add(btn_tabl18);
		panel_tables.add(btn_tabl19);
		panel_tables.add(btn_tabl20);
		panel_tables.add(btn_tabl21);
		panel_tables.add(btn_tabl22);
		panel_tables.add(btn_tabl23);
		panel_tables.add(btn_tabl24);
		panel_tables.add(btn_tabl25);
		panel_tables.add(btn_tabl26);
		
		JPanel panel_order = new JPanel();
		panel_order.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_order.setBounds(10, 113, 638, 538);
		panel_billing.add(panel_order);
		panel_order.setLayout(null);
		
		table_order = new JTable();
		table_order.setBounds(10, 22, 618, 505);
		panel_order.add(table_order);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
	}
}
