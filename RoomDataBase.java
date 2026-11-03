package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Room;

public class roomDatabase {
	private String  SQL1= "UPDATE room JOIN cinema  ON room.cinema_id =cinema.cinema_id SET room.capacity=(?) WHERE room.room_num =(?) AND room.cinema_Id =(?) and cinema.user_id =(?) ";
	private String  SQL2= "SELECT room_id, room_num, capacity FROM room JOIN cinema ON room.cinema_id = cinema.cinema_id WHERE room.cinema_id=(?) and cinema.user_id=(?)";
	public  boolean createRoom(int cinemaId, int userId, int roomNumber, int Capacity) {
				try(PreparedStatement pp2 = DatabaseConnection.getConnection().prepareStatement("INSERT INTO room (cinema_id, room_num,capacity) SELECT cinema_id,?, ? FROM cinema WHERE cinema_id = (?) AND user_id = (?)  "))
				{   
					pp2.setInt(1, roomNumber);
					pp2.setInt(2,Capacity);
					pp2.setInt(3,cinemaId);
					pp2.setInt(4, userId);
					int m= pp2.executeUpdate();
					return m == 1 ? true : false;
					
			}
				

				catch(SQLException e) {
					e.printStackTrace();
					return false;
				} }

			
	public boolean updateRoomCapacity(int cinemaId, int userId, int roomNumber, int capacity) {
		try (PreparedStatement pp1 = DatabaseConnection.getConnection().prepareStatement(SQL1)){
			pp1.setInt(1, capacity);
			pp1.setInt(2, roomNumber);
			pp1.setInt(3, cinemaId);
			pp1.setInt(4, userId);
			int updatingRoom= pp1.executeUpdate();
			return updatingRoom == 1 ? true : false;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
			
		
		
	public ArrayList<Room> getRooms(int cinemaId, int userId) {
		ArrayList<Room> rooms= new ArrayList<>();
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement(SQL2)){
			getID.setInt(1, cinemaId);
			getID.setInt(2, userId);
			ResultSet getRooms= getID.executeQuery();
			while (getRooms.next()) {
				 int roomId=getRooms.getInt("room_id");
			     int roomNum= getRooms.getInt("room_num");
	             int cap= getRooms.getInt("capacity");
			     Room room=new Room(roomId,cinemaId, userId,  roomNum,  cap);
			      rooms.add(room);
					}
			}  
		catch(SQLException e) {
			e.printStackTrace();
			return rooms;
		}
		return rooms;
	}
}
