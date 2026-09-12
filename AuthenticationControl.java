package Controller;
import Model.*;
public class AuthenticationControl {
	public static void accountCheck(String username, String password) {
		Authentication.CheckTheAccount();
	}
	public static void newAccountSave(String username, String password) {
		Authentication.saveTheAccount();
	}

}
