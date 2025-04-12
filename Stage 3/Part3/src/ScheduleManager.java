/**
 *  Manages movie scheduling tasks such as assigning movies to screens 
 * and resetting seat layouts. Maintains a map of scheduled showtimes
 * @author Taryn Davis
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ScheduleManager {
    private Map<Integer, ShowTime> showtimes;

    /**
     * Constructs a new ScheduleManager with an empty showtime list
     */
    public ScheduleManager() {
        this.showtimes = new HashMap<>();
    }

    /**
     * Assigns a movie to a screen at a specific date and time
     * @param movieID The ID of the movie to assign
     * @param screenID The ID of the screen where the movie will play
     * @param date The date of the scheduled showing
     * @param time The time of the scheduled showing
     * @return true if the movie was successfully scheduled
     */
    public boolean assignMovieToScreen(int movieID, int screenID, LocalDate date, LocalTime time) {
        int showtimeID = showtimes.size() + 1; // generate a simple ID
        ShowTime newShowTime = new ShowTime(showtimeID, movieID, screenID, date, time, false);
        showtimes.put(showtimeID, newShowTime);
        System.out.println("Movie " + movieID + " assigned to Screen " + screenID + " at " + time + ".");
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
     * Retrieves the map of all scheduled showtimes
     * @return  a map of showtime IDs to Showtime objects
     */
    public Map<Integer, ShowTime> getShowtimes() {
        return showtimes;
    }
    
}
