package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Cinema;
import Model.Room;
public class cinemaDataBase {
	
	public static Boolean CinemaExists(String name) {
		try(PreparedStatement exist = DatabaseConnection.getConnection().prepareStatement("SELECT (?) FROM cinema WHERE name = (?)")){
			exist.setString(1, name);
			exist.setString(2, name);
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
		String name=cin.getName();
		ArrayList<Room> rooms=cin.getRooms();
		
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, name);
			ResultSet cinemaExist= getID.executeQuery();
			if (cinemaExist.next()) {
			for(int i=0; i<rooms.size(); i++) {
			try(PreparedStatement makeRoom = DatabaseConnection.getConnection().prepareStatement("INSERT INTO room (cinema_id, room_num, capacity) VALUES (?, ?, ?)")){
				makeRoom.setInt(1, cinemaExist.getInt( "cinema_id"));
				makeRoom.setInt(2, rooms.get(i).getRoomNumber() );
				makeRoom.setInt(3,rooms.get(i).getCap());
				makeRoom.executeUpdate();
				
			}
			return true;
			}
			return true;
		}
		else {
			System.out.println("idk for now");
			return false;
		}
			}
		catch(Exception e) {
			return false;
		}
	}
	public static Boolean createMovie(Cinema cin, String name, String genre, String age) {
		String Cname=cin.getName();
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, name);
			ResultSet cinemaExist= getID.executeQuery();
			if (cinemaExist.next()) {
		try(PreparedStatement create = DatabaseConnection.getConnection().prepareStatement("INSERT INTO movie (cinema_id , movie_name, movie_genre, age_rating ) VALUES (?, ? , ? , ?")){
			create.setInt(1, cinemaExist.getInt( "cinema_id"));
			create.setString(2, name);
			create.setString(3, genre);
			create.setString(4, age);
			create.executeUpdate();
			return true;
			
	}}return false;}
		catch(Exception e) {
			return false;
		}

	}
	public static Boolean deleteMovie(String name) {
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT movie_id FROM movie WHERE name= (?)")){
			getID.setString(1, name);
			ResultSet movieID= getID.executeQuery();
		if (movieID.next()) {
			try(PreparedStatement delete = DatabaseConnection.getConnection().prepareStatement("DELETE FROM movie WHERE movie_id =(?)")){
				delete.setInt(1 , movieID.getInt("movie_id ") );
				delete.executeUpdate();
				return true; }}
		else{ return false;
			}
		}
		
		catch(Exception e) {
			return false;
		}
				
} 
	}

