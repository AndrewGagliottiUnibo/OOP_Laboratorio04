package it.unibo.oop.lab04.robot.base;

public interface Position2D {

    int getX();

    int getY();

    /**
     * @param p
     *            delta movement to sum
     * @return the new position
     */
    Position2D sumVector(Position2D p);

    /**
     * @param x
     *            X delta
     * @param y
     *            Y delta
     * @return the new position
     */
    Position2D sumVector(int x, int y);

}
