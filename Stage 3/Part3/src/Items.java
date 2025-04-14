/**
 * The interface represents a contract for items that can be managed
 * It provides methods to retrieve item information and sell items
 * @author melissaflores
 */
    public interface Items {
        String getName();
        int getQuantity();
        double getPrice();
        void sell(int quantity);
}