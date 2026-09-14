package Model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseAuthentication{
	public static Boolean saveTheAccount(String username, String password) {
    try (PreparedStatement makeUser=DatabaseConnection.getConnection().prepareStatement("INSERT INTO account(username, password) VALUES (?, ?)");){
        makeUser.setString(1, username);
        makeUser.setString(2, password);
        makeUser.executeUpdate();
        return true;
    }
   catch(Exception e) {
	  return false;
}
}
public static Boolean CheckTheAccount(String username, String password) {
		
		try (PreparedStatement makeUser=DatabaseConnection.getConnection().prepareStatement("SELECT username, password FROM account WHERE username = ? AND password =?");){
	          makeUser.setString(1, username);
	          makeUser.setString(2, password);
	          ResultSet acc=makeUser.executeQuery();
	          if (acc.next()) {
	        	 return true;
	          }
	          else {
	        	  return false;
	          }
		
	}
		catch(Exception e) {
			System.out.println(e);
			return false;
	}

}
}
