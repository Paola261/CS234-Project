/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The TicketSeller class manages the selling of movie tickets to customers
 * @author paolapereda
 */
import java.util.List;
import java.util.ArrayList;

public class TicketSeller {

    private List<Showtime> showtimes;
    private List<Customer> customers;

    /**
     * Constructor that initilizes the list of Showtimes and Customers
     * @param showtimes ~ the available showtimes 
     * @param customers ~ the list of customers 
     */
    public TicketSeller(List<Showtime> showtimes, List<Customer> customers)
    {
        this.showtimes = showtimes;
        this.customers = customers;
    }
    
    /**
     * Method to retrieve the available showtimes if it matches the movieID
     * @param movieID ~ the ID for the movie
     * @return a list of available showtimes 
     */
    public List<Showtime> getAvailableShowTime(int movieID)
    {
        List<Showtime> availableShowtimes = new ArrayList<>();
        for(Showtime showtime: showtimes){
            if(showtime.getMovie().getMovieID() == movieID){
                availableShowtimes.add(showtime);
            }
        }
        return availableShowtimes;
    }

    /**
     * Method to retrieve the available sets if it matches a showtimeID
     * @param showtimeID ~ ID for the showtime 
     * @return a list for the available seats 
     */
    public List<Seat> getAvailableSeats(int showtimeID)
    {
        for(Showtime showtime: showtimes){
            if(showtime.getShowID() == showtimeID){
                return showtime.getAvailableSeats();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Method to sell a ticket according to the customerID, showtimeID, seatID
     * @param customerID ~ the customer that will purchase the ticket
     * @param showtimeID ~ the ID for the showtime
     * @param seatID ~ the ID for the seat to be reserved
     * @return 
     */
    public boolean sellTicket(int customerID, int showtimeID, int seatID)
    {
        Customer customer = findCustomerByID(customerID);
        Showtime showtime = findShowtimeByID(showtimeID);
        
        if(customer != null && showtime != null){
            Seat seat = showtime.findSeatID(seatID);
            if(seat != null && seat.isAvailable()){
                seat.reserve();
                Ticket ticket = new Ticket(customer, showtime, seat);
                customer.addTicket(ticket);
                return true;
            }
        }
        return false;
    }
    
    /**
     * A private method that helps the class find a customer with their ID
     * @param customerID
     * @return ~ if the Customer is the system or not
     */
    private Customer findCustomerByID(int customerID){
        for(Customer customer: customers){
            if(customer.getCustomerID() == customerID){
                return customer;
            }
        }
        return null;
    }
    
    /**
     * A private helper method that finds a showtime by its showtime ID
     * @param showtimeID
     * @return ~ if the showtime is found or not
     */
    private Showtime findShowtimeByID(int showtimeID){
        for(Showtime showtime: showtimes){
            if(showtime.getShowtimeID() == showtimeID){
                return showtime;
            }
        }
        return null;
    }
}
