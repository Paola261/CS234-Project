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
    private List<String> pendingIssues;

    /**
     * Constructs a new MaintenanceManager with an empty list of pending issues
     */
    public MaintenanceManager() {
        this.pendingIssues = new ArrayList<>();
    }

    /**
     * Logs a new maintenance issue by adding it to the pending issues list/
     * @param description the textual description of the maintenance issue
     */
    public void logIssue(String description) {
        pendingIssues.add(description);
    }

    /**
     * Retrieves the current list of pending maintenance issues.
     * @return a copy of the list of issue descriptions
     */
    public List<String> getPendingIssues() {
        return new ArrayList<>(pendingIssues);
    }

    /**
     * Resolves a maintenance issue by removing it from the pending list
     * @param issueID the description or identifier of the issue to resolve
     * @return true if the issue was found and removed, false otherwise
     */
    public boolean resolveIssue(String issueID) {
        if (pendingIssues.remove(issueID)) {
            System.out.println("Resolved maintenance issue: " + issueID);
            return true;
        } else {
            System.out.println("Issue not found: " + issueID);
            return false;
        }
    }
}


