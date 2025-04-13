/**
 *
 * @author melissaflores
 */
public class Seat {
    private int seatID;
    private int screenID;
    private char row;
    private byte number;
    private boolean isAvailable;

    public Seat(int seatID, int screenID, char row, byte number, boolean isAvailable) {
        this.seatID = seatID;
        this.screenID = screenID;
        this.row = row;
        this.number = number;
        this.isAvailable = isAvailable;
    }
  
    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}