package Controller;
import View.*;

import java.util.ArrayList;

import Model.*;

public class CinemaController {
	private  Cinema cin = new Cinema();
	private  Movie movie= new Movie();
    private  ageRating age[];
    private String username;
public void connectCin(String username) {
	this.username=username;
	
}
public String getUser() {
	return username;
}
public  int getRoomNumber() {
	return cin.getRooms().size();
}
public  ageRating[] getRating() {
	age=ageRating.values();
	return age;
}
public  void CinemaInfo(String name, int num) { 
	cin.name(name, num, getUser() );
	
}
public  void RoomInfo(int roomNum, int capRoom) {
	cin.setCapcity( roomNum,capRoom);
	
}
public  void MovieInfo( String movieNames, String Genre, ageRating age) {
	String ages= age.name();
	movie.setMovieInfo(cin, movieNames, Genre, ages );
	
}
public  ArrayList<String> movies() {
	return movie.movies(cin.getName()) ;
}
public  ArrayList<Integer> rooms(){
	return cin.getRooms();
}
public void DeleteMovie(String name, String cinemaName) {
	movie.delete(name, cinemaName);
	
}
}
