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
    
    
}


