package View;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import Controller.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
public class WelcomeView extends Application {
	@Override
    public void start(Stage welcome) {
		Label name = new Label ("Cinema app");
        Button start = new Button("Start");
        VBox nameStart=new VBox(name, start);
        Scene welcomePage = new Scene(nameStart, 300, 300);
        Button maneger = new Button("maneger");
        Button Customer = new Button("Customer");
        HBox roles= new HBox(maneger, Customer);
        Label role= new Label("Choose role");
        VBox roleChoosing= new VBox(role, roles);
        Scene rolePage = new Scene(roleChoosing, 300, 400);
        
        
        start.setOnAction(e->WelcomeControl.goRoles(welcome, rolePage));
        maneger.setOnAction(e->RollConnectionControl.chosenManeger(welcome));
        Customer.setOnAction(e->RollConnectionControl.chosenCustomer());
        welcome.setTitle("Cinema");
        welcome.setScene(welcomePage);
        welcome.show();
    }

}
