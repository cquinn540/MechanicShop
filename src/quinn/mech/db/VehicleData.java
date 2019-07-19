package quinn.mech.db;

import quinn.mech.db.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// used to get data from Vehicle and Model tables via search
public class VehicleData {
	
	private Connection conn;
	private String make;
	private String model;
	private int year;
	private int miles;
	
	public VehicleData() {
		conn = DBUtil.getConnection();
	}
	
	// getters
	public String getMake() {return make;}
	
	public String getModel() {return model;}
	
	public String getYear() {return String.valueOf(year);}
	
	public String getMiles() {return String.valueOf(miles);}	
	
	//Allows searching by VIN number
	public void submit (String VIN) throws SQLException {
		
		try {	//create prepared statement
			String sql = "SELECT make, model, year, mileage " +
					"FROM vehicle v, model m " +
					"WHERE v.modelNo = m.modelNo AND VIN = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, VIN);
			ResultSet results = ps.executeQuery();	// searches database
			results.first();
			make = results.getString(1);			//loads values into instance variables
			model = results.getString(2);
			year = results.getInt(3);
			miles = results.getInt(4);
		} catch (SQLException e) {
			throw e;
		}
	}
}
