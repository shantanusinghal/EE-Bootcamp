package ee.bootcamp.isro.builder;

import ee.bootcamp.isro.Plateau;

public class PlateauBuilder {

    int xBoundary;
    int yBoundary;

    public PlateauBuilder using(String gridSizeString) {
        xBoundary = Integer.parseInt(gridSizeString.split(" ")[0]);
        yBoundary = Integer.parseInt(gridSizeString.split(" ")[1]);
        return this;
    }

    public Plateau build() {
        return new Plateau(xBoundary, yBoundary);
    }

}
