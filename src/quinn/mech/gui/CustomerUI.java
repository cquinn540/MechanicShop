package quinn.mech.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import quinn.mech.db.CustomerData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerUI {

	private JFrame frmCustomers;
	private JTextField txtTest_1;
	private JTextField textField_1;
	private JTextField txtTest;
	
	private final CustomerData customers = new CustomerData();

	/**
	 * Launch the application.
	 */
	public void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerUI window = new CustomerUI();
					window.frmCustomers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomers = new JFrame();
		frmCustomers.setTitle("Customers");
		frmCustomers.setBounds(100, 100, 450, 300);
		frmCustomers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCustomers.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 214, 414, 36);
		frmCustomers.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customers.first();
				txtTest_1.setText(customers.getID());
				textField_1.setText(customers.getfName());
				txtTest.setText(customers.getlName());
			}
		});
		panel.add(btnFirst);
		
		JButton btnNext = new JButton("Previous");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers.previous();
				txtTest_1.setText(customers.getID());
				textField_1.setText(customers.getfName());
				txtTest.setText(customers.getlName());				
			}
		});
		panel.add(btnNext);
		
		JButton btnNext_1 = new JButton("Next");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers.next();
				txtTest_1.setText(customers.getID());
				textField_1.setText(customers.getfName());
				txtTest.setText(customers.getlName());
			}
		});
		panel.add(btnNext_1);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers.last();
				txtTest_1.setText(customers.getID());
				textField_1.setText(customers.getfName());
				txtTest.setText(customers.getlName());
			}
		});
		panel.add(btnLast);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 51, 159, 59);
		frmCustomers.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblCustomerId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblLastName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(216, 51, 208, 59);
		frmCustomers.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		txtTest_1 = new JTextField();
		txtTest_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTest_1.setText(customers.getID());
		panel_2.add(txtTest_1);
		txtTest_1.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(customers.getfName());
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		txtTest = new JTextField();
		txtTest.setText(customers.getlName());
		panel_2.add(txtTest);
		txtTest.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Customer Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(36, 11, 168, 14);
		frmCustomers.getContentPane().add(lblNewLabel);
	}
}
