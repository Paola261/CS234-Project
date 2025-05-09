/**
 * Handles the logging, tracking, and resolution of the maintenance issues
 * in the movie theater system. Engineers and managers use this class to manage 
 * maintenance-related tasks.
 * 
 * Issues are stored as string descriptions and can be logged, retrieved,
 * and marked as resolved
 * @author Taryn Davis
 */
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;

public class MaintenanceManager {    
    /**
     * List of currently unresolved maintenance issues.
     */
    private List<MaintenanceIssue> openIssues = new ArrayList<>();
    /**
     * List of resolved maintenance issues.
     */
    private List<MaintenanceIssue> resolvedIssues = new ArrayList<>();
    /**
     * The file used to store maintenance issues
     */
    private String filename;
    /**
     * Constructs a new MaintenanceManager with an empty list of pending issues
     */
    public MaintenanceManager(String filename) {
        this.openIssues = new ArrayList<>();
        this.resolvedIssues = new ArrayList<>();

        List<MaintenanceIssue> allIssues = MaintenanceFileHandler.loadIssues(filename);
        for (MaintenanceIssue issue : allIssues) {
            if (issue.getStatus().equalsIgnoreCase("Open")) {
                openIssues.add(issue);
            } else if (issue.getStatus().equalsIgnoreCase("Resolved")) {
                resolvedIssues.add(issue);
            }
        }
    }
    
    /**
     * Adds a new maintenance issue to the list of open issues.
     * @param issue The maintenance issue to be logged
     */
    public void logIssue(MaintenanceIssue issue) {
        openIssues.add(issue);
        
    }

    /**
     * Resolves an open issue by marking its status as "Resolved"
     * adds a resolution note and move it to the resolved issues list.
     * @param issue the issue to resolve
     * @param resolveNote the note describing the resolution
     * @return true if the issue was successfully resolved; false if the issue was not found in open issues
     */
    public boolean resolveIssue(MaintenanceIssue issue, String resolveNote) {
        if (openIssues.contains(issue)) {
            openIssues.remove(issue);
            issue.setStatus("Resolved");
            issue.setResolveNote(resolveNote);
            resolvedIssues.add(issue);
            
            return true;
        }
        return false;
    }
    
    /**
     * Returns a copy of the list of open maintenance issues
     * @return list of open issues
     */
    public List<MaintenanceIssue> getOpenIssues() { 
        return new ArrayList<>(openIssues); 
    }
    
    /**
     * Returns a copy of the list of resolved maintenance issues.
     * @return list of resolved issues
     */
    public List<MaintenanceIssue> getResolvedIssues() { 
        return new ArrayList<>(resolvedIssues); 
    }
   
    
    private static final String FILE_NAME = "maintenance.txt";

    /**
     * Saves both open and resolved maintenance issues to a file. 
     */
    public void saveIssuesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (MaintenanceIssue issue : openIssues) {
                writer.write(formatIssue(issue));
            }
            for (MaintenanceIssue issue : resolvedIssues) {
                writer.write(formatIssue(issue));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Formats a MaintenanceIssue object into a comma-seperated string
     * @param issue the maintenance issue to format
     * @return a string representation of the Issue
     */
    private String formatIssue(MaintenanceIssue issue) {
        return issue.getID() + "," + issue.getDescription() + "," + issue.getReportedBy() + "," +
                issue.getDateReported() + "," + issue.getStatus() + "," + issue.getResolutionNote() + "\n";
    }

    /**
     * Loads maintenance issues from the file into memory.
     * This will overwrite any current in-memory data.
     */
    public void loadIssuesFromFile() {
        openIssues.clear();
        resolvedIssues.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1); // include empty resolution notes
                if (parts.length >= 6) {
                    int id = Integer.parseInt(parts[0]);
                    String desc = parts[1];
                    String reporter = parts[2];
                    String date = parts[3];
                    String status = parts[4];
                    String resolution = parts[5];
                    MaintenanceIssue issue = new MaintenanceIssue(id, desc, reporter, date, status, resolution);
                    if (status.equalsIgnoreCase("Open")) {
                        openIssues.add(issue);
                    } else {
                        resolvedIssues.add(issue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


