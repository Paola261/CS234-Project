/**
 *
 * @author paolapereda
 */

import java.util.ArrayList;

public class CustomerManager {
    
    private ArrayList<Customer> customers = new ArrayList<>();
    
    public CustomerManager()
    {
        
    }
    

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomerByName(String name) {
        for (Customer c : customers) {
            if (c.getCustomerName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }
    
    public void removeCustomer(Customer c) 
    {
        customers.remove(c);
    }
}
