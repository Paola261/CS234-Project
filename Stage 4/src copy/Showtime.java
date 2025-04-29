import java.util.List;
import java.util.ArrayList;

/**
 * The class represents the details of a movie showtime, 
 * including the movie title, available times, movie date, rating, runtime, 
 * and the list of available seats.
 * @author Melissa Flores
 */

public class Showtime {
    private String movieTitle;
    private String availableTimes;
    private String movieDate;
    private String rating;
    private String runTime;
    private List<Seat> seats;
    private int sID;

    /**
     * Constructor method
     *
     * @param movieTitle The title of the movie.
     * @param availableTimes The available show times.
     * @param movieDate The date of the movie showing.
     * @param rating The movie rating.
     * @param runTime The runtime of the movie.
     * @param sID The showtime ID.
     */
    public Showtime(String movieTitle, String availableTimes, String movieDate, String rating, String runTime, int sID) {
        this.movieTitle = movieTitle;
        this.availableTimes = availableTimes;
        this.movieDate = movieDate;
        this.rating = rating;
        this.runTime = runTime;
        this.sID = sID;
        this.seats = new ArrayList<>();
    }

    /**
     * @return The movie title
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * @param movieTitle The movie title to set
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * @return The available show times
     */
    public String getAvailableTimes() {
        return availableTimes;
    }

    /**
     * @param availableTimes The available show times to set
     */
    public void setAvailableTimes(String availableTimes) {
        this.availableTimes = availableTimes;
    }

   /**
     * @return The movie date
     */
    public String getMovieDate() {
        return movieDate;
    }

    /**
     * @param movieDate The movie date to set
     */
    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    /**
     * @return The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating The new rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return The runtime
     */
    public String getRunTime() {
        return runTime;
    }
  
    /**
     * @param runTime The new runtime to set
     */
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
    
    /**
     * @param seatID The ID of the seat to find
     * @return The Seat object if found, otherwise null
     */
    public Seat findSeatbyID(int seatID) {
        for (Seat seat : seats) {
            if (seat.getSeatID() == seatID) {
                return seat;
            }
        }
        return null;
    }
    
    /**
     * @return A list of Seat objects that are available
     */
    public List<Seat> getAvailableSeats() {
        List<Seat> available = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                available.add(seat);
            }
        }
        return available;
    }
    
    /**
     * @return The sID
     */
    public int getSID(){
        return sID;
    }   
}