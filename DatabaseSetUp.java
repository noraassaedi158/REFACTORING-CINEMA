package Model.database;

import java.sql.Statement;

public class DatabaseSetUp {
	Statement state;
	public DatabaseSetUp() {{
		try {
		    state= DatabaseConnection.getConnection().createStatement();
		   state.executeUpdate("CREATE TABLE IF NOT EXISTS account (user_id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) PRIMARY KEY, password VARCHAR(50) NOT NULL)" );
		   state.executeUpdate("CREATE TABLE IF NOT EXISTS cinema (cinema_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50))");
		   state.executeUpdate("CREATE TABLE IF NOT EXISTS room (room_id INT AUTO_INCREMENT PRIMARY KEY, cinema_id INT, FOREIGN KEY (cinema_id) REFERENCES cinema(cinema_id), room_num INT, capacity INT )");
		   state.executeUpdate("CREATE TABLE IF NOT EXISTS movie (movie_id INT AUTO_INCREMENT PRIMARY KEY, cinema_id INT, FOREIGN KEY (cinema_id) REFERENCES cinema(cinema_id), movie_name VARCHAR(50), movie_genre VARCHAR(50), age_rating ENUM('G', 'PG', 'PG-13', 'R', 'X' ))");
		
	}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
}
