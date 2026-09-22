package Controller;
import Model.*;
public class ScreeningController {
	public static void ScreenMovie(String cinemaName, String movieName, int roomNum, int hrNum, int minNum, int year, int month, int day, int price) {
		if (ScreeningModel.dateTime( hrNum,  minNum,  year,  month,  day)) {
			ScreeningModel.screen(cinemaName, movieName,  roomNum,  price);
		}
		else {
			//display day doesnt exist
		}
	}

}

