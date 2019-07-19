package quinn.mech.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

// Created with eclipse window builder tool
public class Menu {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JLabel lblChooseView = new JLabel("Choose Window:");
		lblChooseView.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooseView.setBounds(22, 11, 243, 31);
		frmMenu.getContentPane().add(lblChooseView);

		// select window via buttons
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUI newCus = new CustomerUI();
				newCus.newWindow();
			}
		});
		btnCustomers.setBounds(151, 69, 127, 23);
		frmMenu.getContentPane().add(btnCustomers);
		
		JButton btnNewButton = new JButton("Appointments");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentsUI newAppt = new AppointmentsUI();
				newAppt.newWindow();
			}
		});
		btnNewButton.setBounds(151, 163, 127, 23);
		frmMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vehicle Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleInfoUI newVI = new VehicleInfoUI();
				newVI.newWindow();
			}
		});
		btnNewButton_1.setBounds(151, 114, 127, 23);
		frmMenu.getContentPane().add(btnNewButton_1);
		
		// select window via menu bar
		JMenuBar menuBar = new JMenuBar();
		frmMenu.setJMenuBar(menuBar);
		
		JMenu mnViews = new JMenu("Windows");
		menuBar.add(mnViews);
		
		JMenuItem mntmCustomers = new JMenuItem("Customers");
		mntmCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUI newCus = new CustomerUI();
				newCus.newWindow();
			}
		});
		
		
		mnViews.add(mntmCustomers);
		
		JMenuItem mntmVehicleInfo = new JMenuItem("Vehicle Info");
		mntmVehicleInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleInfoUI newVI = new VehicleInfoUI();
				newVI.newWindow();
			}
		});
		mnViews.add(mntmVehicleInfo);
		
		JMenuItem mntmAppointments = new JMenuItem("Appointments");
		mntmAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentsUI newAppt = new AppointmentsUI();
				newAppt.newWindow();
			}
		});
		mnViews.add(mntmAppointments);
	}
}
