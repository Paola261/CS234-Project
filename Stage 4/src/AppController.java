
import java.io.*;
import java.util.*;
/**
 * The AppController class serves as the main controller of the application.
 * It handles initialization and access to all core manager such as schedule, staff,
 * inventory, and maintenance. It also provides methods to load and save persistant data.
 * @author Taryn
 */
public class AppController {
    private static AppController instance;
    private ScheduleManager scheduleManager;
    private StaffManager staffManager;
    private InventoryManager inventoryManager;
    private Inventory inventory = new Inventory();
    private MaintenanceManager maintenanceManager;
    private CustomerManager customerManager;
    

    private final String SHOWTIME_FILE = "showtimes.txt";
    private final String STAFF_FILE = "staff.txt";
    private final String MAINTENANCE_FILE = "maintenance.txt";

    /**
     * Constructor to initalize all managers and load the necessary data files
     */
    private AppController() {
        this.scheduleManager = new ScheduleManager();
        this.staffManager = new StaffManager();
        this.inventoryManager = new InventoryManager();        
        this.maintenanceManager = new MaintenanceManager("maintenance.txt");
        
        
        ArrayList<Items> loadedItems = InventoryFileHandler.loadInventory("Inventory.txt");
        for (Items item : loadedItems) {
            inventoryManager.addItem(item);
        }
    }

    /**
     * Gets the single instance of the AppController
     * @return  the single instance of the AppController
     */
    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }

    /**
     * Returns the Schedule Manager used for managing showtimes
     * @return The ScheduleManagerInstance
     */
    public ScheduleManager getScheduleManager() {
        return scheduleManager;
    }

    /**
     * Returns the Staff Manager used for managing staff data
     * @return The StaffManager instance
     */
    public StaffManager getStaffManager() {
        return staffManager;
    }
    
    public CustomerManager getCustomerManager() {
        return customerManager;
    }
    
    /**
     * Returns the MaintenanceManager used for managing maintenence issues
     * @return the MaintenanceManager instance
     */
    public MaintenanceManager getMaintenance() {
        return maintenanceManager;
    }

    /**
     * Saves all current showtimes to a file
     */
    public void saveShowtimesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SHOWTIME_FILE))) {
            for (Showtime s : scheduleManager.getShowtimes().values()) {
                writer.write(s.getMovieTitle() + "," + s.getAvailableTimes() + "," + s.getMovieDate() + ","
                        + s.getRating() + "," + s.getRunTime() + "," + s.getSID());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads showtime data from file and populates the schedule manager. 
     */
    public void loadShowtimesFromFile() {
        File file = new File(SHOWTIME_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 6) {
                    Showtime s = new Showtime(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]));
                    scheduleManager.addShowtime(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Saves all application data including showtimes, staff, and maintenance records to their
     * files
     */
    public void saveAllData() {
        if (!scheduleManager.getShowtimes().isEmpty()) {
            ShowtimeFileHandler.saveShowtimes(scheduleManager.getShowtimes());
        }
        if (!staffManager.getAllStaff().isEmpty()) {
            StaffFileHandler.saveStaff(staffManager.getAllStaff());
        }
        maintenanceManager.saveIssuesToFile();
    }
    
    /**
     * Returns the InventoryManager used for managing concession items.
     * @return The InventoryManager Instance
     */
    public InventoryManager getInventory() {
        return inventoryManager;
    }
    
    
}
