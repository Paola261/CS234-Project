/**
 * This class represents a seat in a theater or venue
 * @author melissaflores
 */

public class Seat {
    private int seatID;
    private int screenID;
    private char row;
    private byte number;
    private boolean isAvailable;
    private boolean available;

     /**
     * Constructor method
     *
     * @param seatID The unique identifier for the seat.
     * @param screenID The identifier for the screen or area where the seat is located.
     * @param row The row of the seat.
     * @param number The number of the seat within the row.
     * @param isAvailable True if the seat is available, false otherwise.
     */
    public Seat(int seatID, int screenID, char row, byte number, boolean isAvailable) {
        this.seatID = seatID;
        this.screenID = screenID;
        this.row = row;
        this.number = number;
        this.isAvailable = isAvailable;
    }
  
    /**
     * @return The seat ID
     */
    public int getSeatID() {
        return seatID;
    }

    /**
     * @param seatID The new seat ID
     */
    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    /**
     * @return The screen ID
     */
    public int getScreenID() {
        return screenID;
    }

    /**
     * @param screenID The new screen ID
     */
    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    /**
     * @return The row of the seat
     */
    public char getRow() {
        return row;
    }

    /**
     * @param row The new row of the seat
     */
    public void setRow(char row) {
        this.row = row;
    }

    /**
     * @return the number
     */
    public byte getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(byte number) {
        this.number = number;
    }

    /**
     * @return true if the object is available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * @param available true if the object is available, false otherwise
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     *Reserves the object if it is available.
     */    
    public void reserve() {
        if (available) {
            available = false;
        }
    }
  
    /**
     *Releases the object if it is not available.
     */
    public void release() {
        if (!available) {
            available = true;
        }
    }
}