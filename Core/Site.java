package Core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import src.driver;

public class Site extends driver {
	public int SiteId;
	public String SiteName, SiteLocation;
	
	public Site()
	{
		this.SiteId = 1;
	}
	
	public Site(int SiteId)
	{
		try {
			System.out.println(SiteId); 
			PreparedStatement stmt = Query("SELECT * FROM Site WHERE SiteId = ?");
			stmt.setInt(1, SiteId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				this.SiteId = SiteId;
				this.SiteName = rs.getString(2);
				this.SiteLocation = rs.getString(3);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public Site(int SiteId, String SiteName, String SiteLocation)
	{
		this.SiteId = SiteId;
		this.SiteName = SiteName;
		this.SiteLocation = SiteLocation;
	}
	
	
	public boolean newSite()
	{
		try {
			PreparedStatement stmt = Query("INSERT INTO Site (SiteId, SiteName, SiteLocation) VALUES (?, ?, ?)");
			stmt.setInt(1, this.SiteId);
			stmt.setString(2, this.SiteName);
			stmt.setString(3, this.SiteLocation);
			return (stmt.executeUpdate() > 0);  
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean updateSite()
	{
		try {
			PreparedStatement stmt = Query("UPDATE Site SET SiteId = ? , SiteName = ?, SiteLocation = ? WHERE SiteId = ?");
			stmt.setInt(1, this.SiteId);
			stmt.setString(2, this.SiteName);
			stmt.setString(3, this.SiteLocation);
			stmt.setInt(4, this.SiteId);
			return (stmt.executeUpdate() > 0);  
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return false;
	}
	
	public int getSiteId(String SiteName)
	{
		int SiteId = 1; 
		try {
			
			PreparedStatement stmt = Query("SELECT SiteId FROM Site WHERE Sitename = ?");
			stmt.setString(1, SiteName);
			ResultSet rs = stmt.executeQuery(); 
			while(rs.next())
			{

				return rs.getInt(1);  
				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return SiteId; 
	}
	
	public ArrayList<String> getLocations()
	{
		ArrayList<String> location =  new ArrayList<String>();
		try {
			
			ResultSet rs = Query("SELECT Distinct siteLocation from Site;").executeQuery(); 
			while(rs.next())
			{
				location.add(rs.getString(1)); 
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return location;
	}

	public ArrayList<Site> getSiteLocation (String Username){
		ArrayList<Site> location = new ArrayList<Site>();
		try {
			PreparedStatement stmt = Query("SELECT SiteLocation FROM Site S JOIN Building B ON B.SiteId = S.SiteId WHERE B.Username = ?");
			stmt.setString(1, Username);
			ResultSet rs = stmt.executeQuery(); 
			while(rs.next())
			{
				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return location;
	}
}