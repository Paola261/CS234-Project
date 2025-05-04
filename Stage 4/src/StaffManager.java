/**
 * Manages operations related to staff in the movie theater system,
 * including assigning roles, updating schedules, and tracking staff members
 * 
 * This class is typically used by manager to modify and retrieve staff information
 * Stores staff members in a directory mapped by their staff ID
 * @author Taryn Davis
 */
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class StaffManager {
    private Map<Integer, Staff> staffDirectory;
    private List<Staff> staffList = new ArrayList<>();

    /**
     * Constructs a StaffManager with an empty staff Directory
     */
    public StaffManager() {
        this.staffDirectory = new HashMap<>();
    }

    /**
     * Assigns a new role to the specified staff member
     * 
     * @param staff the staff member whose role is to be updated
     * @param newRole the new role to assign
     * @return true if the role assignment is successful
     */
    public boolean assignRole(Staff staff, String newRole) {
        staff.setRole(newRole);
        System.out.println("Assigned role '" + newRole + "' to " + staff.getName());
        return true;
    }

    /**
     * Updates the schedule for the specified staff member.
     * @param staff The staff memeber whose schedule is being updated
     * @param newSchedule a string representing the new schedule
     * @return true if the schedule update is successful
     */
    public boolean updateSchedule(Staff staff, String newSchedule) {
        // For now, just print action — would store shift data in a real system
        System.out.println("Updated schedule for " + staff.getName() + ": " + newSchedule);
        return true;
    }

    /**
     * Adds a new staff member to the internal staff directory
     * @param staff the staff member to add
     */
    public void addStaff(Staff staff) {
        staffDirectory.put(staff.getStaffID(), staff);
        
    }

    /**
     * Retrieves a staff member by their unique staff ID
     * @param staffID the ID of the staff member to retrieve
     * @return The Staff object if found, or null if not found
     */
    public Staff getStaffByID(int staffID) {
        return staffDirectory.get(staffID);
    }
    
    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffDirectory.values());
    }
    
    public boolean removeStaffByID(int staffID) {
        return staffDirectory.remove(staffID) != null;
    }
    public void setAllStaff(List<Staff> staffList) {
        this.staffList = staffList; 
        staffDirectory.clear(); 
        for (Staff s : staffList) {
            staffDirectory.put(s.getStaffID(), s);
        }
    }
}