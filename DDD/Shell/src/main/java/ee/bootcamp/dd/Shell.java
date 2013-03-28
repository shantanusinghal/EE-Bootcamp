package ee.bootcamp.dd;

import ee.bootcamp.dd.command.executor.Command;
import ee.bootcamp.dd.command.CommandBuilder;
import ee.bootcamp.dd.util.Parser;

public class Shell {

    public String execute(String userInput) {

        Input input = new Parser().parse(userInput);

        Command command = new CommandBuilder()
                                .with(input.getCommand())
                                .withOptions(input.getOptions())
                                .withOperators(input.getOperators())
                                .build();

        return command.execute(input.getParameters());
    }
}
