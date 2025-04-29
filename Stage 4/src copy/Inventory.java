/**
 * Represents an inventory of items
 * @author Melissa Flores
 */
import java.util.ArrayList;

public class Inventory {

    /**
     * The list of items in the inventory
     */
    public ArrayList<Items> items;

    /**
     * Constructs an empty Inventory
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }
    
    /**
     * @return The list of items.
     */
    public ArrayList<Items> getItems() {
        return items;
    }

    /**
     * @param item The item to add.
     */
    public void addItem(Items item) {
        this.items.add(item);
    }

    /**
     * @param item The item to remove
     */
    public void removeItem(Items item) {
        this.items.remove(item);
    }
    
    /**
     * @param name The name of the item to sell
     * @param quantity The quantity to sell
     */
    public void sellItem(String name, int quantity) {
        for (Items item : items) {
            if (item.getName().equals(name)) {
                if (item.getQuantity() >= quantity) {
                    item.sell(quantity);
                    System.out.println(quantity + " " + name + "(s) sold.");
                } else {
                    System.out.println("Not enough " + name + " in stock.");
                }
                return;
            }
        }
        System.out.println(name + " not found in inventory.");
    }

    /**
     * Displays the inventory of items
     */
    public void displayInventory() {
        System.out.println("-------- Inventory --------");
        for (Items item : items) {
            System.out.println(item.getName() + ": " + item.getQuantity());
        }
        System.out.println("---------------------------");
    }

    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
       
        Ticket adultCluelessTicket = new Ticket("Adult Ticket: Clueless", 87, 8.0);
        Ticket childCluelessTicket = new Ticket("Child Ticket: Clueless", 87, 6.0);
        Ticket seniorCluelessTicket = new Ticket("Senior Ticket: Clueless", 87, 6.0);
        Ticket matineeCluelessTicket = new Ticket("Matinee Ticket: Clueless", 87, 4.0);
        Ticket adultInsidiousTicket = new Ticket("Adule Ticket: Insidious", 74, 8.0);
        Ticket childInsidiousTicket = new Ticket("Child Ticket: Insidious", 74, 6.0);
        Ticket seniorInsidiousTicket = new Ticket("Senior Ticket: Insidious", 74, 6.0);
        Ticket matineeInsidiousTicket = new Ticket("Matinee Ticket: Insidious", 74, 4.0);
        Ticket adultDivergentTicket = new Ticket("Adult Ticket: Divergent", 74, 8.0);
        Ticket childDivergentTicket = new Ticket("Child Ticket: Divergent", 74, 6.0);
        Ticket seniorDivergentTicket = new Ticket("Senior Ticket: Divergent", 74, 6.0);
        Ticket matineeDivergentTicket = new Ticket("Matinee Ticket: Divergent", 74, 4.0);
        Ticket adultHighSchoolMusicalTicket = new Ticket("Adult Ticket: High School Musical", 108, 8.0);
        Ticket childHighSchoolMusicalTicket = new Ticket("Child Ticket: High School Musical", 108, 6.0);
        Ticket seniorHighSchoolMusicalTicket = new Ticket("Senior Ticket: High School Musical", 108, 6.0);
        Ticket matineeHighSchoolMusicalTicket = new Ticket("Matinee Ticket: High School Musical", 108, 4.0);
        Ticket adultBigHeroSixTicket = new Ticket("Adult Ticket: Big Hero Six", 108, 8.0);
        Ticket childBigHeroSixTicket = new Ticket("Child Ticket: Big Hero Six", 108, 6.0);
        Ticket seniorBigHeroSixTicket = new Ticket("Senior Ticket: Big Hero Six", 108, 6.0);
        Ticket matineeBigHeroSixTicket = new Ticket("Matinee Ticket: Big Hero Six", 108, 4.0);
        Concession mediumPopcorn = new Concession("Medium Popcorn", 250, 6.0);
        Concession largePopcorn = new Concession("Large Popcorn", 250, 7.0);
        Concession smallDrink = new Concession("Small Drink", 200, 3.0);
        Concession mediumDrink = new Concession("Medium Drink", 200, 4.0);
        Concession largeDrink = new Concession("Large Drink", 200, 5.0);
        Concession icee = new Concession("ICEE", 200, 4.0);
        Concession bottledWater = new Concession("Bottle Water", 200, 3.0);
        Concession twix = new Concession("Twix", 300, 3.5);
        Concession snickers = new Concession("Snickers", 300, 3.5);
        Concession twizzlers = new Concession("Twizzlers", 300, 3.5);
        Concession mms = new Concession("M&Ms", 300, 3.5);
        Concession nachos = new Concession("Nachos", 200, 5.0);
        Concession pretzels = new Concession("Pretzels", 200, 5.0);
        Concession dillPickles = new Concession("Dill Pickle", 200, 3.0);

