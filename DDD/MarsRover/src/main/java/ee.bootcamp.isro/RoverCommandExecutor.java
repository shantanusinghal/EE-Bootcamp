package ee.bootcamp.isro;

import ee.bootcamp.isro.exception.BoundaryViolation;

public class RoverCommandExecutor {

    private final ee.bootcamp.isro.Rover rover;

    public RoverCommandExecutor(Rover rover) {
        this.rover = rover;
    }

    public String execute(String roverCommand) throws BoundaryViolation {
        for(Character commandString : roverCommand.toCharArray()) {
            Command command = Command.valueOf(String.valueOf(commandString));
            command.execute(rover);
        }
        return rover.getOrientation();
    }
}