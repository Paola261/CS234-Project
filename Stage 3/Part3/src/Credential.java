/**
 *
 * @author Taryn Davis
 */
import java.time.LocalDateTime;

public class Credential {
    private String username;
    private String passwordHash;
    private LocalDateTime lastLogin;

    public Credential(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.lastLogin = null;
    }

    public boolean validatePassword(String inputPassword) {
        // NOTE: In production, compare password hashes
        return passwordHash.equals(inputPassword); // Simulated hash check
    }

    public void updatePassword(String newPasswordHash) {
        this.passwordHash = newPasswordHash;
    }

    public void updateLastLogin() {
        this.lastLogin = LocalDateTime.now();
    }

    // Getters
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public LocalDateTime getLastLogin() { return lastLogin; }    
}
