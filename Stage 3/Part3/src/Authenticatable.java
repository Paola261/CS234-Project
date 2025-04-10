/**
 *
 * @author Taryn Davis
 */
public interface Authenticatable {
    boolean login(String username, String password);
    void logout();
}
