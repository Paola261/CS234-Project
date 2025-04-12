/**
 *
 * @author melissaflores
 */
public class Showtime {
    private String movieTitle;
    private String availableTimes;
    private String movieDate;
    private String rating;
    private String runTime;

    public Showtime(String movieTitle, String availableTimes, String movieDate, String rating, String runTime) {
        this.movieTitle = movieTitle;
        this.availableTimes = availableTimes;
        this.movieDate = movieDate;
        this.rating = rating;
        this.runTime = runTime;
    }

    // Getters and setters for all fields
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(String availableTimes) {
        this.availableTimes = availableTimes;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
}