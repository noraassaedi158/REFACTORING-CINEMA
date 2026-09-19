package Model;
import Model.database.*;
import java.util.ArrayList;
public class Cinema {
	private static String name;
	private ArrayList<Room> rooms = new ArrayList <>();

public void name(String name, int num) {
	Cinema.name= name;
	if (cinemaDataBase.CinemaExists(name.toLowerCase())) {
		for (int i=1; i<=num; i++) {
			rooms.add(new Room(i));
		}
	}
	else {
		cinemaDataBase.insertCinema(name.toLowerCase());
	}
}
public void setCapcity(int num, int cap) {
	rooms.get(num).setCap(cap);
	
}
public  String getName() {
	return name;
}
public ArrayList<Room> getRooms(){
	return rooms;
}

}
