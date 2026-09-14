package Controller;
import Model.*;
import View.*;
import javafx.stage.Stage;
public class AuthenticationControl {
	
	public static void newAccountSave(String username, String password, Stage stage) {
		if(Authentication.saveAccount(username, password)) {
			LoginView login=new LoginView();
			login.start(stage);
		};
		
	}

	public static void accountCheck(String username, String password, Stage stage) {
		if (Authentication.CheckAccount(username, password)){
			ManegmentView manege = new ManegmentView();
			manege.start(stage);
		}
		else {
			WelcomeView notLegit = new WelcomeView();
			notLegit.start(stage);
		}
		 
		
	}
	
}
