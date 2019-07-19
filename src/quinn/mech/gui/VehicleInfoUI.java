package quinn.mech.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import quinn.mech.db.VehicleData;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

// Window created with eclipse window-builder tool
public class VehicleInfoUI {

	private JFrame frmVehicleInformation;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	public void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleInfoUI window = new VehicleInfoUI();
					window.frmVehicleInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VehicleInfoUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmVehicleInformation = new JFrame();
		frmVehicleInformation.setTitle("Vehicle Information");
		frmVehicleInformation.setBounds(100, 100, 450, 300);
		frmVehicleInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVehicleInformation.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 67);
		frmVehicleInformation.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblVehicleIndentificationNumber = new JLabel("Enter Vehicle Identification Number (VIN)");
		lblVehicleIndentificationNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVehicleIndentificationNumber.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblVehicleIndentificationNumber);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(10);
		
		// Search Button
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String VIN = textField.getText();
				VehicleData vehicle = new VehicleData();	//Database handling class
				try {
					vehicle.submit(VIN);
					textField_1.setText(vehicle.getMake());
					textField_2.setText(vehicle.getModel());
					textField_3.setText(vehicle.getYear());
					textField_4.setText(vehicle.getMiles());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmVehicleInformation, "Record not found");
				}
			}
		});
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 96, 128, 80);
		frmVehicleInformation.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblMake = new JLabel("Make");
		lblMake.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblMake);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblModel);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblYear);
		
		JLabel lblMiles = new JLabel("Miles");
		lblMiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblMiles);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(198, 96, 226, 80);
		frmVehicleInformation.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel_2.add(textField_4);
		textField_4.setColumns(10);
	}

}
