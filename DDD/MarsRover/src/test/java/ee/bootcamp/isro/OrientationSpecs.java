package ee.bootcamp.isro;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrientationSpecs {

    @Test
    public void itShouldOnlyChangeDirectionOnTurning() {
        //Given
        Orientation orientation = new Orientation(0, 0, "N");
        //When
        Orientation orientationOnTurningLeftAndRight = orientation.rotate(RotateDirection.L).rotate(RotateDirection.R);
        //Then
        assertThat(orientationOnTurningLeftAndRight.toString(), is("0 0 N"));
    }

    @Test
    public void itShouldOnlyChangeAlongYAxisOnMovingNorthOrSouth() {
        //Given
        Orientation orientationFacingNorth = new Orientation(0, 0, "N");
        Orientation orientationFacingSouth = new Orientation(0, 0, "S");
        //When
        Orientation orientationOnMovingNorth = orientationFacingNorth.changeXYCoordinates();
        Orientation orientationOnMovingSouth = orientationFacingSouth.changeXYCoordinates();
        //Then
        assertThat(orientationOnMovingNorth.toString(), is("0 1 N"));
        assertThat(orientationOnMovingSouth.toString(), is("0 -1 S"));
    }

    @Test
    public void itShouldOnlyChangeAlongXAxisOnMovingEastOrWest() {
        //Given
        Orientation orientationFacingEast = new Orientation(0, 0, "E");
        Orientation orientationFacingWest = new Orientation(0, 0, "W");
        //When
        Orientation orientationOnMovingEast = orientationFacingEast.changeXYCoordinates();
        Orientation orientationOnMovingWest = orientationFacingWest.changeXYCoordinates();
        //Then
        assertThat(orientationOnMovingEast.toString(), is("1 0 E"));
        assertThat(orientationOnMovingWest.toString(), is("-1 0 W"));
    }
}