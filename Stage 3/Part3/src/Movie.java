/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Movie class 
 * @author paolapereda
 */
public class Movie {
    private String name;
    private Showtime rating;
    private Showtime showtime;
    private Seat seatID;

    /**
     * Constructs a Movie
     * @param name
     * @param showtime
     * @param rating 
     */
    public Movie(String name, Showtime showtime, Showtime rating)
    {
        this.name = name; 
        this.rating = rating;
        this.showtime = showtime;

    }

    /**
     * Returns the movie details 
     * @return 
     */
    public String getMovieDetails()
    {
        return "Movie: " + name + 
        ", Showtime: " + showtime.getAvailableTimes() + 
        ", Rating: " + rating.getRating() + 
        ", Screen: " + seatID.getScreenID() + 
        ", Available Seats: " + seatID.isAvailable();
    }

    // Returns name 
    public String getName()
    {
        return name;
    }

    // Returns rating 
    public Showtime getRating()
    {
        return rating;
    }

    // returns showtime
    public Showtime getShowtime()
    {
        return showtime;
    }

    //Returns a movie list 
    public static String[] getMovieList()
    {
        String[] movies = {"Clueless", "Insidious", "Divergent", "High School Musical", "Big Hero Six"};
        return movies;
    }
}
