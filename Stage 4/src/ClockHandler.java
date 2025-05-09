import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

/**
 * This class manages clock-in and clock-out actions for staff.
 * It logs actions to a persistent text file and provides access to clock history.
 * @author Taryn Davis
 */
public class ClockHandler {
    // The name of the file for clock-in/clock out
    private static final String FILE_NAME = "clock_log.txt";
    
    /**
     * Logs a clock action for the specified user
     * Appends the entry to the txt file with the current timestamp
     * 
     * @param name The name of the staff member
     * @param role The role of the staff member 
     * @param action The action taken
     */
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
    
    /**
     *  Retrieves the last recorded clock action for the specified user
     * Searches the txt for the most recent entry by name
     * @param name The name of the staff member
     * @return The last clock status
     */
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
    
    /**
     * Generates a full clock report for the specified user, listing all recorded
     * clock-ins and outs
     * @param name The name of the Staff member
     * @return A formatted string representing the full clock log history for that user
     */
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
