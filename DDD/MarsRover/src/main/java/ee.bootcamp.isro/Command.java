package ee.bootcamp.isro;

import ee.bootcamp.isro.exception.BoundaryViolation;

public enum Command {
    M {
        @Override
        public void execute(Rover rover) throws BoundaryViolation {
            rover.move();
        }
    },
    L {
        @Override
        public void execute(Rover rover) {
            rover.turnLeft();
        }
    },
    R {
        @Override
        public void execute(Rover rover) {
            rover.turnRight();
        }
    };

    public abstract void execute(Rover rover) throws BoundaryViolation;

}
