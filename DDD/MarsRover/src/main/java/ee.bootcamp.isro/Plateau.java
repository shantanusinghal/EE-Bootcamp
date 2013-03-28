package ee.bootcamp.isro;

import ee.bootcamp.isro.exception.BoundaryViolation;

public class Plateau {

    private final int xBoundary;
    private final int yBoundary;

    public Plateau(int xBoundary, int yBoundary) {
        this.xBoundary = xBoundary;
        this.yBoundary = yBoundary;
    }

    public boolean isThisAValid(ee.bootcamp.isro.Orientation orientation) throws BoundaryViolation {
        if(boundaryIsViolationBy(orientation))
            throw new BoundaryViolation("Rover at " + orientation.toString() + " is going to breach the boundary");
        return true;
    }

    private boolean boundaryIsViolationBy(ee.bootcamp.isro.Orientation orientation) {
        return !orientation.isWithin(xBoundary, yBoundary);
    }

}
