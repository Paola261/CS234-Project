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
    private List<MaintenanceIssue> openIssues = new ArrayList<>();
    private List<MaintenanceIssue> resolvedIssues = new ArrayList<>();
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
    public void logIssue(MaintenanceIssue issue) {
        openIssues.add(issue);
        
    }

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
    public List<MaintenanceIssue> getOpenIssues() { 
        return new ArrayList<>(openIssues); 
    }
    public List<MaintenanceIssue> getResolvedIssues() { 
        return new ArrayList<>(resolvedIssues); 
    }
   
    private static final String FILE_NAME = "maintenance.txt";

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

    private String formatIssue(MaintenanceIssue issue) {
        return issue.getID() + "," + issue.getDescription() + "," + issue.getReportedBy() + "," +
                issue.getDateReported() + "," + issue.getStatus() + "," + issue.getResolutionNote() + "\n";
    }

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


