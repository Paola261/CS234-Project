import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for handling inventory file operations to load data from the txt file
 * to the memory
 * @author Taryn Davis
 */
public class InventoryFileHandler {
     /**
     * Loads the inventory from a text file and returns a list of Items.
     * @param filename the name of the inventory file
     * @return a list of Items (specifically Concession items)
     */
    public static ArrayList<Items> loadInventory(String filename) {
        ArrayList<Items> items = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("Inventory file not found.");
            return items;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());
                    double price = Double.parseDouble(parts[2].trim());

                    items.add(new Concession(name, quantity, price));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }

        return items;
    }
}
