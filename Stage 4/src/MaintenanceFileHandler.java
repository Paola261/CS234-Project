import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 *  Class for handling reading and writing maintenance issue data to and from a text file
 * 
 * @author Taryn Davis
 */
public class MaintenanceFileHandler {
   
    /**
     * Loads maintenance issues from a file.
     * 
     * @param filename The name of the file
     * @return a list of MaitenanceIssue objects from the file
     */
     public static List<MaintenanceIssue> loadIssues(String filename) {
         
        List<MaintenanceIssue> issues = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",", -1);
                if (tokens.length >= 5) {
                    int id = Integer.parseInt(tokens[0]);
                    String description = tokens[1];
                    String reportedBy = tokens[2];
                    String dateReported = tokens[3];
                    String status = tokens[4];
                    String resolveNote = tokens.length >= 6 ? tokens[5] : "";
                    issues.add(new MaintenanceIssue(id, description, reportedBy, dateReported, status, resolveNote));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading maintenance file: " + e.getMessage());
        }
        return issues;
    }

     /**
      * Saves a list of maintenance issues to the txt file.
      * 
      * @param filename The name of the file to save the issue record
      * @param allIssues  The list of Issue objects to save
      */
    public static void saveIssues(String filename, List<MaintenanceIssue> allIssues) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (MaintenanceIssue issue : allIssues) {
                writer.write(issue.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing maintenance file: " + e.getMessage());
        }
    }
}
