/**
*Represents a screen in a movie theater
*@author Melissa Flores
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

    /**
     * Constructs a new Screen object
     * @param screenID The unique identifier for the screen.
     * @param screenType The type of screen.
     * @param seatingCapacity The seating capacity of the screen.
     * @param seatLayout The layout of seats in the screen.
     * @param projectorType The type of projector used.
     * @param audioSystem The audio system used.
     * @param isAvailable Whether the screen is available.
     */
    public Screen(int screenID, String screenType, int seatingCapacity, List<Seat> seatLayout, String projectorType, String audioSystem, boolean isAvailable) {
        this.screenID = screenID;
        this.screenType = screenType;
        this.seatLayout = seatLayout;
        this.projectorType = projectorType;
        this.audioSystem = audioSystem;
        this.isAvailable = isAvailable;
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
     * @return The screen type
     */
    public String getScreenType() {
        return screenType;
    }

    /**
     * @param screenType The screen type to set
     */
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    /**
     * @return The seating capacity
     */
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * @param seatingCapacity The seating capacity to set
     */
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * @return The list of seats in the layout
     */
    public List<Seat> getSeatLayout() {
        return seatLayout;
    }

    /**
     * @param seatLayout The list of seats to set as the layout
     */
    public void setSeatLayout(List<Seat> seatLayout) {
        this.seatLayout = seatLayout;
    }

    /**
     * @return The projector type
     */
    public String getProjectorType() {
        return projectorType;
    }

    /**
     * @param projectorType The projector type to set
     */
    public void setProjectorType(String projectorType) {
        this.projectorType = projectorType;
    }

    /**
     * @return The audio system
     */
    public String getAudioSystem() {
        return audioSystem;
    }

    /**
     * @param audioSystem The audio system to set
     */
    public void setAudioSystem(String audioSystem) {
        this.audioSystem = audioSystem;
    }

    /**
     * @return true if the resource is available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * @param available true if the resource is available, false otherwise
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}