package View;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx.collections.*;
public class ManegmentView extends Application {
	@Override
    public void start(Stage manger) {
		
        VBox rootLayout = new VBox(10); 
        Scene page = new Scene(rootLayout, 400, 300);
        primaryStage.setTitle("JavaFX Structure Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
