/**
 *
 * @author Taryn Davis
 */
public class Cashier extends Staff {
    private int registerID;

    public Cashier(String name, int age, int personID, int staffID, String role,
                   Credential credential, int registerID) {
        super(name, age, personID, staffID, role, credential);
        this.registerID = registerID;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void processTicketSale() {
        System.out.println(getName() + " is processing a ticket sale at register " + registerID + ".");
    }

    public void processConcessionSale() {
        System.out.println(getName() + " is processing a concession sale at register " + registerID + ".");
    }
}
