package ee.bootcamp.isro.builder;

import ee.bootcamp.isro.Plateau;
import ee.bootcamp.isro.Rover;

public class RoverBuilder {

    int xCoordinate;
    int yCoordinate;
    String direction;
    private Plateau plateau;

    public RoverBuilder at(String parameterString) {
        String[] parameters = parameterString.split(" ");
        xCoordinate = Integer.parseInt(parameters[0]);
        yCoordinate = Integer.parseInt(parameters[1]);
        direction = parameters[2];
        return this;
    }

    public RoverBuilder on(Plateau plateau) {
        this.plateau = plateau;
        return this;
    }

    public Rover build() {
        return new Rover (xCoordinate, yCoordinate, direction, plateau);
    }
}
