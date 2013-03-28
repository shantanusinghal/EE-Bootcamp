package ee.bootcamp.isro;

public enum Direction {
    N {
        @Override
        public Position getDelta() {
            return new Position(0, 1);
        }
    },
    E {
        @Override
        public Position getDelta() {
            return new Position(1, 0);
        }
    },
    S {
        @Override
        public Position getDelta() {
            return new Position(0, -1);
        }

    },
    W {
        @Override
        public Position getDelta() {
            return new Position(-1, 0);
        }

    };

    public abstract Position getDelta();

    public Direction turn(int step) {
        int indexOfResultantDirection = (this.ordinal() + step + 4) % 4;
        return Direction.values()[indexOfResultantDirection];
    }
}