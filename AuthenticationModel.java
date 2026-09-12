package Model;
import Model.database.*;
import java.sql.*;
public class Authentication {
	public static void saveTheAccount(String username, String password) {
		Statement state= DatabaseConnection.getConnection().createStatement();
		state.executeUpdate("INSERT INTO account (username) VALUES " + username );
	}
	public static void CheckTheAccount(String username, String password) {
		
	}
	

}
