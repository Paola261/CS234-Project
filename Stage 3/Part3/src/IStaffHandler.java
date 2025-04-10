/**
 *
 * @author Taryn Davis
 */
public interface IStaffHandler {
    boolean assignRole(Staff staff, String role);
    
    boolean updateSchedule(Staff staff, String newSchedule);
    
}
