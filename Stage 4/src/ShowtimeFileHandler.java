import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Taryn
 */
public class ShowtimeFileHandler {
    private static final String FILE_NAME = "showtimes.txt";

    public static void saveShowtimes(Map<Integer, Showtime> showtimes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Showtime s : showtimes.values()) {
                writer.write(String.join(",",
                    s.getMovieTitle(),
                    s.getAvailableTimes(),
                    s.getMovieDate(),
                    s.getRating(),
                    s.getRunTime(),
                    String.valueOf(s.getSID())
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Showtime> loadShowtimes() {
        Map<Integer, Showtime> loaded = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Showtime s = new Showtime(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]));
                    loaded.put(s.getSID(), s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loaded;
    }
}

