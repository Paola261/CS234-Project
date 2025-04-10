/**
 *
 * @author Taryn Davis
 */
public class StaffManager {
    private Map<Integer, Staff> staffDirectory;

    public StaffManager() {
        this.staffDirectory = new HashMap<>();
    }

    public boolean assignRole(Staff staff, String newRole) {
        staff.setRole(newRole);
        System.out.println("Assigned role '" + newRole + "' to " + staff.getName());
        return true;
    }

    public boolean updateSchedule(Staff staff, String newSchedule) {
        // For now, just print action — would store shift data in a real system
        System.out.println("Updated schedule for " + staff.getName() + ": " + newSchedule);
        return true;
    }

    public void addStaff(Staff staff) {
        staffDirectory.put(staff.getStaffID(), staff);
        System.out.println("Added staff member: " + staff.getName());
    }

    public Staff getStaffByID(int staffID) {
        return staffDirectory.get(staffID);
    }
}