package Main;
import javafx.application.*;
import View.*;
import Model.database.*;

public class Main  {
	public static void main(String[] args) {
		DatabaseConnection connect= new DatabaseConnection();
		DatabaseSetUp setUp= new DatabaseSetUp();
		Application.launch(WelcomeView.class,args);
        
	}

}
