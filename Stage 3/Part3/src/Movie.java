/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
public class Movie {
    private String name;
    private String rating;
    private Showtime showtime;

    public Movie(String name, Showtime showtime, String rating)
    {
        this.name = name; 
        this.rating = rating;
        this.showtime = showtime;

    }

    public String getMovieDetails()
    {
        return "Movie: " + name + 
        ", Showtime: " + showtime.getTime() + 
        ", Rating: " + rating + 
        ", Screen: " + showtime.getScreenNumber() + 
        ", Available Seats: " + showtime.getAvailableSeats();
    }

    public String getName()
    {
        return name;
    }

    public String getRating()
    {
        return rating;
    }

    public Showtime getShowtime()
    {
        return showtime;
    }

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
