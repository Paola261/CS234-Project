/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * ConcessionProcessor class that handles the inventory management and sales of
 * FoodBeverage items
 * @author paolapereda
 */
import java.util.List;

public class ConcessionProcessor {
    List<FoodBeverage> inventory;
    List<Customer> customers;

    /**
     * Constructs a new ConcessionProcessor with the inventory and customers
     * @param inventory
     * @param customers 
     */
    public ConcessionProcessor(List<FoodBeverage> inventory, List<Customer> customers) {
        this.inventory = inventory;
        this.customers = customers;
    }

    // Check if a concession item is available in the requested quantity
    public boolean isItemAvailable(int itemID, int quantity) {
        for (FoodBeverage item : inventory) {
            if (item.getItemID() == itemID) {
                return item.getQuantity() >= quantity;
            }
        }
        return false; // Item not found
    }

    // Sell a concession item to a customer
    public boolean sellItem(int customerID, int itemID, int quantity) {
        Customer customer = findCustomerByID(customerID);
        FoodBeverage item = findItemByID(itemID);

        if (customer != null && item != null && item.getQuantity() >= quantity) {
            // Decrease inventory
            item.decreaseQuantity(quantity);
            // Add item to customer's purchases
            customer.addItem(item, quantity);
            return true;
        }
        return false; // Sale failed
    }

    // Helper method to find a customer
    private Customer findCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }

    // Helper method to find an item
    private FoodBeverage findItemByID(int itemID) {
        for (FoodBeverage item : inventory) {
            if (item.getItemID() == itemID) {
                return item;
            }
        }
        return null; // if ID is not founds
    }
}

