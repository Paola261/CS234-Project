/**
 *
 * @author melissaflores
 */
import java.util.Scanner;


public class InventoryManager extends Inventory {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InventoryManager inventoryCRUD = new InventoryManager();
        inventoryCRUD.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Sell Item");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
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
        newItem = new Items(name, quantity, price);
        super.addItem(newItem);
        System.out.println(name + " added to inventory.");
    }

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

    private void sellItem() {
        System.out.print("Enter item name to sell: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity to sell: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        super.sellItem(name, quantity);
    }
}