import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Class that stores the Customer name, ID, and age
 * Maintains a list of ticket orders and concession order
 * @author paolapereda
 */
import java.util.List;

public class Customer {
    public String name; // or private
    public int customerID;
    public byte age;
    private List<TicketOrder> ticketOrders;
    private List<ConcessionOrder> concessionOrders;
    private Map<FoodBeverage, Integer> ordersSold;
//    private List<String> customerList; 

    

    /**
     * Constructor for a Customer
     * @param name
     * @param customerID
     * @param age 
     */
    public Customer(String name, int customerID, byte age)
    {
        this.name = name;
        this.customerID = customerID; 
        this.age = age;
        ticketOrders = new ArrayList<>();
        concessionOrders = new ArrayList<>();
        ordersSold = new HashMap<>();
//        customerList = new ArrayList<>();
        
    }
    
    /**
     * Method that returns a Customers Info
     * @return 
     */
    public String getCustomerInfo()
    {
        return "Customers Name: " + name + " ID: " + customerID + " Age: " + age;
    }
    
    /**
     * Returns the name for Customer
     * @return 
     */
   public String getCustomerName()
   {
       return name;
   }
   
   /**
    * Return the customer ID
    * @return 
    */
   public int getCustomerID()
   {
       return customerID;
   }
   
   /**
    * Returns the age for the Customer
    * @return 
    */
   public byte getCustomerAge()
   {
       return age;
   }
   
   /**
    * Method to add a ticket order to a Customer 
    * @param order ~ object of class TicketOrder
    */
   public void addTicketOrder(TicketOrder order){
       ticketOrders.add(order);
   }
   
   /**
    * Method to add a concession order to a Customer
    * @param order ~ object of class ConcessionOrder
    */
   public void addConcessionOrder(ConcessionOrder order){
       concessionOrders.add(order);
       
   }  
   public void addItem(FoodBeverage item, int quantity) {
       ordersSold.put(item, quantity);
   }
   
//   public void addCustomer(String name, int ID, byte age) ////STOPPED HERE
//   {
//       Customer newCustomer = new Customer(name, ID, age);
//       customerList.add(newCustomer);
//       
//   }

    
   
   
}