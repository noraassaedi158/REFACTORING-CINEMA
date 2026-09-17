package Controller;
import View.*;
import Model.*;

public class CinemaController {
	private static Cinema cin = new Cinema();

public static void CinemaInfo(String name, int num) {
	cin.name(name, num);
	
}
public static void RoomInfo(String name, int roomNum, int capRoom) {
	cin.setCapcity(name, roomNum,capRoom);
	
}
public static void MovieInfo(String movieNames, String Genre, String age) {
	
}
public static void DeleteMovie() {
	
}
public static void ScreenMovie() {
	
