/**
 *
 * @author melissaflores
 */
public class Order extends Inventory {
    private int orderID;
    private int customerID;
    private List<Inventory> items;
    private int showtimeID;
    private int seatID;
    private float total;

    public Order(int orderID, int customerID, List<Inventory> items, int showtimeID, int seatID, float total) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.items = items;
        this.showtimeID = showtimeID;
        this.seatID = seatID;
        this.total = total;
    }

    // Getters and setters for all fields
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<Inventory> getItems() {
        return items;
    }

    public void setItems(List<Inventory> items) {
        this.items = items;
    }

    public int getShowtimeID() {
        return showtimeID;
    }

    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}