package Controller;
import View.*;
import Model.*;

public class CinemaController {
	private static Cinema cin = new Cinema();
	private static Movie movie= new Movie();

public static void CinemaInfo(String name, int num) { 
	cin.name(name, num);
	
}
public static void RoomInfo( int roomNum, int capRoom) {
	cin.setCapcity( roomNum,capRoom);
	
}
public static void MovieInfo( String movieNames, String Genre, String age) {
	movie.setMovieInfo(cin, movieNames, Genre, age );
	
}
public static void DeleteMovie() {
	
}
public static void ScreenMovie() {
	
}
}
