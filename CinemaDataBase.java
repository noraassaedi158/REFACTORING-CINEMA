package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Cinema;
public class cinemaDataBase {
	public static Boolean CinemaExists(String name) {
		try(PreparedStatement exist = DatabaseConnection.getConnection().prepareStatement("SELECT (?) FROM cinema WHERE (?) = (?)")){
			exist.setString(1, name);
			exist.setString(2, name);
			exist.setString(3, name);
			ResultSet cinExist=exist.executeQuery();
			if (cinExist.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	public static Boolean insertCinema(String name) {
		try(PreparedStatement cinMake = DatabaseConnection.getConnection().prepareStatement("INSERT INTO cinema (name) VALUES (?)")){
			cinMake.setString(1, name);
			cinMake.executeUpdate();
			return true;
			
	}
		catch(Exception e) {
			return false;
		}

}
	public static Boolean makeRoom(Cinema cin) {
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, null);
			try(PreparedStatement makeRoom = DatabaseConnection.getConnection().prepareStatement("INSERT INTO room( FROM cinema))
		}
		catch(Exception e) {
			return false;
		}
	}
}
