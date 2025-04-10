/**
 *
 * @author Taryn Davis
 */
import java.util.ArrayList;
import java.util.List;

public class MaintenanceManager {
    private List<String> pendingIssues;

    public MaintenanceManager() {
        this.pendingIssues = new ArrayList<>();
    }

    public void logIssue(String description) {
        pendingIssues.add(description);
        System.out.println("Logged maintenance issue: " + description);
    }

    public List<String> getPendingIssues() {
        return new ArrayList<>(pendingIssues);
    }

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


