/**
 * Represents a shopping cart that handles payments using a payment strategy
 * @author Melissa Flores
 */
public class Cart {
    private PaymentStrategy paymentStrategy;

    /**
     * @param paymentStrategy The payment strategy to be used for checkout
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * @param amount The amount to be paid
     */
    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}