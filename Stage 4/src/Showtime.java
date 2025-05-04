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
    
    public void setScreen(Integer sID) {
        this.sID = sID;
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
    
    /**
     * Get Layout Display of the screen
     * @param show
     * @return The Seat Dispay
     * @author Taryn Davis
     */
    public static String getSeatLayoutDisplay(Showtime show) {
    int screenID = show.getSID();
    boolean[][] seatAvailability;

    switch (screenID) {
        case 1:
        case 2:
        case 3:
            seatAvailability = new boolean[7][13]; // rows A–G, 13 seats each
            break;
        case 4:
        case 5:
            seatAvailability = new boolean[8][14]; // rows A–H, 14 seats each
            break;
        default:
            return "Unknown screen layout for screen " + screenID;
    }

    // Default all to available
    for (int i = 0; i < seatAvailability.length; i++) {
        for (int j = 0; j < seatAvailability[i].length; j++) {
            seatAvailability[i][j] = true;
        }
    }

    // Mark sold seats as unavailable
    for (Seat s : show.getAvailableSeats()) {
        if (!s.isAvailable()) {
            int row = s.getRow();   // make sure your Seat class has row/column info!
            int col = s.getNumber();
            seatAvailability[row][col] = false;
        }
    }

    // Build display string
    StringBuilder display = new StringBuilder("Screen " + screenID + " Layout:\n");
    char rowLabel = 'A';
    for (int i = 0; i < seatAvailability.length; i++) {
        display.append(rowLabel).append(" ");
        for (int j = 0; j < seatAvailability[i].length; j++) {
            display.append(seatAvailability[i][j] ? "○ " : "● ");
        }
        display.append("\n");
        rowLabel++;
    }

    // Add seat numbers below
    display.append("  ");
    for (int j = 1; j <= seatAvailability[0].length; j++) {
        display.append(j < 10 ? j + "  " : j + " ");
    }

    return display.toString();
}
}