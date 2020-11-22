package it.unibo.oop.lab04.robot.base;

public interface Robot {

    boolean moveUp();

    boolean moveDown();

    boolean moveLeft();

    boolean moveRight();

    void recharge();

    double getBatteryLevel();

    Position2D getPosition();

}
