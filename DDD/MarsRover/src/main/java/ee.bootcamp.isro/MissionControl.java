package ee.bootcamp.isro;

import ee.bootcamp.isro.builder.PlateauBuilder;
import ee.bootcamp.isro.builder.RoverBuilder;
import ee.bootcamp.isro.exception.BoundaryViolation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissionControl {

    Plateau plateau;

    public static MissionControl makeNew() {
        return new MissionControl();
    }

    public String execute(String commandSequenceString) throws BoundaryViolation {
        StringBuilder controllerResponse = new StringBuilder();
        ArrayList<String> commandSequence = getCommandList(commandSequenceString);

        plateau = new PlateauBuilder()
                            .using(getGridSizeFrom(commandSequence))
                            .build();

        while(!commandSequence.isEmpty()){

            Rover rover = new RoverBuilder()
                                .at(getPositionFrom(commandSequence))
                                .on(plateau)
                                .build();

            String roverResponse =  new RoverCommandExecutor(rover).execute(getCommandFrom(commandSequence));

            controllerResponse.append("\n" + roverResponse);
        }

        return format(controllerResponse);
    }

    private String getGridSizeFrom(ArrayList<String> commandSequence) {
        return commandSequence.remove(0);
    }

    private String getCommandFrom(ArrayList<String> commandSequence) {
        return commandSequence.remove(0);
    }

    private String getPositionFrom(ArrayList<String> commandSequence) {
        return commandSequence.remove(0);
    }

    private ArrayList<String> getCommandList(String commandSequenceString) {
        List<String> commandsList = Arrays.asList(commandSequenceString.split("\n"));
        ArrayList<String> commandsArrayList = new ArrayList<String>();
        commandsArrayList.addAll(commandsList);
        return commandsArrayList;
    }

    private String format(StringBuilder controllerResponse) {
        return controllerResponse.toString().replaceFirst("\n", "");
    }


}
