/**
 * /**
 * Manages inventory operations, extending the Inventory class
 * @author Melissa Flores
 */
import java.util.Scanner;
import java.util.ArrayList;

public class InventoryManager extends Inventory {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InventoryManager inventoryCRUD = new InventoryManager();
        inventoryCRUD.run();
    }

    /**
     * Runs the main loop of the Inventory Management System, displaying a menu and processing user input.
     */
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Item");
            System.out.println("1. Remove Item");
            System.out.println("2. Sell Item");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> sellItem();
                case 4 -> displayInventory();
                case 5 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Items newItem;
        newItem = new ItemsImpl(name, quantity, price);
        super.addItem(newItem);
        System.out.println(name + " added to inventory.");
    }

    /**
     * Removes an item from the inventory
     */
    private void removeItem() {
        System.out.print("Enter item name to remove: ");
        String name = scanner.nextLine();
        Items itemToRemove = null;
        for (Items item : super.getItems()) {
            if (item.getName().equals(name)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            super.removeItem(itemToRemove);
            System.out.println(name + " removed from inventory.");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    /**
     * @param name     The name of the item to sell
     * @param quantity The quantity of the item to sell
     */
    private void sellItem() {
        System.out.print("Enter item name to sell: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity to sell: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        super.sellItem(name, quantity);
    }
    
    public ArrayList<Items> getInventory() {
        return super.getItems();
    }

    private static class ItemsImpl implements Items {

        private String name;
        private int quantity;
        private double price;

        public ItemsImpl(String name, int quantity, double price) {
        }

        @Override
        public String getName() {
            return name; 
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public void sell(int quantity) {
            this.quantity -= quantity;
        }
    }
}