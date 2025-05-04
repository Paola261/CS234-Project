/**
 * Represents a manager in the movie theater system. Has responsibilities such as 
 * overseeing operations, managing staff schedules, assigning movies to screens, 
 * and handling maintenance concerns
 * 
 * Inherits authentication and common staff behavior from the Staff class.
 * Overrides shift-related methods with manager-specific messages
 * @author Taryn Davis
 */
public class Manager extends Staff {
    /**
     * Constructs a Manager object with the provided information
     * @param name the name of the manager
     * @param age The age of the manager
     * @param personID The general person ID
     * @param staffID The unique staff ID
     * @param role The role/title of the staff member
     * @param credential The credential object for authentication
     */
    public Manager(String name, int age, int personID, int staffID, String role, Credential credential) {
        super(name, age, personID, staffID, role, credential);
    }

    /**
     * Starts the manager's shift with a custom message
     */
    @Override
    public void startShift() {
        System.out.println(getName() + " (Manager) is starting their shift.");
    }

    /**
     * Ends the managers shift with a custom message
     */
    @Override
    public void endShift() {
        System.out.println(getName() + " (Manager) is ending their shift.");
    }

    
    public void overseeOperations() {
        System.out.println(getName() + " is overseeing daily operations.");
    }
}
