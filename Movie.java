package Model;
public class Movie {
	private String title;
	private String Genre;
	private ageRating age;
	private int cinemaId;
	private int movieID;
    public Movie(int movieID, int cinemaID, String movieName, String Genre, ageRating age ) {
    	this.cinemaId= cinemaID;
    	this.movieID= movieID;
    	this.title=movieName;
		this.Genre=Genre;
		this.age=age;
    }
	public String getName() {
		return title;
	}
	public String getGenre() {
		return Genre;
	}
	public ageRating getAge() {
		return age;
	}
	public int getMovieID() {
		return movieID;
	}
	public int getCinemaId() {
		return cinemaId;
	}
	
	
}