        inventory.addItem(adultCluelessTicket);
        inventory.addItem(childCluelessTicket);
        inventory.addItem(seniorCluelessTicket);
        inventory.addItem(matineeCluelessTicket);
        inventory.addItem(adultInsidiousTicket);
        inventory.addItem(childInsidiousTicket);
        inventory.addItem(seniorInsidiousTicket);
        inventory.addItem(matineeInsidiousTicket);
        inventory.addItem(adultDivergentTicket);
        inventory.addItem(childDivergentTicket);
        inventory.addItem(seniorDivergentTicket);
        inventory.addItem(matineeDivergentTicket);
        inventory.addItem(adultHighSchoolMusicalTicket);
        inventory.addItem(childHighSchoolMusicalTicket);
        inventory.addItem(seniorHighSchoolMusicalTicket);
        inventory.addItem(matineeHighSchoolMusicalTicket);
        inventory.addItem(adultBigHeroSixTicket);
        inventory.addItem(childBigHeroSixTicket);
        inventory.addItem(seniorBigHeroSixTicket);
        inventory.addItem(matineeBigHeroSixTicket);
        inventory.addItem(mediumPopcorn);
        inventory.addItem(largePopcorn);
        inventory.addItem(smallDrink);
        inventory.addItem(mediumDrink);
        inventory.addItem(largeDrink);
        inventory.addItem(icee);
        inventory.addItem(bottledWater);
        inventory.addItem(twix);
        inventory.addItem(snickers);
        inventory.addItem(twizzlers);
        inventory.addItem(mms);
        inventory.addItem(nachos);
        inventory.addItem(pretzels);
        inventory.addItem(dillPickles);
    }
}

/**
 * Interface representing items with a name, quantity, and price that can be sold
 */
interface Items {
    String getName();
    int getQuantity();
    double getPrice();
    void sell(int quantity);
}

class Ticket implements Items {
    private String name;
    private int quantity;
    private double price;

    /**
     * @param name the name of the ticket
     * @param quantity the quantity of tickets
     * @param price the price of each ticket
     */
    public Ticket(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    /**
     * @return the name of the ticket
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * @return the quantity of tickets
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * @return the price of the ticket
     */
    @Override
    public double getPrice() {
        return price;
    }
    
    /**
     * @param quantity the quantity to sell
     */
    @Override
    public void sell(int quantity) {
        this.quantity -= quantity;
    }
}

class Concession implements Items {
    private String name;
    private int quantity;
    private double price;

    /**
     * @param name the name of the concession
     * @param quantity the quantity of the concession
     * @param price the price of the concession
     */
    public Concession(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    /**
     * @return the name of the concession
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * @return the quantity of the concession
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * @return the price of the concession
     */
    @Override
    public double getPrice() {
        return price;
    }
    
    /**
     * @param quantity the quantity to sell
     */
    @Override
    public void sell(int quantity) {
        this.quantity -= quantity;
    }
}