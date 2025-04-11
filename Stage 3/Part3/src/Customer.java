
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
public class Customer {
    private String name;
    private int customerID;
    private byte age;
    public ArrayList<Order> orders;
    

    
    public Customer(String name, int customerID, byte age)
    {
        this.name = name;
        this.customerID = customerID; 
        this.age = age;
        orders = new ArrayList<>();
    }
    
    public String getCustomerInfo()
    {
        return "Customers Name: " + name + " ID: " + customerID + "Age: " + age;
    }
    
   public String getName()
   {
       return name;
   }
   
   public int getCustomerID()
   {
       return customerID;
   }
   
   public byte getCustomerAge()
   {
       return age;
   }

   public String getOrderHistory() 
   {
        if (orders.isEmpty()) {
            return name + " has not ordered any food or beverages.";
        }

        String items = name + "'s Orders:\n";
        for (Order order : orders) 
        {
            items += "- " + order.toString() + "\n";
        }

        return items;
}

    
    
    
}
