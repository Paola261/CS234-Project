/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Class to represent a customer's purchase of a ticket 
 * @author paolapereda
 */
public class TicketOrder {
    private Customer customer;
    private Showtime showtime;
    private Seat seat;

    /**
     * Constructs a ticket order for a specified customer
     * @param customer
     * @param showtime
     * @param seat 
     */
    public TicketOrder(Customer customer, Showtime showtime, Seat seat)
    {
        this.customer = customer;
        this.showtime = showtime;
        this.seat = seat;

    }
}
