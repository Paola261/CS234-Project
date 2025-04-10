/**
 *
 * @author Taryn Davis
 */
import java.util.ArrayList;
import java.util.List;

public class Engineer extends Staff {
    private List<String> assignedSections;
    private List<String> resolvedIssues;

    public Engineer(String name, int age, int personID, int staffID, String role, Credential credential) {
        super(name, age, personID, staffID, role, credential);
        this.assignedSections = new ArrayList<>();
        this.resolvedIssues = new ArrayList<>();
    }

    public List<String> getAssignedSections() {
        return assignedSections;
    }

    public void addSection(String section) {
        assignedSections.add(section);
    }

    public void viewPendingIssues(List<String> issues) {
        System.out.println(getName() + " is viewing pending maintenance issues:");
        for (String issue : issues) {
            System.out.println(" - " + issue);
        }
    }

    public void markIssueAsResolved(String issueID) {
        System.out.println(getName() + " resolved issue: " + issueID);
        resolvedIssues.add(issueID);
    }

    public List<String> getResolvedIssues() {
        return resolvedIssues;
    }    
}
