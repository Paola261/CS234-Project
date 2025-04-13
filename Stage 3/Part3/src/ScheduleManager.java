/**
 *  Manages movie scheduling tasks such as assigning movies to screens 
 * and resetting seat layouts. Maintains a map of scheduled showtime's
 * @author Taryn Davis
 */

import java.util.HashMap;
import java.util.Map;

public class ScheduleManager {
    private Map<Integer, Showtime> showtimes;

    /**
     * Constructs a new ScheduleManager with an empty showtime list
     */
    public ScheduleManager() {
        this.showtimes = new HashMap<>();
    }

    /**
     * This class assigns movies to screens 
     * @param movieTitle The movie to be added
     * @param availableTimes The time to be added
     * @param movieDate The date to be added
     * @param rating The rating of the movie
     * @param runTime The runtime of the movie
     * @return True if the assignment was successful
     */
    public boolean assignMovieToScreen(String movieTitle, String availableTimes, String movieDate, String rating, String runTime) {
        int showtimeID = showtimes.size() + 1;
        Showtime newShowtime = new Showtime(movieTitle, availableTimes, movieDate, rating, runTime);
        showtimes.put(showtimeID, newShowtime);
        System.out.println("Movie " + movieTitle + " assigned at " + availableTimes + " on " + movieDate);
        return true;
    }

    /**
     * Simulates resetting all seats in the specified screen to available.
     * 
     * @param screenID The ID of the screen to reset
     * @return true if the screen's seats were reset successfully
     */
    public boolean resetSeats(int screenID) {
        System.out.println("Seats for Screen " + screenID + " have been reset.");
        // In a real system, you'd call something like screen.resetSeats();
        return true;
    }

    /**
     * Retrieves the map of all scheduled showtime
     * @return  a map of showtime IDs to Showtime objects
     */
    public Map<Integer, Showtime> getShowtimes() {
        return showtimes;
    }
    
}
