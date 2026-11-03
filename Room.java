package Model;
public class Room {
    private int roomNumber;
    private int roomId;
    private int cinemaId;
    private int Capacity;
    private int userID;
    public Room(int roomId, int cinemaId,int userID, int roomNumber, int Capacity) {
    	this.roomId=roomId;
        this.roomNumber = roomNumber;
        this.userID= userID;
        this.cinemaId=cinemaId;
        this.Capacity=Capacity;
        
    }
    public void setCap(int capacity) {
        this.Capacity = capacity;
    }
   
    public int getRoomNumber() {
        return roomNumber;
    }
    public int getCap() {
        return Capacity;
    }
    public int getUserID() {
    	return userID;

    }
    public int getCinemaId() {
    	return cinemaId;
    }
    public int getRoomId() {
    	return roomId;
    }
}
