package Core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.driver;

public class Client extends driver {
	
    String Username;
	String FirstName,LastName,email,City,State;
	int MobileNo,Pincode;	
	
	public Client()
	{
		
	}
	
	public Client (String Username)
	{
		try {
			PreparedStatement stmt = Query("SELECT * FROM Customer WHERE Username = ? ORDER BY Username");
			stmt.setString(1, Username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				this.Username = Username;
				this.FirstName = rs.getString("First_Name");
				this.LastName = rs.getString("Last_Name");
                this.email = rs.getString("Email");
                this.City = rs.getString("City");
                this.State = rs.getString("State");
                this.MobileNo = rs.getInt("Mobile_No");
                this.Pincode = rs.getInt("Pincode");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
}