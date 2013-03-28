package ee.bootcamp.isro;

import ee.bootcamp.isro.exception.BoundaryViolation;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MissionControlSpecs {

    @Test
    public void itShouldInitializeAndInstructsTwoRovers() throws BoundaryViolation {
        //Given
        MissionControl missionControl = MissionControl.makeNew();
        //When
        String roverControllerResponse = missionControl.execute("5 5\n1 2 N\nMMR\n0 1 E\nLMM");
        //Then
        assertThat(roverControllerResponse, is("1 4 E\n0 3 N"));
    }

    @Test
    public void itShouldEnforceBoundaryValues() throws BoundaryViolation {
        //Given
        MissionControl missionControl = MissionControl.makeNew();
        //When
        try {
            String roverControllerResponse = missionControl.execute("3 3\n1 2 N\nMMR\n0 1 E\nLMM");
        }
        //Then
        catch (BoundaryViolation e) {
            assertEquals(e.getMessage(), "Rover at 1 3 N is going to breach the boundary");
        }
    }
}
