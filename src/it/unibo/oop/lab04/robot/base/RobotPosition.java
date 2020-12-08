package it.unibo.oop.lab04.robot.base;

/**
 * Models a (x,y) position for a {@link it.unibo.oop.lab04.robot.base.Robot}.
 *
 */
public class RobotPosition implements Position2D {

    private final int x;
    private final int y;

    /**
     * @param x
     *            X position
     * @param y
     *            Y position
     */
    public RobotPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param object
     * @return true if the objects are equals
     */
    public boolean equals(final Object object) {
        if (object instanceof Position2D) {
            final var p = (Position2D) object;
            return x == p.getX() && y == p.getY();
        }
        return false;
    }

    /**
     * @return x
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * @return y
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * @return hash code
     */
    public int hashCode() {
        /*
         * This could be implemented WAY better.
         */
        return x ^ y;
    }

    /**
     * @param x
     * @param y
     * @return position
     */
    @Override
    public RobotPosition sumVector(final int x, final int y) {
        return new RobotPosition(this.x + x, this.y + y);
    }

    /**
     * @param p
     * @return position
     */
    @Override
    public RobotPosition sumVector(final Position2D p) {
        return new RobotPosition(x + p.getX(), y + p.getY());
    }

    /**
     * @return all data.
     */
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
