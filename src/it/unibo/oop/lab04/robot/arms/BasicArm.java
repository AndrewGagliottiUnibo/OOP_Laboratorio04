package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
    
    private static final double LIFT_ENERGY = 0.5;
    private static final double DROP_ENERGY = 0.5;
    private static final double MOVE_ENERGY = 0.1;
    
    private final String name;
    private boolean status;
    
    //costruttore
    public BasicArm (final String name){
        this.name = name;
    }
    
    //getters
    public String getName() {
        return this.name;
    }
    
    public boolean isGrabbing() {
        return this.status;
    }
    
    //setter
    public void setGrabbing(final boolean status) {
        this.status = status;
    }
    
    //implementati
    public void pickUp(){
        if(!this.isGrabbing()) {
            this.setGrabbing(true);
        }
    }
    
    public void dropDown(){
        if(this.isGrabbing()) {
            this.setGrabbing(false);
        }
    }
    
    public double getConsuptionForPickUp(){
        return LIFT_ENERGY + MOVE_ENERGY;     
    }
    
    public double getConsuptionForDropDown(){
        return + MOVE_ENERGY + DROP_ENERGY;     
    }
    
    //toString
    public String toString() {
        return "Arm: " + this.getName() +
               "Grabbing status: " + this.isGrabbing();
    }
}
