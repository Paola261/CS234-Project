
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
import java.util.List;

public class Customer {
    public String name; // or private
    public int customerID;
    public byte age;
    private List<TicketOrder> ticketOrders;
    private List<ConcessionOrder> concessionOrders;
    

    
    public Customer(String name, int customerID, byte age)
    {
        this.name = name;
        this.customerID = customerID; 
        this.age = age;
        ticketOrders = new ArrayList<>();
        concessionOrders = new ArrayList<>();
        
    }
    
    public String getCustomerInfo()
    {
        return "Customers Name: " + name + " ID: " + customerID + "Age: " + age;
    }
    
   public String getCustomerName()
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
   
   public void addTicketOrder(TicketOrder order){
       ticketOrders.add(order);
   }
   
   public void addConcessionOrder(ConcessionOrder order){
       concessionOrders.add(order);
       
   }

//   public String getOrderHistory() 
//   {
//        if (orders.isEmpty()) {
//            return name + " has not ordered any food or beverages.";
//        }
//
//        String items = name + "'s Orders:\n";
//        for (Order order : orders) // maybe not have Order class
//        {
//            items += "- " + order.toString() + "\n";
//        }
//
//        return items;
//    }

    
    
    
}
