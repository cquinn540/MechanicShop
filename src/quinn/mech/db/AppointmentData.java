package quinn.mech.db;

import java.sql.Connection;
import quinn.mech.db.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// Class for getting appointment data from database with search
public class AppointmentData {
	
	private Connection conn;
	private java.sql.Time apptTime;
	private java.sql.Date apptDate;
	private int customerID;

	public AppointmentData() {
		conn = DBUtil.getConnection();
	}
	
	//getters
	public String getTime() {return apptTime.toString();}
	
	public String getDate() {return apptDate.toString();}
	
	public String getCusID() {return String.valueOf(customerID);}
	
	
	//Allows searching by appointment number
	public void submit (int apptNo) throws SQLException {
		
		try {	//create prepared statement
			String sql = "SELECT time, date, customerID " +
					"FROM appointment WHERE apptNo = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, apptNo);
			ResultSet apptInfo = ps.executeQuery();	//searches database
			apptInfo.first();
			apptTime = apptInfo.getTime(1);			//load values into instance variables
			apptDate = apptInfo.getDate(2);
			customerID = apptInfo.getInt(3);	
		} catch (SQLException e) {
			throw e;
		}
	}
}
