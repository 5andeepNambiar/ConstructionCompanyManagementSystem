package Core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import src.driver;

public class Building extends driver 
{
	int BuildingId; 
	String BuildingName, BuildingType, SiteName, SiteLocation, OwnerName, Username;
	int SiteId, ClientId;
	Date ConstructionYear;
	long Cost;
	
	public Building() {} 
	
	public Building(int Bid)
	{
		try {
			
			PreparedStatement stmt = Query("SELECT * FROM Building B JOIN Site S ON S.SiteId = B.SiteId WHERE BuildingId = ? ");
			stmt.setInt(1, Bid); 
			ResultSet rs = stmt.executeQuery(); 
			while(rs.next())
			{
				
				this.BuildingId = rs.getInt("BuildingId");
				this.BuildingName = rs.getString("BuildingName");
				this.BuildingType = rs.getString("Buildingtype");
				this.ConstructionYear = rs.getDate("ConstructionYear");
				this.Username = rs.getString("Username");
				this.Cost =  rs.getLong("Cost");
				this.SiteName = rs.getString("SiteName");
				
				Site s = new Site();
				this.SiteId = s.getSiteId(SiteName);
				
				Client c = new Client(this.Username);
				this.OwnerName = c.FirstName + " " + c.LastName; 
				this.SiteLocation = s.getSiteLocation(this.SiteName);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	
	public Building(int Bid, String Bname, String BType, Date CYear, String SiteName, long Cost , String Username)
	{
		
		this.BuildingId = Bid;
		this.BuildingName = Bname;
		this.BuildingType = BType;
		this.ConstructionYear = CYear;
		this.Username = Username;
		this.Cost = Cost;
		this.SiteName = SiteName;
		
		Site s = new Site();
		this.SiteId = s.getSiteId(SiteName);
		
		Client c = new Client(this.Username);
		this.OwnerName = c.FirstName + " " + c.LastName; 
		
		this.SiteLocation = s.getSiteLocation(this.SiteName);
	}
	

	
	public ArrayList<Building> getBuildings ()
	{
		ArrayList<Building> buildings = new ArrayList<Building>();
		try {
			
			PreparedStatement stmt = Query("SELECT * FROM Building B JOIN Site S ON S.SiteId = B.SiteId");
			ResultSet rs = stmt.executeQuery(); 
			while(rs.next())
			{
				 buildings.add(new Building(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getDate(4),rs.getString("sitename"),rs.getLong("cost"),rs.getString("Username")));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return buildings;
	}
	
	public boolean updateDetails()
	{
		try {
			PreparedStatement stmt = Query("UPDATE Building SET BuildingId = ?, BuildingName = ?, BuildingType = ?, YearOfConstruction = ?, cost = ?,SiteId = ?, Username = ? WHERE BuildingId = ?");
			stmt.setInt(1, this.BuildingId);
			stmt.setString(2, this.BuildingName);
			stmt.setString(3, this.BuildingType);
			stmt.setDate(4, this.ConstructionYear);
			stmt.setLong(5, this.Cost);
			stmt.setInt(6, this.SiteId);
			stmt.setInt(7, this.ClientId);
			stmt.setInt(8, this.BuildingId);
					
			if (stmt.executeUpdate() > 0)
			{
				return true;
			} else {
				return false;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return false;
	}
	
	
	public ArrayList<Building> getBuildingsOwned (String Username){
		ArrayList<Building> buildings = new ArrayList<Building>();
		try {
			PreparedStatement stmt = Query("SELECT * FROM Building B JOIN Site S ON S.SiteId = B.SiteId WHERE B.ClientId = ?");
			stmt.setString(1, Username);
			ResultSet rs = stmt.executeQuery(); 
			while(rs.next())
			{
				 buildings.add(
						 new Building(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4),rs.getString("sitename"),rs.getLong("cost"),rs.getString("UserName")));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return buildings;
	}
	
}