package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Cinema;
import Model.Movie;
import Model.Room;
public class cinemaDataBase {
	private String  SQL0="SELECT cinema_id FROM cinema  WHERE user_id=(?) and name=(?) ";
	private String  SQL2= "SELECT cinema_Id, user_Id, name FROM cinema WHERE user_id= (?) ";
	private String  SQL3= "DELETE FROM cinema WHERE cinema_ID= (?) and user_ID=(?)";
	public int getCinemaID(int userId, String cinemaName) {
		int cinemaID=0;
		try(PreparedStatement pp1 = DatabaseConnection.getConnection().prepareStatement(SQL0)){
			pp1.setInt(1, userId);
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
	public boolean createCinema(String name, int userId) {
		try(PreparedStatement cinMake = DatabaseConnection.getConnection().prepareStatement("INSERT INTO cinema (name,user_id ) VALUES (?, ?)")){
			cinMake.setString(1, name);
			cinMake.setInt(2,userId);
			cinMake.executeUpdate();
			return true;
	}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}  }

	
	public ArrayList<Cinema> getCinemaByOwner(int userId) {
		  ArrayList<Cinema> cinemas= new ArrayList<>();
		  int cinId=0;
		  String cinName=null;
			try(PreparedStatement pp2 = DatabaseConnection.getConnection().prepareStatement(SQL2)){
				pp2.setInt(1,userId);
				ResultSet cin=pp2.executeQuery();
				while (cin.next()) {
					 cinId= cin.getInt("cinema_Id");
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
	 public  boolean deleteCinema(int cinemaId, int userId) {
  	   try(PreparedStatement pp2 = DatabaseConnection.getConnection().prepareStatement(SQL3)){
				pp2.setInt(1,cinemaId);
				pp2.setInt(2,userId);
				int cin=pp2.executeUpdate();
				return cin==1? true:false;}
  	   catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
  	   
  	   
}
}
	
	
	
	
	
