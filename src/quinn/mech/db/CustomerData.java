package quinn.mech.db;

import quinn.mech.db.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

// Class for getting customer data from database
public class CustomerData {
	
	private Connection conn;
	private int ID;
	private String fName;
	private String lName;
	
	private java.sql.Statement statement;
	private ResultSet customers;
	
	// Opens up connection and gets data from customer table
	public CustomerData() {
		
		conn = DBUtil.getConnection();
		
		try {	// creates object with customer info from data form database
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			customers = statement.executeQuery(
					"SELECT customerID, fName, lName FROM customer ");
			customers.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	// loads initial data into instance variables
			ID = customers.getInt(1);
			fName = customers.getString(2);
			lName = customers.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void done() {
		try {
			customers.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// getter methods
	public String getID() {return String.valueOf(ID);}
	public String getfName() {return fName;}	
	public String getlName() {return lName;}
	
	// move to first entry
	public void first() {
		try {
			customers.first();
			ID = customers.getInt(1);
			fName = customers.getString(2);
			lName = customers.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// move to next entry
	public void next() {
		try {
			if (!customers.isLast())
				customers.next();
			ID = customers.getInt(1);
			fName = customers.getString(2);
			lName = customers.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// move to previous
	public void previous() {
		try {
			if (!customers.isFirst())
				customers.previous();
			ID = customers.getInt(1);
			fName = customers.getString(2);
			lName = customers.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// move to last
	public void last() {
		try {
			customers.last();
			ID = customers.getInt(1);
			fName = customers.getString(2);
			lName = customers.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
