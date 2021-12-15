package src.sqlUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import src.driver;


public class Auth extends driver {
	
	public boolean isAuthenticated = false;
	public String UserName;
	public String PassWord; 
    public String email;
    public String FirstName;
    public String LastName;
    public int MobileNo;
    public String state;
    public String city;
    public int pincode;
	// public int UserId; 
	
	public Auth(String UserName, String PassWord)
	{
		this.UserName = UserName;
		this.PassWord = PassWord; 
		
	}
	
	public void Authenticate(String UserName, String option)
	{
		try {
			String Query = "SELECT * from " + option + " where Username = ? AND Password = ?";
			PreparedStatement stmt = Query(Query);
			stmt.setString(1, this.UserName);
			stmt.setString(2, this.PassWord);
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next()) 
			{
				this.isAuthenticated = true;
                this.FirstName = rs.getString("First_Name");
                this.LastName = rs.getString("Last_Name");
                this.email = rs.getString("Email");
                this.MobileNo = rs.getInt("Mobile_No");
                this.state = rs.getString("State");
                this.city = rs.getString("City");
                this.pincode = rs.getInt("Pincode");
			}
		} 
	    catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean CreateAccount(String options,String FirstName, String LastName, String Email, int MobileNo,  String City, String State, int Pincode)
	{
		if(options == "Admin" || options == "SiteAdmin" || options == "Supplier" || options == "Customer")
		{
			try 
			{
				String Query = "INSERT INTO " + options + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = Query(Query);
				stmt.setString(1, this.UserName);
				stmt.setString(2, FirstName);
				stmt.setString(3, LastName);
				stmt.setString(4, Email);
				stmt.setString(5, this.PassWord);
				stmt.setInt(6,MobileNo);
				stmt.setString(7, City);
				stmt.setString(8, State);
				stmt.setInt(9, Pincode);
				stmt.execute(); 
				return true;
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return false;
		}
		// else if(options == "SiteAdmin")
		// {
		// 	try 
		// 	{
		// 		String Query = "INSERT INTO SiteAdmin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// 		PreparedStatement stmt = Query(Query);
		// 		stmt.setString(1, this.UserName);
		// 		stmt.setString(2, FirstName);
		// 		stmt.setString(3, LastName);
		// 		stmt.setString(4, Email);
		// 		stmt.setString(5, this.PassWord);
		// 		stmt.setInt(6,MobileNo);
		// 		stmt.setString(7, City);
		// 		stmt.setString(8, State);
		// 		stmt.setInt(9, Pincode);
		// 		stmt.execute(); 
		// 		return true;
		// 	} 
		// 	catch (Exception e)
		// 	{
		// 		e.printStackTrace();
		// 	}
		// 	return false;
		// }
		// else if(options == "Supplier")
		// {
		// 	try 
		// 	{
		// 		String Query = "INSERT INTO Supplier VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// 		PreparedStatement stmt = Query(Query);
		// 		stmt.setString(1, this.UserName);
		// 		stmt.setString(2, FirstName);
		// 		stmt.setString(3, LastName);
		// 		stmt.setString(4, Email);
		// 		stmt.setString(5, this.PassWord);
		// 		stmt.setInt(6,MobileNo);
		// 		stmt.setString(7, City);
		// 		stmt.setString(8, State);
		// 		stmt.setInt(9, Pincode);
		// 		stmt.execute();
		// 		return true;
		// 	} catch (Exception e)
		// 	{
		// 		e.printStackTrace();
		// 	}
		// 	return false;
		// }
		// else if(options == "Customer")
		// {
		// 	try 
		// 	{
		// 		String Query = "INSERT INTO Client VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// 		PreparedStatement stmt = Query(Query);
		// 		stmt.setString(1, this.UserName);
		// 		stmt.setString(2, FirstName);
		// 		stmt.setString(3, LastName);
		// 		stmt.setString(4, Email);
		// 		stmt.setString(5, this.PassWord);
		// 		stmt.setInt(6,MobileNo);
		// 		stmt.setString(7, City);
		// 		stmt.setString(8, State);
		// 		stmt.setInt(9, Pincode);
		// 		stmt.execute();
		// 		return true;
		// 	} catch (Exception e)
		// 	{
		// 		e.printStackTrace();
		// 	}
		// 	return false;
		// }
		else
		{
			return false;
		}
		
	}
	// public boolean CreateAccount(String FirstName, String LastName, String Email, int MobileNo,  String City,String State, int Pincode)
	// {
	// 	try {
	// 		String Query = "INSERT INTO User_auth VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	// 		PreparedStatement stmt = Query(Query);
	// 		stmt.setString(1, this.UserName);
    //         stmt.setString(2, FirstName);
    //         stmt.setString(3, LastName);
    //         stmt.setString(4, Email);
	// 		stmt.setString(5, this.PassWord);
    //         stmt.setInt(6,MobileNo);
	// 		stmt.setString(7, City);
    //         stmt.setString(8, State);
    //         stmt.setInt(9, Pincode);
	// 		stmt.execute(); 
	// 		return true;
	// 	} catch (Exception e)
	// 	{
	// 		e.printStackTrace();
	// 	}
	// 	return false;
	// }

}
