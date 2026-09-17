package View;
import Controller.*;
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
	
    public void start(Stage manger) {
		Label cinemaInfo = new Label("Cinema info");
		Label cinemaName= new Label("Cinema name");
		TextField Cname= new TextField();
		Cname.setPromptText("name");
		HBox name= new HBox(cinemaInfo ,cinemaName,Cname);
		Label RoomNumber =new Label ("Rooms in Cinema");
		Spinner<Integer> num=new Spinner<>(0, 110, 0);
		HBox number=new HBox(RoomNumber, num);
		Button enterCinInfo=new Button("Enter");
		enterCinInfo.setOnAction(x->CinemaController.CinemaInfo(Cname.getText(), num.getValue()));
		VBox cinInf=new VBox(name,number, enterCinInfo);
	    BorderPane cinemaInfoBox = new BorderPane();
	    cinemaInfoBox.setCenter(cinInf);
	    cinemaInfoBox.setTop(cinemaInfo);
	    
	    
	    Label roomNumber= new Label("Select room");
		Spinner<Integer> roomNum= new Spinner<>(0, num.getValue(), 0);
		HBox numberRoom=new HBox(roomNumber, roomNum);
		Label roomCapcity =new Label("room Capcity");
		Spinner<Integer> currentRoomCapcity= new Spinner<>(0, 200, 0);
		HBox capcity=new HBox(roomCapcity, currentRoomCapcity);
		Button enterRoom = new Button("Enter");
		enterRoom.setOnAction(x->CinemaController.RoomInfo(Cname.getText(),roomNum.getValue(), currentRoomCapcity.getValue()));
		VBox roomCap=new VBox(numberRoom,capcity, enterRoom );
		BorderPane roomInfo =new BorderPane();
		roomInfo.setCenter(roomCap);
		
		
	    Label setMovieScreening=new Label("Movie screening");
	    Label movieName = new Label("Movie name");
	    TextField setMovieName= new TextField();
	    setMovieName.setPromptText("Movie name");
	    HBox nameMovie=new HBox(movieName, setMovieName);
	    Label movieGenre = new Label("Movie Genre");
	    TextField setMovieGenre=new TextField();
	    setMovieGenre.setPromptText("Genre");
	    HBox genre=new HBox(movieGenre,setMovieGenre );
	    Label ageRating = new Label("Movie age-rating");
	    Spinner<String> rating= new Spinner<>(0, 0, 0);
	    Button enterMovie=new Button("Add Movie");
	    enterMovie.setOnAction(x->CinemaController.MovieInfo(setMovieName.getText(), setMovieGenre.getText(), rating.getValue().toString()));
	    HBox ratingBox=new HBox(ageRating,rating);
	    Label deleteMovie= new Label("Delete movie");
	    Spinner<String> delete= new Spinner<>(0, 0, 0);
	    Button enterDelete= new Button("Delete Movie");
	    enterDelete.setOnAction(x->CinemaController.DeleteMovie());
	    HBox deleteBox= new HBox(deleteMovie, delete, enterDelete );
	    VBox movieBox= new VBox(setMovieScreening,nameMovie, genre,ratingBox, enterMovie, deleteBox);
	    
	    Label screening = new Label ("Manege screening");
	    Label movie= new Label("Movie");
	    Spinner <String> screenMovie =new Spinner<>(0,0,0);
	    HBox screenBox= new HBox(movie,screenMovie );
	    Label movieRoom = new Label("Room");
	    Spinner<Integer> roomScreen= new Spinner<>(0, num.getValue(), 0);
	    HBox RoomBox= new HBox(movieRoom,roomScreen );
	    Label price = new Label("Price");
	    Spinner<Integer> screenPrice= new Spinner<>(0, 200, 0);
	    HBox priceBox= new HBox(price, screenPrice);
	    Button enterScreen=new Button("Enter");
	    enterScreen.setOnAction(x->CinemaController.ScreenMovie());
	    VBox screenInfo= new VBox(screening, screenBox,RoomBox, priceBox, enterScreen );
	    VBox allManegeInfo =new VBox(cinInf,roomCap, movieBox, screenInfo);
	    allManegeInfo.setAlignment(Pos.CENTER);
        Scene page = new Scene(allManegeInfo, 400, 300);
        
        
        manger.setScene(page);
        manger.setTitle("Cinema");
        manger.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
