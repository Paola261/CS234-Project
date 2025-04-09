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

    private ArrayList<String> foodItems;

    public FoodBeverage()
    {
        // this.itemName = itemName;
        // this.price = price;
        // this.size = size;
        foodItems = new ArrayList<>();
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

    public String[] getOrder()
    {
        ArrayList<String> orderDetails = new ArrayList<>();
        orderDetails.add("Size: " + size);
        orderDetails.add("Drink: " + drink);
        orderDetails.add("Snacks: " + snacks);
        orderDetails.add("Price:  $" + price);
        orderDetails.addAll(foodItems);

        return orderDetails.toArray(new String[0]);
    }

    
}

