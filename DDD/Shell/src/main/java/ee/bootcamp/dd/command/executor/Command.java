package ee.bootcamp.dd.command.executor;

import java.util.List;

public interface Command {

    public String execute(List<String> inputParameters);

}
