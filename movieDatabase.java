package Model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cinema;
import Model.Movie;
import Model.ageRating;
public class movieDatabase {
	private String SQL1="SELECT movie_id FROM movie WHERE movie_name=(?) AND cinema_id= (?)";
	private String SQL2="INSERT INTO movie(cinema_id, movie_name, movie_genre, age_rating) VALUES (?,?,?,?)";
	private String SQL3="DELETE FROM movie WHERE cinema_id=(?) AND movie_id=(?)";
	private String SQL4="SELECT cinema_id, movie_id, movie_name, movie_genre, age_rating FROM movie WHERE cinema_id=(?)";
	
	public int getMovieID(int cinema_id, String movieName) {
		int movieId=0;
		try(PreparedStatement pp1=DatabaseConnection.getConnection().prepareStatement(SQL1)){
     		pp1.setString(1, movieName);
     		pp1.setInt(2, cinema_id);
     		ResultSet id=pp1.executeQuery();
     		if(id.next()) {
     			movieId=id.getInt("movie_Id");
     		}
     		return movieId;
     	}
     	catch(SQLException e) {
			e.printStackTrace();
			return movieId;
		}
	}
	
	public boolean createMovies(int cinemaId, Movie movie) {
	     	try(PreparedStatement pp1=DatabaseConnection.getConnection().prepareStatement(SQL2)){
	     		pp1.setInt(1, cinemaId);
	     		pp1.setString(2, movie.getName());
				pp1.setString(3, movie.getGenre());
				pp1.setString(4, movie.getAge().name());
	     		int created=pp1.executeUpdate();
	     		return created==1? true:false; 
	     	}
	     	catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	public boolean deleteMovie(int cinemaId, int movieID) {
		try(PreparedStatement pp1=DatabaseConnection.getConnection().prepareStatement(SQL3)){
     		pp1.setInt(1, cinemaId);
     		pp1.setInt(2, movieID);
     		int deleted=pp1.executeUpdate();
     		return deleted==1? true:false; 
     	}
     	catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
}
	public ArrayList<Movie> getMovies(int cinemaId){
		ArrayList<Movie> Movie=new ArrayList<>();
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement(SQL4)){
			getID.setInt(1, cinemaId);
			ResultSet getMovie= getID.executeQuery();
			while (getMovie.next()) {
			     String name= getMovie.getString("movie_name");
			     String genre= getMovie.getString("movie_genre");
			     String age=  getMovie.getString("age_rating");
			     ageRating ageRatingEnum = ageRating.valueOf(age); 
			     int movieId=getMovie.getInt("movie_id");
			     Movie movie= new Movie(movieId, cinemaId, name, genre, ageRatingEnum);
			     Movie.add(movie);
					}
			}  
		catch(SQLException e) {
			e.printStackTrace();
			return Movie;
		}
		return Movie;
	}
}
