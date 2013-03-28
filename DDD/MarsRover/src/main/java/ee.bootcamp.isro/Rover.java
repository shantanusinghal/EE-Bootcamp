package ee.bootcamp.isro;

import ee.bootcamp.isro.exception.BoundaryViolation;

public class Rover {

    private Orientation orientation;
    private Plateau plateau;

    public Rover(int x, int y, String direction, Plateau plateau) {
        this.orientation = new Orientation(x, y, direction);
        this.plateau = plateau;
    }

    public Rover move() throws BoundaryViolation {
        checkForBoundaryViolations();
        orientation.changeXYCoordinates();
        return this;
    }

    public Rover turnLeft() {
        orientation.rotate(RotateDirection.L);
        return this;
    }

    public Rover turnRight() {
        orientation.rotate(RotateDirection.R);
        return this;
    }

    public String getOrientation() {
        return orientation.toString();
    }

    private void checkForBoundaryViolations() throws BoundaryViolation {
        plateau.isThisAValid(orientation);
    }
}