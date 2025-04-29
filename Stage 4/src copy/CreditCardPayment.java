/**
 * The class implements the {@code PaymentStrategy} interface
 * and provides functionality for processing credit card payments
 * @author Melissa Flores
 */

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String thruDate;
    private String cvv;

    /**
     * @param cardNumber The credit card number
     * @param name The name of the cardholder
     * @param thruDate The expiration date of the credit card
     * @param cvv The CVV code of the credit card
     */
    public CreditCardPayment(String cardNumber, String name, String thruDate, String cvv) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.thruDate = thruDate;
        this.cvv = cvv;
    }

    /**
     * @param amount The amount to be paid
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using a credit/debit card.");
    }
}