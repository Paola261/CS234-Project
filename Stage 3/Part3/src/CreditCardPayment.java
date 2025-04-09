/**
 *
 * @author melissaflores
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String thruDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String name, String thruDate, String cvv) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.thruDate = thruDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using a credit/debit card.");
    }
}