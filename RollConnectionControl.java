package Controller;
import View.*;
import Model.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.stage.*;
public class RollConnectionControl {
 public static void chosenManeger(Stage s) {
	LoginView log=new LoginView();
	log.start(s);
 }
 public static void chosenCustomer() {
	 
 }
 public static void noAccount(Stage stage , Scene scene) {
	 stage.setScene(scene);
	 
 }
}
