package Controller;
import Model.*;
import Model.database.DataBaseAuthentication;
import View.*;
import javafx.stage.Stage;
public class AuthenticationControl {
	
	public static void newAccountSave(String username, String password, Stage stage) {
		if(DataBaseAuthentication.saveTheAccount(username, password)) {
			WelcomeControl welcome=new WelcomeControl();
			welcome.login(stage);
		};
		
		
	}

	public static void accountCheck(String username, String password, Stage stage) {
		if (DataBaseAuthentication.CheckTheAccount(username, password)){
			MenuView menu= new MenuView();
			menu.connectTo(username);
			menu.start(stage);
		}
		else {
			//dk yet
		}
		 
		
	}
	
}
