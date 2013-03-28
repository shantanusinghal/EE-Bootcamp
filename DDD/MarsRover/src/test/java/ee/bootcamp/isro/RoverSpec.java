package ee.bootcamp.isro;

import ee.bootcamp.isro.builder.RoverBuilder;
import ee.bootcamp.isro.exception.BoundaryViolation;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RoverSpec {
    
    @Test
    public void itShouldLandAtPosition() {
        //When
        Rover rover = new RoverBuilder().at("0 0 N").build();
        //Then
        String actualRoverPosition = rover.getOrientation();
        assertThat(actualRoverPosition, is("0 0 N"));
    }

    @Test
    public void itShouldMoveOneStepForward() throws BoundaryViolation {
        //Given
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new RoverBuilder().at("0 0 N").on(plateau).build();
        //When
        String actualRoverPosition = rover.move().getOrientation();
        //Then
        assertEquals(actualRoverPosition, "0 1 N");
    }

    @Test
    public void itShouldTurnLeftOrRight() {
        //Given
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new RoverBuilder().at("0 0 N").on(plateau).build();
        //When
        String actualRoverPosition = rover.turnLeft().turnRight().getOrientation();
        //Then
        assertEquals(actualRoverPosition, "0 0 N");
    }
}
