package ee.bootcamp.dd.command;

import ee.bootcamp.dd.command.builder.CopyCommandBuilder;
import ee.bootcamp.dd.command.builder.ICommandBuilder;
import ee.bootcamp.dd.command.builder.TailCommandBuilder;
import ee.bootcamp.dd.command.executor.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandBuilder {

    private Map<String, ICommandBuilder> allCommandsBuilders;
    private Map<String, String> options;
    private List<String> operators;
    private ICommandBuilder commandBuilder;

    public CommandBuilder() {
        populateCommandBuilderList();
    }

    public CommandBuilder with(String command) {
        this.commandBuilder = allCommandsBuilders.get(command);
        return this;
    }

    public CommandBuilder withOptions(List<String> options) {
        this.options = new HashMap<>();
        String optionName;
        String optionValue;
        for (String option : options) {
            optionName = option.split(" ")[0].replace("-","");
            if(option.split(" ").length==2) {
                optionValue = option.split(" ")[1];
            }
            else {
                optionValue = "";
            }
            this.options.put(optionName,optionValue);
        }
        return this;
    }

    public CommandBuilder withOperators(List<String> operators) {
        this.operators = operators;
        return this;
    }

    public Command build() {
        return commandBuilder
                .withOptions(options)
                .withOperators(operators)
                .build();
    }

    private void populateCommandBuilderList() {
        allCommandsBuilders = new HashMap<String, ICommandBuilder>();
        allCommandsBuilders.put("tail", new TailCommandBuilder());
        allCommandsBuilders.put("copy", new CopyCommandBuilder());
    }
}