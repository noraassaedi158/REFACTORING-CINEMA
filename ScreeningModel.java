package Model;
import Model.database.*;
import java.time.LocalTime;
import java.time.DateTimeException;
import java.time.LocalDate;
public class ScreeningModel {
	private String movieName;
	private int roomNum;
	private static LocalDate date;
	private static LocalTime time;
	private int minNum;
	private int price;
	public static Boolean dateTime(int hrNum, int minNum, int year, int month, int day) {
		 time= LocalTime.of(hrNum, minNum);
		try{
			date = LocalDate.of(year, month, day);
		}
		catch(DateTimeException e){
			return false;
		}
		return true;
	}
	public static boolean screen(String cinemaName, String movieName, int roomNum, int price) {
		if(screeningDatabase.screen (cinemaName, movieName, roomNum,date,time,price)) {
			return true;
		}
		else {
			return false;
		}
	}

}
