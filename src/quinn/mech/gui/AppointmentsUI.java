package quinn.mech.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import quinn.mech.db.AppointmentData;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// created with eclipse window builder tool
public class AppointmentsUI {

	private JFrame frmAppointments;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentsUI window = new AppointmentsUI();
					window.frmAppointments.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppointmentsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppointments = new JFrame();
		frmAppointments.setTitle("Appointments");
		frmAppointments.setBounds(100, 100, 450, 300);
		frmAppointments.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAppointments.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 26);
		frmAppointments.getContentPane().add(panel);
		
		JLabel lblEnterAppointmentNumber = new JLabel("Enter Appointment Number");
		lblEnterAppointmentNumber.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblEnterAppointmentNumber);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int apptNo = Integer.parseInt(textField.getText());
				AppointmentData appts = new AppointmentData();
				try {
					appts.submit(apptNo);
					textField_1.setText(appts.getDate());
					textField_2.setText(appts.getTime());
					textField_3.setText(appts.getCusID());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmAppointments, "Record not found");
				}
			}
		});
		btnNewButton.setBounds(165, 85, 89, 23);
		frmAppointments.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 147, 86, 20);
		frmAppointments.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(72, 147, 86, 20);
		frmAppointments.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(264, 147, 86, 20);
		frmAppointments.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(72, 122, 46, 14);
		frmAppointments.getContentPane().add(lblTime);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(165, 122, 46, 14);
		frmAppointments.getContentPane().add(lblDate);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(264, 122, 86, 14);
		frmAppointments.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(168, 54, 86, 20);
		frmAppointments.getContentPane().add(textField);
		textField.setColumns(10);
	}

}
