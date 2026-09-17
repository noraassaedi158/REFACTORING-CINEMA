package Model;
public class Room {
    private int roomNumber;
    private int capacity;
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        
    }
    public void setCap(int capacity) {
        this.capacity = capacity;
    }
   
    public int getRoomNumber() {
        return roomNumber;
    }
}
