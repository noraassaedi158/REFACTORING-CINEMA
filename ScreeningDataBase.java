package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class screeningDatabase {
	
	public  static 	Boolean screen(String cinemaName, String movieName, int roomNum, LocalDate date, LocalTime time, int price) {
		try(PreparedStatement cinema_id=  DatabaseConnection.getConnection().prepareStatement("SELECT cinema_ID FROM cinema WHERE name = (?)")){
			cinema_id.setString(1, cinemaName);
			ResultSet cinema= cinema_id.executeQuery();
			if (cinema.next()) {
				int cinemaId = cinema.getInt("cinema_id");
				try(PreparedStatement room_id=  DatabaseConnection.getConnection().prepareStatement("SELECT room_id FROM room WHERE room_num = (?) and cinema_ID= (?)")){
					room_id.setInt(1, roomNum);
					room_id.setInt(2, cinemaId);
					ResultSet room= room_id.executeQuery();
					if (room.next()) {
						try(PreparedStatement movie_id=  DatabaseConnection.getConnection().prepareStatement("SELECT movie_id FROM movie WHERE and cinema_ID= (?) and  movie_name = (?)")){
							movie_id.setInt(1, cinemaId);
							movie_id.setString(1, movieName);
							ResultSet movie= movie_id.executeQuery();
							if (movie.next()) {
								try(PreparedStatement ScreenExist=  DatabaseConnection.getConnection().prepareStatement("SELECT screen_ID FROM screening WHERE movie_id= () and cinema_ID =(?) AND movie_id=(?) AND room_ID=(?) AND time =(?) AND date=(?)")){
									ScreenExist.setInt(1, cinemaId);
									ScreenExist.setInt(2, movie.getInt("movie_id"));
									ScreenExist.setInt(3, room.getInt("room_ID"));
									ScreenExist.setObject(4, time);
									ScreenExist.setObject(5, date);
									ResultSet screen= ScreenExist.executeQuery();
									if (screen.next()) {
										return false;
									}
									else {
										try(PreparedStatement screening=  DatabaseConnection.getConnection().prepareStatement("INSERT INTO screening (cinema_ID, movie_id, room_ID, price, time, date) VALUES (?, ?, ?, ?, ?, ?) ")){
											screening.setInt(1, cinema.getInt("cinema_id"));
											screening.setInt(2, movie.getInt("movie_id"));
											screening.setInt(3, room.getInt("room_ID"));
											screening.setInt(4, price);
											screening.setObject(5, time);
											screening.setObject(6, date);
											screening.executeUpdate();
											return true;
									}
							
										
							}
					
					}
					
				}
			}
		}
	
		
	}

		} return false;
			}
		catch(Exception e) {
			return false;
		}
}}
