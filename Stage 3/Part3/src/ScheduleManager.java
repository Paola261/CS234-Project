/**
 *
 * @author Taryn Davis
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ScheduleManager {
    private Map<Integer, ShowTime> showtimes;

    public ScheduleManager() {
        this.showtimes = new HashMap<>();
    }

    public boolean assignMovieToScreen(int movieID, int screenID, LocalDate date, LocalTime time) {
        int showtimeID = showtimes.size() + 1; // generate a simple ID
        ShowTime newShowTime = new ShowTime(showtimeID, movieID, screenID, date, time, false);
        showtimes.put(showtimeID, newShowTime);
        System.out.println("Movie " + movieID + " assigned to Screen " + screenID + " at " + time + ".");
        return true;
    }

    public boolean resetSeats(int screenID) {
        System.out.println("Seats for Screen " + screenID + " have been reset.");
        // In a real system, you'd call something like screen.resetSeats();
        return true;
    }

    public Map<Integer, ShowTime> getShowtimes() {
        return showtimes;
    }
    
}
