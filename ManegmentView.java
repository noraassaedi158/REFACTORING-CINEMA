package View;
import Controller.*;
import javafx.collections.FXCollections;
import javafx.scene.control.SpinnerValueFactory;
import Model.ageRating;
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
    	ageRating[] ratings = CinemaController.getRating();
		Label cinemaInfo = new Label("Cinema info");
		Label cinemaName= new Label("Cinema name");
		TextField Cname= new TextField();
		Cname.setPromptText("name");
		HBox name= new HBox(cinemaInfo ,cinemaName,Cname);
		name.setSpacing(30);
		Label RoomNumber =new Label ("Rooms in Cinema");
		Spinner<Integer> num=new Spinner<>(0, 110, 0);
		HBox number=new HBox(RoomNumber, num);
		number.setSpacing(30);
		Button enterCinInfo=new Button("Enter");
		enterCinInfo.setOnAction(x->CinemaController.CinemaInfo((String)Cname.getText(), (int)num.getValue()));
		VBox cinInf=new VBox(name,number, enterCinInfo);
		cinInf.setSpacing(10);
	    BorderPane cinemaInfoBox = new BorderPane();
	    cinemaInfoBox.setCenter(cinInf);
	    cinemaInfoBox.setTop(cinemaInfo);
	    
	    
	    Label roomNumber= new Label("Select room");
		Spinner<Integer> roomNum= new Spinner<>(0, CinemaController.getRoomNumber(), 0);
		HBox numberRoom=new HBox(roomNumber, roomNum);
		numberRoom.setSpacing(30);
		Label roomCapcity =new Label("room Capcity");
		Spinner<Integer> currentRoomCapcity= new Spinner<>(0, 200, 0);
		HBox capcity=new HBox(roomCapcity, currentRoomCapcity);
		capcity.setSpacing(30);
		Button enterRoom = new Button("Enter");
		enterRoom.setOnAction(x->CinemaController.RoomInfo((int)roomNum.getValue(), (int)currentRoomCapcity.getValue()));
		VBox roomCap=new VBox(numberRoom,capcity, enterRoom );
		roomCap.setSpacing(10);
		BorderPane roomInfo =new BorderPane();
		roomInfo.setCenter(roomCap);
		
		
	    Label setMovieScreening=new Label("Movie screening");
	    Label movieName = new Label("Movie name");
	    TextField setMovieName= new TextField();
	    setMovieName.setPromptText("Movie name");
	    HBox nameMovie=new HBox(movieName, setMovieName);
	    nameMovie.setSpacing(30);
	    Label movieGenre = new Label("Movie Genre");
	    TextField setMovieGenre=new TextField();
	    setMovieGenre.setPromptText("Genre");
	    HBox genre=new HBox(movieGenre,setMovieGenre );
	    genre.setSpacing(30);
	    Label ageRating = new Label("Movie age-rating");
	    Spinner<ageRating> rating= new Spinner < >( );
	    rating.setValueFactory(
	    	    new SpinnerValueFactory.ListSpinnerValueFactory<>(
	    	        FXCollections.observableArrayList(ratings)
	    	    )
	    	);
	    Button enterMovie=new Button("Add Movie");
	    enterMovie.setOnAction(x->CinemaController.MovieInfo((String) setMovieName.getText(), (String) setMovieGenre.getText(),  rating.getValue()));
	    HBox ratingBox=new HBox(ageRating,rating);
	    ratingBox.setSpacing(30);
	    Label deleteMovie= new Label("Delete movie");
	    Spinner<String> delete= new Spinner<>(0, 0, 0);
	    Button enterDelete= new Button("Delete");
	    enterDelete.setOnAction(x->CinemaController.DeleteMovie((String) delete.getValue(), (String) Cname.getText()));
	    HBox deleteBox= new HBox(deleteMovie, delete, enterDelete );
	    deleteBox.setSpacing(30);
	    VBox movieBox= new VBox(setMovieScreening,nameMovie, genre,ratingBox, enterMovie, deleteBox);
	    movieBox.setSpacing(10);
	    Label screening = new Label ("Manege screening");
	    Label movie= new Label("Movie");
	    Spinner <String> screenMovie =new Spinner<>(0,0,0);
	    HBox screenBox= new HBox(movie,screenMovie );
	    screenBox.setSpacing(30);
	    Label movieRoom = new Label("Room");
	    Spinner<Integer> roomScreen= new Spinner<>(0, num.getValue(), 0);
	    HBox RoomBox= new HBox(movieRoom,roomScreen );
	    RoomBox.setSpacing(30);
	    Label time= new Label("Time");
	    Spinner <Integer> hours= new Spinner<>(0, 12,0);
	    Spinner <Integer> minutes=new Spinner<>(0,60, 0);
	    HBox screenTime= new HBox(time, hours,minutes );
	    screenTime.setSpacing(30);
	    Label date = new Label("Date");
	    Spinner <Integer> year= new Spinner<>(0, 3000, 0);
	    Spinner <Integer> month= new Spinner<>(0, 12, 0);
	    Spinner <Integer> day= new Spinner<>(0, 31, 0);
	    HBox dateScreen= new HBox(date, year, month, day );
	    dateScreen.setSpacing(30);
	    Label price = new Label("Price");
	    Spinner<Integer> screenPrice= new Spinner<>(0, 200, 0);
	    HBox priceBox= new HBox(price, screenPrice);
	    priceBox.setSpacing(30);
	    Button enterScreen=new Button("Enter");
	    enterScreen.setOnAction(x->ScreeningController.ScreenMovie((String)Cname.getText(),(String) screenMovie.getValue(),(int) roomScreen.getValue(), (int) hours.getValue(), (int) minutes.getValue(),(int) year.getValue(), (int) month.getValue(), (int) day.getValue(),   (int) screenPrice.getValue()));
	    VBox screenInfo= new VBox(screening, screenBox,RoomBox,screenTime, dateScreen, priceBox, enterScreen);
	    screenInfo.setSpacing(10);
	    VBox allManegeInfo =new VBox(cinInf,roomCap, movieBox, screenInfo);
	    allManegeInfo.setSpacing(20.0);
	    allManegeInfo.setAlignment(Pos.CENTER);
        Scene page = new Scene(allManegeInfo, 700, 700);
        
        
        manger.setScene(page);
        manger.setTitle("Cinema");
        manger.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
