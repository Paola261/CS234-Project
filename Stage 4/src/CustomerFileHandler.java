import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles reading and writing customer data to and from a CSV file.
 * This class separates file I/O from UI logic, promoting modularity and reusability.
 */
public class CustomerFileHandler {

    /** The path to the CSV file storing customer data */
    private final String filePath;

    /**
     * Constructs a new CustomerFileHandler for the specified file path.
     * 
     * @param filePath the path to the CSV file
     */
    public CustomerFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads customer data from the CSV file.
     * Each line is expected to have the format: name,id,age
     * 
     * @return a list of Customer objects parsed from the file
     */
    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    int id = Integer.parseInt(parts[1].trim());
                    byte age = Byte.parseByte(parts[2].trim());
                    customers.add(new Customer(name, id, age));
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Customer file not found. A new file will be created upon saving.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    /**
     * Saves the given list of customers to the CSV file.
     * Each customer is written as a line in the format: name,id,age
     * 
     * @param customers the list of Customer objects to save
     */
    public void saveCustomers(List<Customer> customers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Customer c : customers) {
                String row = c.getCustomerName() + "," + c.getCustomerID() + "," + c.getCustomerAge();
                writer.println(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
