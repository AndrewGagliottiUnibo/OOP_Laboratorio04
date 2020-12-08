package it.unibo.oop.lab04.robot.arms;

public class BasicArm {

    private static final double LIFT_ENERGY = 0.5;
    private static final double DROP_ENERGY = 0.5;
    private static final double MOVE_ENERGY = 0.1;

    private final String name;
    private boolean status;

    public BasicArm(final String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return grabbing status
     */
    public boolean isGrabbing() {
        return this.status;
    }

    /**
     * @param status
     */
    public void setGrabbing(final boolean status) {
        this.status = status;
    }
 
    /**
     * 
     */
    public void pickUp() {
        if (!this.isGrabbing()) {
            this.setGrabbing(true);
        }
    }

    /**
     * 
     */
    public void dropDown() {
        if (this.isGrabbing()) {
            this.setGrabbing(false);
        }
    }

    /**
     * @return consumption for pick up
     */
    public double getConsuptionForPickUp() {
        return LIFT_ENERGY + MOVE_ENERGY;
    }

    /**
     * @return consumption for drop down
     */
    public double getConsuptionForDropDown() {
        return MOVE_ENERGY + DROP_ENERGY;
    }

    /**
     * @return all data
     */
   public String toString() {
        return "Arm: " + this.getName() 
                + "Grabbing status: " + this.isGrabbing();
    }
}
