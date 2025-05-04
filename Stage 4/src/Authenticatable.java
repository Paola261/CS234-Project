/**
 * Interface that defined authentication behavior for users such as staff 
 * 
 * @author Taryn Davis
 */
public interface Authenticatable {
    /**
     * Attempts to log in a user based on a username or password 
     * @param username the input username
     * @param password the input password
     * @return true if the authentication is successful, false otherwise
     */
    boolean login(String username, String password);
    
    /**
     * Logs the user out of the system
     */
    void logout();
}
