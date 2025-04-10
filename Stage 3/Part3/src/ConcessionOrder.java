/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
import java.util.ArrayList;

public class ConcessionOrder extends Inventory {
     public ArrayList<FoodBeverage> items;

    public ConcessionOrder()
    {
        items = new ArrayList<>();

    }

    public void addItem(FoodBeverage item)
    {
        items.add(item);
    }

    public double calculateTotal()
    {
        double total = 0.0;
        for(FoodBeverage item : items)
        {
            total += item.getPrice();
        }
        return total;
    }

    public ArrayList<FoodBeverage> getItems()
    {
        return items;
    }

    
}
