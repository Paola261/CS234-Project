
import java.util.ArrayList;

/**
 * Abstract base class representing a generic person in the system.
 * Used as a parent class for specific roles such as staff and customer
 * Stores common attributes like name, age and person ID
 * 
 * This class is intended to be extended
 * @author Taryn Davis
 */
public abstract class Person {
    protected String name;
    protected int age;
    protected int personID;
    private ArrayList<Customer> customers;
    
    /**
     * Constructs a person object with name, age, and person ID
     * @param name the name of the person
     * @param age the age of the person
     * @param personID the unique identifier for the person
     */
    public Person(String name, int age, int personID) { // name, ID, age???
        this.name = name;
        this.age = age;
        this.personID = personID;
        this.customers = new ArrayList<>();
    }
    
    /**
     * Gets the persons name
     * @return The persons name
     */
    public String getName() { 
        return name; 
    }
    
    /**
     * Gets the persons Age
     * @return The persons Age
     */
    public int getAge() { 
        return age; 
    }
    
    /**
     * Gets the persons unique ID
     * @return Person ID
     */
    public int getPersonID() { 
        return personID; 
    }
    
    /**
     * Sets the persons name
     * @param name The name for the new person
     */
    public void setName(String name) { 
        this.name = name;
    }
    
    /**
     * Sets the new persons age
     * @param age The age for the new person
     */
    public void setAge(int age) { 
        this.age = age; 
    }

    void addCustomer(Customer aCustomer) { // INSERTED CODE
        customers.add(aCustomer);
    }

    Iterable<Customer> getCustomers() { //INSERTED CODE
        return customers;
        
    }

    Customer getACustomer(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

