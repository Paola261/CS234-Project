/**
 * Represents a cashier staff member in the movie theater system.
 * A cashier is responsible for processing ticket and concession sales
 * and works at a specific register
 * @author Taryn Davis
 */
public class Cashier extends Staff {
    private int registerID;

    /**
     * Constructs a cashier object
     * @param name name of the Cashier
     * @param age the age of the cashier
     * @param personID the personal ID of the cashier
     * @param staffID the unique staff ID
     * @param role the role assigned to the staff member
     * @param credential the credential object for login authentication
     * @param registerID the ID of the register assigned to the user
     */
    public Cashier(String name, int age, int personID, int staffID, String role,
                   Credential credential, int registerID) {
        super(name, age, personID, staffID, role, credential);
        this.registerID = registerID;
    }

    /**
     * Gets the register ID where the cashier is assigned
     * @return the register ID
     */
    public int getRegisterID() {
        return registerID;
    }

    /**
     * Simulates the processing a movie ticket sale.
     * Displays a message with the cashier's name and register ID
     */
    public void processTicketSale() {
        System.out.println(getName() + " is processing a ticket sale at register " + registerID + ".");
    }

    /**
     * Simulates processing a concession sale
     * Displays a message with the cashier's name and register ID
     */
    public void processConcessionSale() {
        System.out.println(getName() + " is processing a concession sale at register " + registerID + ".");
    }
}
