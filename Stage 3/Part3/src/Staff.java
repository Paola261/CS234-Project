/**
 *
 * @author Taryn Davis
 */
public class Staff extends Person implements Authenticatable {
    private int staffID;
    private String role;
    private Credential credential;

    public Staff(String name, int age, int personID, int staffID, String role, Credential credential) {
        super(name, age, personID);
        this.staffID = staffID;
        this.role = role;
        this.credential = credential;
    }

    // Getters
    public int getStaffID() { return staffID; }
    public String getRole() { return role; }
    public Credential getCredential() { return credential; }

    // Setters
    public void setRole(String role) { this.role = role; }

    // Authentication methods
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

    @Override
    public void logout() {
        System.out.println(name + " logged out.");
    }

    // Optional: startShift/endShift placeholders
    public void startShift() {
        System.out.println(name + " is starting their shift.");
    }

    public void endShift() {
        System.out.println(name + " is ending their shift.");
    }   
}
