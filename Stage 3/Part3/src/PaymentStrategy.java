/**
*Defines the PaymentStrategy interface for different payment methods
*@author Melissa Flores
*/
interface PaymentStrategy {
    /**
     * @param amount the amount to be paid
     */
    void pay(double amount);
}
