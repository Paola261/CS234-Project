/**
 * Represents a shopping cart that handles payments using a payment strategy
 * @author Melissa Flores
 */
public class Cart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}