/**
 * Represents an engineer staff memeber responsible for handling maintenance tasks
 * in the movie theater system. Engineers can view assigned sections, review pending 
 * maintenance issues, and mark issues as resolved
 * 
 * Inherits authentication and staff- related attributes from the Staff class
 * @author Taryn Davis
 */
import java.util.ArrayList;
import java.util.List;

public class Engineer extends Staff {
    private List<String> assignedSections;
    private List<String> resolvedIssues;

    /**
     * Constructs an Engineer object
     * @param name The name of the Engineer
     * @param age The age of the Engineer
     * @param personID The personal ID from the Person class
     * @param staffID the unique staff ID
     * @param role the role title assigned to the staff member
     * @param credential the credential object required for authentication
     */
    public Engineer(String name, int age, int personID, int staffID, String role, Credential credential) {
        super(name, age, personID, staffID, role, credential);
        this.assignedSections = new ArrayList<>();
        this.resolvedIssues = new ArrayList<>();
    }

    /**
     * Returns the list of assigned sections the Engineer is responsible for
     * @return a list of assigned section names
     */
    public List<String> getAssignedSections() {
        return assignedSections;
    }

    /**
     * Adds a new section to the engineer's list of responsibilities 
     * @param section the name of the section to assign
     */
    public void addSection(String section) {
        assignedSections.add(section);
    }

    /**
     * Displays a list of current pending maintenance issues
     * @param issues a list of issue descriptions to be reviewed
     */
    public void viewPendingIssues(List<String> issues) {
        System.out.println(getName() + " is viewing pending maintenance issues:");
        for (String issue : issues) {
            System.out.println(" - " + issue);
        }
    }

    /**
     * Marks a specific maintenance issue as resolved
     * @param issueID the description or ID of the resolved issue
     */
    public void markIssueAsResolved(String issueID) {
        System.out.println(getName() + " resolved issue: " + issueID);
        resolvedIssues.add(issueID);
    }

    /**
     * Returns a list of issues that this engineer has resolved
     * @return a list of resolved issue IDs or descriptions
     */
    public List<String> getResolvedIssues() {
        return resolvedIssues;
    }    
}
