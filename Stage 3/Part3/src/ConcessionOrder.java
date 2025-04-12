/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
import java.util.ArrayList;

public class ConcessionOrder   { 
    private Customer customer;
    private FoodBeverage item;
    private int quantity;

    public ConcessionOrder(Customer customer, FoodBeverage item, int quantity)
    {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;

    }

//    public void addItem(Order item)
//    {
//        items.add(item);
//    }
//
//    public double calculateTotal()
//    {
//        double total = 0.0;
//        for(FoodBeverage item : items)
//        {
//            total += item.getPrice();
//        }
//        return total;
//    }
//
//    public ArrayList<FoodBeverage> getItems()
//    {
//        return items;
//    }

    
}
