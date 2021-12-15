package Core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import src.driver;
import java.lang.Exception;
import javax.swing.JOptionPane;

public class Update extends driver {
	public String Username,Password;
	public String FirstName,LastName,Email,City,State;;	
	public int Pincode,MobileNo;

	
	public Update()
	{

	}
	
	public Update (String Password, String FirstName,String LastName, String Email, int MobileNo, String City, String State, int Pincode,String Username)
	{
		this.Username=Username;
		this.Password = Password;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
		this.MobileNo = MobileNo;
		this.City = City;
		this.State = State;
		this.Pincode = Pincode;

	}
	
	
	public boolean update(String option)
	{
		try {
			PreparedStatement pst = Query("SELECT * FROM " + option + " where Username = ?");
			pst.setString(1, Username);
			ResultSet rs = pst.executeQuery();
			if (!rs.next()) 
			{
				JOptionPane.showMessageDialog(null, "Add Details first");
			} 
			else 
			{
				PreparedStatement stmt = Query("UPDATE " + option + " SET First_Name = ?, Last_Name = ?, Email = ?, Password = ?, Mobile_No = ?, City = ?, State = ?, Pincode = ? WHERE Username = ?");
				stmt.setString(1, this.FirstName);
				stmt.setString(2, this.LastName);
				stmt.setString(3, this.Email);
				stmt.setString(4, this.Password);
				stmt.setInt(5, this.MobileNo);
				stmt.setString(6, this.City);
				stmt.setString(7, this.State);
				stmt.setInt(8, this.Pincode);
				stmt.setString(9, this.Username);
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, option + " details Updated");
				return true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
}