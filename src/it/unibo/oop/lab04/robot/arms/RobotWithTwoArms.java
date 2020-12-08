package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

    private static final double CONSUMPTION_FOR_ITEM_CARRIED = 0.2;

    private int itemsCarried;
    private final BasicArm arm1;
    private final BasicArm arm2;

    public RobotWithTwoArms(final String name) {
        super(name);
        this.itemsCarried = 0;
        this.arm1 = new BasicArm("sx");
        this.arm2 = new BasicArm("dx");
    }

    /**
     * @return call to superclass
     */
    protected double getBatteryRequirementForMovement() {
        return super.getBatteryRequirementForMovement() + (this.getCarriedItemsCount() * CONSUMPTION_FOR_ITEM_CARRIED);
    }

    /**
     * @return pick up status
     */
    @Override
    public boolean pickUp() {
        if (!this.arm1.isGrabbing()) {
            this.arm1.pickUp();
            super.consumeBattery(this.arm1.getConsuptionForPickUp());
            this.itemsCarried++;
        } else if (!this.arm2.isGrabbing()) {
            this.arm2.pickUp();
            super.consumeBattery(this.arm2.getConsuptionForPickUp());
            this.itemsCarried++;
        } else {
            return false;
        }
    return true;
    }

    /**
     * @return drop down status
     */
    @Override
    public boolean dropDown() {
        if (this.arm1.isGrabbing()) {
            this.arm1.dropDown();
            super.consumeBattery(this.arm1.getConsuptionForDropDown());
            this.itemsCarried--;
        } else if (this.arm2.isGrabbing()) {
            this.arm2.dropDown();
            super.consumeBattery(this.arm2.getConsuptionForDropDown());
            this.itemsCarried--;
        } else { 
            return false;
            }
    return true;
    }

    /**
     * @return items carried
     */
    @Override
    public int getCarriedItemsCount() {
        return this.itemsCarried;
    }
}
