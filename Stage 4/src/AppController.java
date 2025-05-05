/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Taryn
 */
public class AppController {
    private static AppController instance;
    private ScheduleManager scheduleManager;
    private StaffManager staffManager;
    private InventoryManager inventoryManager;
    private Inventory inventory = new Inventory();
    private MaintenanceManager maintenanceManager;
    

    private final String SHOWTIME_FILE = "showtimes.txt";
    private final String STAFF_FILE = "staff.txt";
    private final String MAINTENANCE_FILE = "maintenance.txt";

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

    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }

    public ScheduleManager getScheduleManager() {
        return scheduleManager;
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }
    
    public MaintenanceManager getMaintenance() {
        return maintenanceManager;
    }

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
    
    public void saveAllData() {
        if (!scheduleManager.getShowtimes().isEmpty()) {
            ShowtimeFileHandler.saveShowtimes(scheduleManager.getShowtimes());
        }
        if (!staffManager.getAllStaff().isEmpty()) {
            StaffFileHandler.saveStaff(staffManager.getAllStaff());
        }
        maintenanceManager.saveIssuesToFile();
    }
    
    public InventoryManager getInventory() {
        return inventoryManager;
    }
    
    
}
