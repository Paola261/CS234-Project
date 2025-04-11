/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paolapereda
 */
import java.util.List;

public class ReservationSystem {
    private List<Showtime> showtimes;
    
    public ReservationSystem(List<Showtime> showtimes){
        this.showtimes = showtimes;
    }
    public List<Seat> getAvailableSeats(int showtimeID)
    {
        for(Showtime showtime: showtimes){
            if(showtime.getShowtimeID() == showtimeID){
                return showtime.getAvailableSeats();
            }
        }
        return new ArrayList<>();

    }

    public boolean reserveSeat(int seatID)
    {
        for(Showtime: showtime: showtimes){
            Seat seat = showtime.findSeatbyID(seatID);
            if(seat != null && seat.isAvailable()){
                seat.reserve();
                return true;
            }
        }
    }
        

    public boolean releaseSeat(int seatID){
    
        for(Showtime: showtime : showtimes) {
            Seat seat = showtime.findSeatByID(seatID);
            if(seat != null && !seat.isAvailable()){
                seat.release();
                return true;
            }
        }
        return false;
        
    }
    
    
}
