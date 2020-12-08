package it.unibo.oop.lab04.robot.base;

public class BaseRobot implements Robot {

    /**
     * 
     */
    public static final double BATTERY_FULL = 100;
    /**
     * 
     */
    public static final double MOVEMENT_DELTA_CONSUMPTION = 1.2;
    /**
     * 
     */
    private static final int MOVEMENT_DELTA = 1;

    private double batteryLevel;
    private final RobotEnvironment environment;
    private final String robotName;

    public BaseRobot(final String robotName) {
        this.environment = new RobotEnvironment(new RobotPosition(0, 0));
        this.robotName = robotName;
        this.batteryLevel = BATTERY_FULL;
    }

    /**
     * @param amount
     */
        public void consumeBattery(final double amount) {
        if (batteryLevel >= amount) {
            this.batteryLevel -= amount;
        } else {
            this.batteryLevel = 0;
        }
    }

    private void consumeBatteryForMovement() {
        consumeBattery(getBatteryRequirementForMovement());
    }

    /**
     * @return consumption
     */
    protected double getBatteryRequirementForMovement() {
        return MOVEMENT_DELTA_CONSUMPTION;
    }

    /**
     * @return battery level
     */
    @Override
    public double getBatteryLevel() {
        return Math.round(batteryLevel * 100d) / BATTERY_FULL;
    }

    /**
     * @return position
     */
    @Override
    public Position2D getPosition() {
        return environment.getPosition();
    }

    /**
     * @param operationCost
     * @return true if battery is enough to do operations
     */
    protected boolean isBatteryEnough(final double operationCost) {
        return batteryLevel > operationCost;
    }

    /**
     * Log in stdout the {@link String} provided in input.
     * 
     * @param msg
     */
    protected void log(final String msg) {
        System.out.println("[" + this.robotName + "]: " + msg);
    }

    private boolean move(final int dx, final int dy) {
        if (isBatteryEnough(getBatteryRequirementForMovement())) {
            if (environment.move(dx, dy)) {
                consumeBatteryForMovement();
                log("Moved to position " + environment.getPosition() + ". Battery: " + getBatteryLevel() + "%.");
                return true;
            }
            log("Can not move of (" + dx + "," + dy
                    + ") the robot is touching the world boundary: current position is " + environment.getPosition());
        } else {
            log("Can not move, not enough battery. Required: " + getBatteryRequirementForMovement()
                + ", available: " + batteryLevel + " (" + getBatteryLevel() + "%)");
        }
        return false;
    }

    /**
     * @return true if movement is ok
     */
    @Override
    public boolean moveDown() {
        return move(0, -MOVEMENT_DELTA);
    }

   /**
    * @return true if movement is ok
    */
    @Override
    public boolean moveLeft() {
        return move(-MOVEMENT_DELTA, 0);
    }

    /**
     * @return true if movement is ok
     */
    @Override
    public boolean moveRight() {
        return move(MOVEMENT_DELTA, 0);
    }

    /**
     * @return true if movement is ok
     */
    @Override
    public boolean moveUp() {
        return move(0, MOVEMENT_DELTA);
    }

    /**
     * 
     */
    public void recharge() {
        this.batteryLevel = BATTERY_FULL;
    }

    /**
     * @return all data
     */
    @Override
    public String toString() {
        return robotName;
    }
}
