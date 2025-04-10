/**
 *
 * @author Taryn Davis
 */
public class Manager extends Staff {
    public Manager(String name, int age, int personID, int staffID, String role, Credential credential) {
        super(name, age, personID, staffID, role, credential);
    }

    @Override
    public void startShift() {
        System.out.println(getName() + " (Manager) is starting their shift.");
    }

    @Override
    public void endShift() {
        System.out.println(getName() + " (Manager) is ending their shift.");
    }

    public void overseeOperations() {
        System.out.println(getName() + " is overseeing daily operations.");
    }
}
