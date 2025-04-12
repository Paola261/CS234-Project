/**
 * Represents a staff member in the movie theater system.
 * Inherits basic identity attributes from the person class and implements
 * the Autheticatable interface for login functionality
 * @author Taryn Davis
 */
public class Staff extends Person implements Authenticatable {
    private int staffID;
    private String role;
    private Credential credential;

    /**
     * Constructs a Staff object with identity, role and credential information
     * @param name the staff member's name
     * @param age the staff member's age
     * @param personID the unique person ID inherited from Person
     * @param staffID the unique staff ID
     * @param role the role assigned to the staff member
     * @param credential the credential object for authentication
     */
    public Staff(String name, int age, int personID, int staffID, String role, Credential credential) {
        super(name, age, personID);
        this.staffID = staffID;
        this.role = role;
        this.credential = credential;
    }

    /**
     * Returns the staff member's ID
     * @return the staff ID
     */
    public int getStaffID() { 
        return staffID; 
    }
    
    /**
     * Returns the staff member's role
     * @return the staff role as a string
     */
    public String getRole() { 
        return role; 
    }
    
    /**
     * Returns the staff member's Credential object
     * 
     * @return the credential object
     */
    public Credential getCredential() { 
        return credential; 
    }

    /**
     * Sets the staff member's role
     * 
     * @param role the new role to assign 
     */
    public void setRole(String role) { this.role = role; }

    /**
     * Authenticates the staff member using a username and password.
     * If successful, updates the last login timestamp
     * @param username the entered username
     * @param password the entered password
     * @return true if login is successful, fale otherwise
     */
    @Override
    public boolean login(String username, String password) {
        if (credential.getUsername().equals(username) &&
            credential.validatePassword(password)) {
            credential.updateLastLogin();
            System.out.println(name + " logged in successfully.");
            return true;
        } else {
            System.out.println("Login failed for " + name);
            return false;
        }
    }

    /**
     * Logs the staff member out of the system
     */
    @Override
    public void logout() {
        System.out.println(name + " logged out.");
    }

    
    /**
     * Indicates the start of the staff member's shift.
     * 
     */
    public void startShift() {
        System.out.println(name + " is starting their shift.");
    }

    /**
     * Indicates the end of the staff members shift
     */
    public void endShift() {
        System.out.println(name + " is ending their shift.");
    }   
}
