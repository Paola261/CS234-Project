import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

/**
 *
 * @author Taryn Davis
 */
public class ClockHandler {
    private static final String FILE_NAME = "clock_log.txt";
    
    public static void clockAction(String name, String role, String action) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String logEntry = name + "," + role + "," + action + "," + timestamp;
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing clock log" + e.getMessage());
        }
    }
    
    public static String getLastClockStatus(String name) {
        String lastStatus = "Not Clocked In";
        try (BufferedReader reader = new BufferedReader(new FileReader("clock_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equals(name)) {
                    lastStatus = parts[2]; 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading clock log: " + e.getMessage());
        }
        return lastStatus;
    }
    
    public static String getFullClockReport(String name) {
        StringBuilder report = new StringBuilder("Clock Log for " + name + ":\n\n");

        try (BufferedReader reader = new BufferedReader(new FileReader("clock_log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equals(name)) {
                    report.append("[").append(parts[3]).append("] ")
                          .append(parts[2]) // action
                          .append(" as ").append(parts[1]) // role
                          .append("\n");
                }
            }
        } catch (IOException e) {
            report.append("Error reading log file.");
        }

        return report.toString();
    }

}
