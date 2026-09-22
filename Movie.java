package Model;

import java.util.ArrayList;

import Model.database.cinemaDataBase;

public class Movie {
	private String title;
	private Room room;
	private String Genre;
	private String age;
	private double price;
	private String cinemaName;
    public Movie(String cinemaName,String movieNames, String Genre, String age ) {
    	title=movieNames;
		this.Genre=Genre;
		this.age=age;
    }
	
	public Movie() {
		title=null;
		room=null;
	}
	public void setMovieInfo(Cinema cin, String movieNames, String Genre, String age) {
		cinemaDataBase.createMovie( cin, movieNames, Genre, age);
		title=movieNames;
		this.Genre=Genre;
		this.age=age;
	}
	public void delete(String name, String cinemaMovie) {
		cinemaDataBase.deleteMovie(name, cinemaMovie);
	}
	public ArrayList movies(Cinema cin) {
		
	}

}
