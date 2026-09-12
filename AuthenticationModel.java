package Model;
import Model.database.*;
import java.sql.*;
public class Authentication {
	static Statement state;
	public static void saveTheAccount(String username, String password) {
		try {
		      state= DatabaseConnection.getConnection().createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
			return;
		}
		state.excuteUpdate("INSERT INTO account(username, password) VALUES " + username + " " + password );
		
	}
	public static void CheckTheAccount(String username, String password) {
		
	}
	

}
