package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Cinema;
import Model.Movie;
import Model.Room;
public class cinemaDataBase {
	private String  SQL0="SELECT cinema_id FROM cinema JOIN account ON cinema.user_id= account.user_ID WHERE account.username=(?) and cinema.name=(?) ";
	private String  SQL1= "SELECT user_id FROM account WHERE username = (?) ";
	private String  SQL2= "SELECT cinema.cinema_Id, cinema.user_Id, cinema.name FROM cinema JOIN account ON account.user_Id = cinema.user_Id WHERE account.username= (?) ";
	private String  SQL3= "DELETE FROM cinema WHERE cinema_ID= (?)";
	public int getCinemaID(String username, String cinemaName) {
		int cinemaID=0;
		try(PreparedStatement pp1 = DatabaseConnection.getConnection().prepareStatement(SQL0)){
			pp1.setString(1, username);
			pp1.setString(2, cinemaName);
			ResultSet id=pp1.executeQuery();
			if (id.next()) {
			   	cinemaID=id.getInt("cinema_id");
			}
			return cinemaID;
	}
		catch(SQLException e) {
			e.printStackTrace();
			return cinemaID;
		}
		}
	public boolean createCinema(String name,String username) {
		try(PreparedStatement pp2 = DatabaseConnection.getConnection().prepareStatement(SQL1)){
			pp2.setString(1, username);
			ResultSet cin=pp2.executeQuery();
		if (cin.next()) {
		try(PreparedStatement cinMake = DatabaseConnection.getConnection().prepareStatement("INSERT INTO cinema (name,user_id ) VALUES (?, ?)")){
			cinMake.setString(1, name);
			cinMake.setInt(2,cin.getInt("user_id"));
			cinMake.executeUpdate();
			return true;
	}
		}
		return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public ArrayList<Cinema> getCinemaByOwner(String username) {
		  ArrayList<Cinema> cinemas= new ArrayList<>();
		  String userId=null;
		  String cinId=null;
		  String cinName=null;
			try(PreparedStatement pp2 = DatabaseConnection.getConnection().prepareStatement(SQL2)){
				pp2.setString(1,username);
				ResultSet cin=pp2.executeQuery();
				while (cin.next()) {
					 userId=cin.getString("user_Id");
					 cinId= cin.getString("cinema_Id");
					 cinName=cin.getString("name");
					 Cinema cinema=new Cinema(userId, cinId, cinName);
					 cinemas.add(cinema);
				}
					  return cinemas;
				}
			catch(SQLException e) {
				e.printStackTrace();
				return cinemas;
			}
				
	}
			
           public  boolean deleteCinema(int cinemaId) {
        	   try(PreparedStatement pp2 = DatabaseConnection.getConnection().prepareStatement(SQL3)){
   				pp2.setInt(1,cinemaId);
   				int cin=pp2.executeUpdate();
   				if (cin == 1) {
   					return true;
   				}
   				else {
   					return false;
   				}
	             }
        	   catch(SQLException e) {
   				e.printStackTrace();
   				return false;
   			}
        	   
}
}
	
	
	
	
	
	
