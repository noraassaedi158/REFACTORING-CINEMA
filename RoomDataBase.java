package Model.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Room;

public class roomDatabase {
	private String  SQL1= "SELECT cinema_id FROM cinema WHERE cinema_Id = (?) ";
	private String  SQL2= "UPDATE room SET capacity=(?) WHERE room_num =(?) AND cinema_Id =(?)";
	private String  SQL3= "SELECT room_id FROM room WHERE cinema_id=(?)";
	public  boolean createRoom(int cinemaId, int roomNumber, int Capacity) {
		try(PreparedStatement pp1 = DatabaseConnection.getConnection().prepareStatement(SQL1)){
			pp1.setInt(1, cinemaId);
			ResultSet creatingRoom= pp1.executeQuery();
			if (creatingRoom.next()) {
				try(PreparedStatement pp2 = DatabaseConnection.getConnection().prepareStatement("INSERT INTO room (room_num,capacity, cinema_id ) VALUES (?, ?, ?)")){
					pp2.setInt(1, roomNumber);
					pp2.setInt(2,Capacity);
					pp2.setInt(3,cinemaId);
					pp2.executeUpdate();
					return true;
			}
				}
				return false;
				}
		
				catch(SQLException e) {
					e.printStackTrace();
					return false;
				}

			}
	public boolean updateRoomCapacity(int cinemaId, int roomNumber, int capacity) {
		try (PreparedStatement pp1 = DatabaseConnection.getConnection().prepareStatement(SQL2)){
			pp1.setInt(1, capacity);
			pp1.setInt(2, roomNumber);
			pp1.setInt(3, cinemaId);
			int updatingRoom= pp1.executeUpdate();
			return updatingRoom == 1 ? true : false;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
			
		
		
	public ArrayList<Integer> getRooms(int cinemaId) {
		ArrayList<Integer> rooms= new ArrayList<>();
		try(PreparedStatement getID = DatabaseConnection.getConnection().prepareStatement(SQL3)){
			getID.setInt(1, cinemaId);
			ResultSet getRooms= getID.executeQuery();
			while (getRooms.next()) {
			     int room= getRooms.getInt("room_id");
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
