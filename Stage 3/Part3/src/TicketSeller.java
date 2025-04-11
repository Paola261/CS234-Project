/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
import java.util.List;
import java.util.ArrayList;

public class TicketSeller {

    private List<Showtime> showtimes;
    private List<Customer> customers;

    
    public TicketSeller(List<Showtime> showtimes, List<Customer> customers)
    {
        this.showtimes = showtimes;
        this.customers = customers;
    }
    
    public List<Showtime> getAvailabeShowTime(int movieID)
    {
        List<Showtime> availableShowtimes = new ArrayList<>();
        for(Showtime showtime: showtimes){
            if(showtime.getMovie().getMovieID() == movieID){
                availableShowtime.add(showtime);
            }
        }
        return availableShowtimes;

    }

    public List<Seat> getAvailableSeats(int showtimeID)
    {
        for(Showtime showtime: showtimes){
            if(showtime.getShowID() == showtimeID){
                return showtime.getAvailableSeats();
            }
        }
        return new ArrayList<>();

    }

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
    
    private Customer findCustomerByID(int customerID){
        for(Customer customer: customers){
            if(customer.getCustomerID() == customerID){
                return customer;
            }
        }
        return null;
    }
    
    private Showtime findShowtimeByID(int showtimeID){
        for(Showtime showtime: showtimes){
            if(showtime.getShowtimeID() == showtimeID){
                return showtime;
            }
        }
        return null;
    }
    
    
}
