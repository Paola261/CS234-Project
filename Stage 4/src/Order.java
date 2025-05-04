/**
 * Represents an order in the system, extending the Inventory class
 * It stores information about the order, including customer details, items, showtime, seat, and total amount
 * @author Melissa Flores
 */
import java.util.ArrayList;

public class Order extends Inventory {
    private int orderID;
    private int customerID;
    private ArrayList<Items> orderItems;
    private int showtimeID;
    private int seatID;
    private float total;

    /**
     * Constructs an Order object.
     * @param orderID The ID of the order
     * @param customerID The ID of the customer placing the order
     * @param items An ArrayList of Items in the order
     * @param showtimeID The ID of the showtime for the order
     * @param seatID The ID of the seat for the order
     * @param total The total amount of the order
     */
    public Order(int orderID, int customerID, ArrayList<Items> items, int showtimeID, int seatID, float total) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderItems = items;
        this.showtimeID = showtimeID;
        this.seatID = seatID;
        this.total = total;
    }

    /**
     * @return The order ID
     */    
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID The new order ID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return The customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID The new customer ID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return An ArrayList of Items
     */
    @Override
    public ArrayList<Items> getItems() {
        return items;
    }
    /**
     * @param items An ArrayList of Items to set
     */
    public void setItems(ArrayList<Items> items) {
        this.items = orderItems;
    }

    /**
     * @return The showtime ID
     */
    public int getShowtimeID() {
        return showtimeID;
    }

    /**
     * @param showtimeID The showtime ID to set
     */
    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }

    /**
     * @return The seat ID
     */
    public int getSeatID() {
        return seatID;
    }

    /**
     * @param seatID The seat ID to set
     */
    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    /**
     * @return The total amount
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total The total amount to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
}