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
    private String rating;
    private Showtime showtime;

    /**
     * Constructs a Movie
     * @param name
     * @param showtime
     * @param rating 
     */
    public Movie(String name, Showtime showtime, String rating)
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
        ", Showtime: " + showtime.getTime() + 
        ", Rating: " + rating + 
        ", Screen: " + showtime.getScreenNumber() + 
        ", Available Seats: " + showtime.getAvailableSeats();
    }

    // Returns name 
    public String getName()
    {
        return name;
    }

    // Returns rating 
    public String getRating()
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
    
    /**
     * To update movie information
     * @param name
     * @param showtime
     * @param rating
     */
    public void setMovie(String name, Showtime showtime, String rating)
    {
        this.name = name;
        this.showtime = new ArrayList<>();
        this.rating = rating;
    }
    
}
