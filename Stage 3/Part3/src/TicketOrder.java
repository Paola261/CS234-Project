/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
public class TicketOrder extends Inventory {
    private Movie movie;
    private int numberOfTickets;
    private Showtime showtime;

    public TicketOrder(Movie movie, Showtime showtime, int numberOfTickets)
    {
        this.movie = movie;
        this.showtime = showtime;
        this.numberOfTickets = numberOfTickets;

    }

    public int getTicketQuantity()
    {
        return numberOfTickets;

    }
    
    public String getTicketOrder(){ // for Order Class
        
    }
    
    public void addItem(Order item)
    {
        items.add(item);
    }
}
