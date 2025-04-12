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
    }

    public void addFoodItem(String item)
    {
        foodItems.add(item);
    }

    public String getItemName()
    {
        return itemName;
    }

    public double getPrice()
    {
        return price;
    }

    public String getSize()
    {
        return size;
    }
    


    public String getSnacks(){

        return snacks;
    }
    
    public String getDrink(){
        return drink;
    }
    
    public int getItemID(){
        return itemID;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void decreaseQuantity(int amount) {
    this.quantity -= amount;
    }

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

