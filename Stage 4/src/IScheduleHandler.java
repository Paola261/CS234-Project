/**
 * Interface for managing movie scheduling tasks such as assigning 
 * movies to screens and resetting seat layouts for scheduled showings.
 * 
 * This interface is implemented by schedule management classes
 * or used by manager-level staff to delegate scheduling operations.
 * @author Taryn Davis
 */
import java.time.LocalDate;
import java.time.LocalTime;

public interface IScheduleHandler {
    /**
     * Assigns a movie to a specific screen for a given date and time
     * @param movieID The ID of the movie to be scheduled
     * @param screenID The ID of the screen where the movie will play
     * @param date the date of the scheduled showing
     * @param time The time of the scheduled showing
     * @return true if the assignment is successful, false if otherwise
     */
    boolean assignMovieToScreen(int movieID, int screenID, LocalDate date, LocalTime time);
    
    /**
     * Resets seats in a specific screen making them all available again
     * @param screenID The ID of the screen to reset
     * @return true if successful, false otherwise
     */
    boolean resetSeats(int screenID);
}
