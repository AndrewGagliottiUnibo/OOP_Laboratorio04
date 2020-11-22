package it.unibo.oop.lab04.robot.base;

public class BaseRobot implements Robot {

    public static final double BATTERY_FULL = 100;
    public static final double MOVEMENT_DELTA_CONSUMPTION = 1.2;
    private static final int MOVEMENT_DELTA = 1;

    private double batteryLevel;
    private final RobotEnvironment environment;
    private final String robotName;

    //costruttore
    public BaseRobot(final String robotName) {
        this.environment = new RobotEnvironment(new RobotPosition(0, 0));
        this.robotName = robotName;
        this.batteryLevel = BATTERY_FULL;
    }

    //gestisce consumo batteria
    protected void consumeBattery(final double amount) {
        if (batteryLevel >= amount) {
            this.batteryLevel -= amount;
        } else {
            this.batteryLevel = 0;
        }
    }

    //consumo energia per movimento nell'ambiente
    private void consumeBatteryForMovement() {
        consumeBattery(getBatteryRequirementForMovement());
    }

    protected double getBatteryRequirementForMovement() {
        return MOVEMENT_DELTA_CONSUMPTION;
    }

    public double getBatteryLevel() {
        return Math.round(batteryLevel * 100d) / BATTERY_FULL;
    }

    public Position2D getPosition() {
        return environment.getPosition();
    }

    protected boolean isBatteryEnough(final double operationCost) {
        return batteryLevel > operationCost;
    }

    /**
     * Log in stdout the {@link String} provided in input
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

   public boolean moveDown() {
        return move(0, -MOVEMENT_DELTA);
    }

    public boolean moveLeft() {
        return move(-MOVEMENT_DELTA, 0);
    }

    public boolean moveRight() {
        return move(MOVEMENT_DELTA, 0);
    }

    public boolean moveUp() {
        return move(0, MOVEMENT_DELTA);
    }

    public void recharge() {
        this.batteryLevel = BATTERY_FULL;
    }

    public String toString() {
        return robotName;
    }
}
