/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
import java.util.ArrayList;


public class FoodBeverage {

    private String itemName; 
    private double price;
    private String size;
    private String snacks;
    private String drink;
    private int itemID;
    private int quantity;

    public ArrayList<String> foodItems;


    /**
     * Constructor that represents either the food or drink from concession
     * @param itemName
     * @param price
     * @param size
     * @param snacks
     * @param drink
     * @param itemID
     * @param quantity 
     */
    public FoodBeverage(String itemName, double price, 
            String size, String snacks, String drink, int itemID, int quantity)
    {
         this.itemName = itemName;
         this.price = price;
         this.size = size;
         this.snacks = snacks;
         this.drink = drink;
         this.itemID = itemID;
         this.quantity = quantity;
         foodItems = new ArrayList<>();
    }

    /**
     * Adds a food item to an Array List
     * @param item 
     */
    public void addFoodItem(String item)
    {
        foodItems.add(item);
    }

    /**
     * Method to return the item name
     * @return 
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * Method to return the price
     * @return 
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Method to return size
     * @return 
     */
    public String getSize()
    {
        return size;
    }

    /**
     * Method to return the snacks
     * @return 
     */
    public String getSnacks(){

        return snacks;
    }
    
    /**
     * Method to return the drink
     * @return 
     */
    public String getDrink(){
        return drink;
    }
    
    /**
     * Method to return the item ID
     * @return 
     */
    public int getItemID(){
        return itemID;
    }
    
    /**
     * Method to return the quantity
     * @return 
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * Method to decrease quantity of an item by a certain amount
     * @param amount 
     */
    public void decreaseQuantity(int amount) {
    this.quantity -= amount;
    }

    /**
     * Returns the full order details
     * @return 
     */
    public String[] getOrder()
    {
        ArrayList<String> orderDetails = new ArrayList<>();
        orderDetails.add("Item: " + itemName);
        orderDetails.add("Size: " + size);
        orderDetails.add("Drink: " + drink);
        orderDetails.add("Snacks: " + snacks);
        orderDetails.add("Price:  $" + price);
        orderDetails.add("Quantity: " + quantity);
        orderDetails.addAll(foodItems);

        return orderDetails.toArray(new String[0]);
    }  
}

