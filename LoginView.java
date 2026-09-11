package View;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LoginView extends Application{
	public void start(Stage login) {
		Label userName=new Label("User: ");
		TextField user=new TextField();
		user.setPromptText("Username");
		HBox userBox=new HBox(userName, user);
		Label password=new Label("Password: ");
		TextField pass=new TextField();
		pass.setPromptText("Password");
		HBox passBox= new HBox(password,pass);
		VBox log = new VBox(userBox, passBox);
		Scene allLogin= new Scene(log, 300, 300);
		login.setScene(allLogin);
		login.setTitle("Cinema");
		login.show();
	    
		
		
	}

}
