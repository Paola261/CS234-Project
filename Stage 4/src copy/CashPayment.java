/**
 * Implements the PaymentStrategy interface to provide cash payment functionality
 * @author Melissa Flores
 */

public class CashPayment implements PaymentStrategy {
    /**
     * @param amount The amount to be paid in cash
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " in cash.");
    }
}