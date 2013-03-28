package ee.bootcamp.isro;

public enum RotateDirection {
    L(-1),
    R(1);

    private final int direction;

    RotateDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}