/**
 *
 * @author melissaflores
 */
import java.util.List;

public class Screen {
    private int screenID;
    private String screenType;
    private int seatingCapacity;
    private List<Seat> seatLayout;
    private String projectorType;
    private String audioSystem;
    private boolean isAvailable;

    public Screen(int screenID, String screenType, int seatingCapacity, List<Seat> seatLayout, String projectorType, String audioSystem, boolean isAvailable) {
        this.screenID = screenID;
        this.screenType = screenType;
        this.seatLayout = seatLayout;
        this.projectorType = projectorType;
        this.audioSystem = audioSystem;
        this.isAvailable = isAvailable;
    }

    // Getters and setters for all fields
    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public List<Seat> getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(List<Seat> seatLayout) {
        this.seatLayout = seatLayout;
    }

    public String getProjectorType() {
        return projectorType;
    }

    public void setProjectorType(String projectorType) {
        this.projectorType = projectorType;
    }

    public String getAudioSystem() {
        return audioSystem;
    }

    public void setAudioSystem(String audioSystem) {
        this.audioSystem = audioSystem;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}