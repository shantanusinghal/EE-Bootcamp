package ee.bootcamp.dd;

import java.util.List;

public class Input {

    private String command;
    private List<String> options;
    private List<String> parameters;
    private List<String> operators;

    public Input(String command, List<String> options, List<String> parameters, List<String> operators) {
        this.command = command;
        this.options = options;
        this.parameters = parameters;
        this.operators = operators;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getOptions() {
        return options;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public List<String> getOperators() {
        return operators;
    }
}