/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The ReservationSystem class manages the seat reservation for the showtimes
 * @author paolapereda
 */
import java.util.List;
import java.util.ArrayList;

public class ReservationSystem {
    private List<Showtime> showtimes;
    
    /**
     * Constructor for the ReservationSystem with a list of showtimes
     * @param showtimes 
     */
    public ReservationSystem(List<Showtime> showtimes){
        this.showtimes = showtimes;
    }
    
    /**
     * Returns a list of the available seats in regards of the showtimeID
     * @param showtimeID
     * @return 
     */
    public List<Seat> getAvailableSeats(int showtimeID)
    {
        for(Showtime showtime: showtimes){
            if(showtime.getSID() == showtimeID){
                return showtime.getAvailableSeats();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Reserves a seat with a seatID
     * @param seatID
     * @return 
     */
    /*public boolean reserveSeat(int seatID)
    {
        for(Showtime showtime: showtimes){
            Seat seat = showtime.findSeatbyID(seatID);
            if(seat != null && seat.isAvailable()){
                seat.reserve();
                return true;
            }
        }
        return false;
    }*/
    
    /**
     * Releases a seat with a seatID
     * @param seatID
     * @return 
     */
    /*public boolean releaseSeat(int seatID){
        for(Showtime showtime : showtimes) {
            Seat seat = showtime.findSeatbyID(seatID);
            if(seat != null && !seat.isAvailable()){
                seat.release();
                return true;
            }
        }
        return false;
        
    }*/
    
    
}
