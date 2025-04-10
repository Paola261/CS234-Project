/**
 *
 * @author Taryn Davis
 */
import java.time.LocalDate;
import java.time.LocalTime;

public interface IScheduleHandler {
    boolean assignMovieToScreen(int movieID, int screenID, LocalDate date, LocalTime time);
    
    boolean resetSeats(int screenID);
}
