package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class driver {
	protected Connection connection;
	public PreparedStatement stmt; 
	
    public driver() {
    	try {
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ConstructionCompanyManagementSystem", "ccms", "ccms@123");
    	} catch (Exception e) {
	         e.printStackTrace();
	         System.err.println("Database connectivity error !");
	         System.exit(0);
	    }
    }
    
    public PreparedStatement Query(String sql)
    {
    	try {
	    	stmt = connection.prepareStatement(sql);
    	} catch (Exception e) {
	         e.printStackTrace();
	         System.err.println("Database connectivity error while preparing statements !");
	         System.exit(0);
	    }
		return stmt;
    }
}