package ee.bootcamp.dd.command.builder;

import ee.bootcamp.dd.command.executor.Command;

import java.util.List;
import java.util.Map;

public interface ICommandBuilder {

    public ICommandBuilder withOptions(Map<String, String> options);

    public ICommandBuilder withOperators(List<String> operators);

    public Command build();
}
