package Model;
import Model.database.*;
import java.util.ArrayList;
public class Cinema {
	private String name;
	private ArrayList<Room> rooms = new ArrayList <>();

public void name(String name, int num, String username) {
	this.name= name;
	if (cinemaDataBase.CinemaExists(name.toLowerCase(), username)) {
		for (int i=1; i<=num; i++) {
			rooms.add(new Room(i));
			
		}
		cinemaDataBase.makeRoom(this);
	}
	else {
		
		cinemaDataBase.insertCinema(name.toLowerCase(), username);
		for (int i=1; i<=num; i++) {
			rooms.add(new Room(i));
		}
		cinemaDataBase.makeRoom(this);
	}
}
public void setCapcity(int num, int cap) {
	rooms.get(num-1).setCap(cap);
	cinemaDataBase.fillRoom(this, num, cap);
}
public  String getName() {
	return name;
}
public ArrayList<Integer> getRooms(){
	return cinemaDataBase.getRooms(this.getName());
}

public ArrayList<Room> getRoomsData(){
	return rooms;
}

}
