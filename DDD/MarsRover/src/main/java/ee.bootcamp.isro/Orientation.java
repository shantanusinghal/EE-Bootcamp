package ee.bootcamp.isro;

public class Orientation implements Cloneable{

    private Position position;
    private Direction currentDirection;

    public Orientation(int xCoord, int yCoord, String direction) throws IllegalArgumentException {
        position = new Position(xCoord, yCoord);
        currentDirection = Direction.valueOf(direction);
    }

    public Orientation changeXYCoordinates() {
        position = position.add(currentDirection.getDelta());
        return this;
    }

    public Orientation rotate(RotateDirection rotateDirection) {
        currentDirection = currentDirection.turn(rotateDirection.getDirection());
        return this;
    }

    public boolean isWithin(int xBoundary, int yBoundary) {
        return position.isBoundedBy(xBoundary, yBoundary);
    }

    @Override
    public String toString() {
        return position.toString() + " " + currentDirection.toString();
    }
}
