package Controller;
import View.*;

import java.util.ArrayList;

import Model.*;

public class CinemaController {
	private static Cinema cin = new Cinema();
	private static Movie movie= new Movie();
	private static ageRating age[];
	
public static int getRoomNumber() {
	return cin.getRooms().size();
}
public static ageRating[] getRating() {
	age=ageRating.values();
	return age;
}
public static void CinemaInfo(String name, int num) { 
	cin.name(name, num);
	
}
public static void RoomInfo(int roomNum, int capRoom) {
	cin.setCapcity( roomNum,capRoom);
	
}
public static void MovieInfo( String movieNames, String Genre, ageRating age) {
	String ages= age.name();
	movie.setMovieInfo(cin, movieNames, Genre, ages );
	
}
public static ArrayList movies() {
	
}
public static void DeleteMovie(String name, String cinemaName) {
	movie.delete(name, cinemaName);
	
}
}
