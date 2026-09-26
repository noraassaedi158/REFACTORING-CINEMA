package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Cinema;
import Model.Movie;
import Model.Room;
public class cinemaDataBase {
	
	public static Boolean CinemaExists(String name, String username) {
		try(PreparedStatement Userexist = DatabaseConnection.getConnection().prepareStatement("SELECT user_id FROM account WHERE username = (?) ")){
			Userexist.setString(1, username);
			ResultSet UseExist=Userexist.executeQuery();
			if (UseExist.next()) {
		try(PreparedStatement exist = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name = (?) and user_id =(?)")){
			exist.setString(1, name);
			exist.setInt(2,UseExist.getInt("user_id"));
			ResultSet cinExist=exist.executeQuery();
			if (cinExist.next()) {
				return true;
			}
			else {
				return false;
			}}}
		return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	public static Boolean insertCinema(String name,String username) {
		try(PreparedStatement Userexist = DatabaseConnection.getConnection().prepareStatement("SELECT user_id FROM account WHERE username = (?) ")){
			Userexist.setString(1, username);
			ResultSet UseExist=Userexist.executeQuery();
			if (UseExist.next()) {
		try(PreparedStatement cinMake = DatabaseConnection.getConnection().prepareStatement("INSERT INTO cinema (name,user_id ) VALUES (?, ?)")){
			cinMake.setString(1, name);
			cinMake.setInt(2,UseExist.getInt("user_id"));
			cinMake.executeUpdate();
			return true;
			
	}}
		return false;}
		catch(Exception e) {
			return false;
		}

}
	
	public static Boolean makeRoom(Cinema cin) {
		String name=cin.getName();
		ArrayList<Room> rooms=cin.getRoomsData();
		
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, name);
			ResultSet cinemaExist= getID.executeQuery();
			if (cinemaExist.next()) {
			for(int i=0; i<rooms.size(); i++) {
			try(PreparedStatement makeRoom = DatabaseConnection.getConnection().prepareStatement("INSERT INTO room (cinema_id, room_num) VALUES (?, ?)")){
				makeRoom.setInt(1, cinemaExist.getInt( "cinema_id"));
				makeRoom.setInt(2, rooms.get(i).getRoomNumber() );
				makeRoom.executeUpdate();
				
			}
			
			}
			return true;
		}
		else {
			System.out.println("idk forww now");
			return false;
		}
			}
		catch(Exception e) {
			return false;
		}
	}
	public static Boolean fillRoom(Cinema cin, int num, int cap) {
		String name=cin.getName();
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, name);
			ResultSet cinemaExist= getID.executeQuery();
			if (cinemaExist.next()) {
			try(PreparedStatement makeRoom = DatabaseConnection.getConnection().prepareStatement("UPDATE room SET capacity = (?)  WHERE cinema_id =(?) AND room_num =(?)  ")){
				makeRoom.setInt(1, cap );
				makeRoom.setInt(2, cinemaExist.getInt( "cinema_id"));
				makeRoom.setInt(3, num );
				makeRoom.executeUpdate();
				
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
	
	public static ArrayList<Integer> getRooms(String cin) {
		ArrayList<Integer> rooms= new ArrayList<>();
		
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, cin);
			ResultSet cinemaExist= getID.executeQuery();
			if (cinemaExist.next()) {
				try(PreparedStatement roomsID = DatabaseConnection.getConnection().prepareStatement("SELECT room_ID FROM room WHERE cinema_id= (?)")){
					roomsID.setInt(1, cinemaExist.getInt( "cinema_id"));
					ResultSet allRooms =roomsID.executeQuery();
					while(allRooms.next()) {
						int room= allRooms.getInt("room_ID");
						rooms.add(room);
					}
			} } }
		catch(Exception e) {
			return rooms;
		}
		return rooms;
	}
	public static Boolean createMovie(Cinema cin, String name, String genre, String age) {
		String Cname=cin.getName();
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, Cname);
			ResultSet cinemaExist= getID.executeQuery();
			if (cinemaExist.next()) {
		try(PreparedStatement create = DatabaseConnection.getConnection().prepareStatement("INSERT INTO movie (cinema_id , movie_name, movie_genre, age_rating ) VALUES (?, ? , ? , ?)")){
			create.setInt(1, cinemaExist.getInt("cinema_id"));
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
	public static boolean deleteMovie(String name, String CinemaName) {
		try(PreparedStatement getCinema = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_ID FROM cinema WHERE name= (?)")){
			getCinema.setString(1, CinemaName);
			ResultSet cinID= getCinema.executeQuery();
			if (cinID.next()) {
			try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT movie_id FROM movie WHERE movie_name= (?) AND cinema_ID=(?")){
				getID.setString(1, name);
				getID.setInt(2, cinID.getInt( "cinema_id"));
				ResultSet movieID= getID.executeQuery();
			if (movieID.next()) {
			try(PreparedStatement delete = DatabaseConnection.getConnection().prepareStatement("DELETE FROM movie WHERE movie_id =(?) AND cinema_ID=(?) ")){
				delete.setInt(1 , movieID.getInt("movie_id") );
				delete.setInt(2, cinID.getInt( "cinema_id"));
				delete.executeUpdate();
				return true;
				} 
			}
		else{
			return false;
			}
		
		}
		
} 
}catch(Exception e) {
	return false;
}
		return false;}
	
	
	public static ArrayList<Movie> getMovies(String cin) {
		ArrayList<Movie> movies= new ArrayList<>();
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement("SELECT cinema_id FROM cinema WHERE name= (?)")){
			getID.setString(1, cin);
			ResultSet cinemaExist= getID.executeQuery();
			if (cinemaExist.next()) {
				try(PreparedStatement allmovies = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM movie WHERE cinema_id= (?)")){
					allmovies.setInt(1, cinemaExist.getInt( "cinema_id"));
					ResultSet allMovies =allmovies.executeQuery();
					while(allMovies.next()) {
						String name=allMovies.getString("movie_name");
						String genre= allMovies.getString("movie_genre");
						String age=allMovies.getString("age_rating");
						Movie movie= new Movie(name,genre, age);
						movies.add(movie);
					}
					return movies;
				}
				
			}
		
	}
		catch(Exception e) {
			return movies;
		} return movies;
	}   }

