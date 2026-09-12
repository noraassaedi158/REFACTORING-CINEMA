package View;
import Controller.AuthenticationControl;
import Controller.RollConnectionControl;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;

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
		Label noAccount=new Label ("No Account? make one");
		VBox log = new VBox(userBox, passBox, noAccount);
		Scene allLogin= new Scene(log, 300, 300);
		
		Label newUserName=new Label("User: ");
		TextField newUser=new TextField();
		newUser.setPromptText("Username");
		HBox newUserBox=new HBox(newUserName, newUser);
		Label newPassword=new Label("Password: ");
		TextField newPass=new TextField();
		newPass.setPromptText("Password");
		Label askAccount=new Label("Make account: ");
		HBox newPassBox= new HBox( newPassword,newPass);
		VBox newAccBox= new VBox(askAccount,newUserBox, newPassBox);
		Scene makeAccount=new Scene(newAccBox, 300, 300);
		
		noAccount.setOnMouseClicked(click -> {RollConnectionControl.noAccount(login, makeAccount);} );
		user.setOnAction(enter->{pass.requestFocus();});
		pass.setOnAction(enter->{AuthenticationControl.accountCheck(user.getText(), pass.getText());});
		newUser.setOnAction(enter->{newPass.requestFocus();});
		newPass.setOnAction(enter->{AuthenticationControl.newAccountSave(newUser.getText(), newPass.getText());});
		
		
		login.setScene(allLogin);
		login.setTitle("Cinema");
		login.show();
	    
		
		
	}

}
