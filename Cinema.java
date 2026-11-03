package Model;
import Model.database.*;
import java.util.ArrayList;
public class Cinema {
	private String cinemaName;
	private int userId;
	private int cinemaId;
	private ArrayList<Room> rooms= new ArrayList<>();
	public Cinema(int userId, int cinemaId, String cinemaName) {
		this.userId=userId;
		this.cinemaId=cinemaId;
		this.cinemaName=cinemaName;
				
	}
	public int getCinId() {
		return cinemaId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public int getUserId(String cinemaName) { 
		return userId;
	}
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	



}
