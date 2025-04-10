/**
 * Represents a user's login credentials, username, password has, and the timestamp
 * of their last successful login.
 * Used by authenticable Users such as staff and customers in the system
 * @author Taryn Davis
 */
import java.time.LocalDateTime;

public class Credential {
    private String username;
    private String passwordHash;
    private LocalDateTime lastLogin;

    /**
     * Constructs a Credential object with a username and password hash
     * @param username the login username
     * @param passwordHash the hashed version of the password 
     */
    public Credential(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.lastLogin = null;
    }

    /**
     * Validates whether the provided password matches the stored hash
     * @param inputPassword the password input to check
     * @return true if the password matches the stored hash, false otherwise
     */
    public boolean validatePassword(String inputPassword) {
        // NOTE: In production, compare password hashes
        return passwordHash.equals(inputPassword); // Simulated hash check
    }

    /**
     * Updates the stored password hash with a new one
     * 
     * @param newPasswordHash the new password hash to set
     */
    public void updatePassword(String newPasswordHash) {
        this.passwordHash = newPasswordHash;
    }

    /**
     * Sets the last login time to current system time
     */
    public void updateLastLogin() {
        this.lastLogin = LocalDateTime.now();
    }

    /**
     * Gets the username associated with these credentials
     * @return 
     */
    public String getUsername() { 
        return username; 
    }
    
    /**
     * Gets the password hash
     * @return 
     */
    public String getPasswordHash() { 
        return passwordHash; 
    }
    
    /**
     * Gets the date and time of the last successful login 
     * @return a LocalDateTime object representing the last login time
     */
    public LocalDateTime getLastLogin() { 
        return lastLogin; 
    }    
}
