package ee.bootcamp.dd.command.builder;

import ee.bootcamp.dd.command.executor.Command;
import ee.bootcamp.dd.command.executor.CopyCommand;

import java.util.List;
import java.util.Map;

public class CopyCommandBuilder implements ICommandBuilder {

    private Map<String, String> options;
    private List<String> operators;

    @Override
    public ICommandBuilder withOptions(Map<String, String> options) {
        this.options = options;
        return this;
    }

    @Override
    public ICommandBuilder withOperators(List<String> operators) {
        this.operators = operators;
        return this;
    }

    @Override
    public Command build() {
        CopyCommand copyCommand = new CopyCommand();

        addOptionsTo(copyCommand);
        addOperatorsTo(copyCommand);

        return copyCommand;
    }

    private void addOperatorsTo(CopyCommand copyCommand) {
    }

    private void addOptionsTo(CopyCommand copyCommand) {
    }

}