package Model;
import Model.database.*;
public class Authentication {
	public static boolean saveAccount(String username, String password) {
		if(DataBaseAuthentication.saveTheAccount( username, password)) {
			return true;
		}
		else{
			return false;
		}
		
	}

	public static boolean CheckAccount(String username, String password) {
		
		if (DataBaseAuthentication.CheckTheAccount(username, password)) {
			return true;
		}
		else {
			return false;
		}
		}}
