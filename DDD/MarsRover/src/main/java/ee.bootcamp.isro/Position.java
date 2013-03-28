package ee.bootcamp.isro;

public class Position {

    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Position add(Position delta) {
        xCoordinate += delta.getXCoordinate();
        yCoordinate += delta.getYCoordinate();
        return this;
    }

    public boolean isBoundedBy(int xBoundary, int yBoundary) {
        return xCoordinate<xBoundary && yCoordinate<yBoundary;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return String.valueOf(xCoordinate) + " " + String.valueOf(yCoordinate);
    }
}
