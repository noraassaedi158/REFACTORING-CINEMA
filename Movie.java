package Model;

import Model.database.cinemaDataBase;

public class Movie {
	
	private String title;
	Room room;
	double price;
	
	public Movie() {
		title=null;
		room=null;
	}
	public void setMovieInfo(Cinema cin, String movieNames, String Genre, String age) {
		cinemaDataBase.createMovie( cin, movieNames, Genre, age);
	}

}
