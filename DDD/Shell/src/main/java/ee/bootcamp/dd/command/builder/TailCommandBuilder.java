package ee.bootcamp.dd.command.builder;

import ee.bootcamp.dd.command.executor.Command;
import ee.bootcamp.dd.command.executor.TailCommand;
import ee.bootcamp.dd.operator.OperatorBuilder;
import ee.bootcamp.dd.operator.executor.Operator;
import ee.bootcamp.dd.option.DefineLineCountOption;

import java.util.List;
import java.util.Map;

public class TailCommandBuilder implements ICommandBuilder {

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
        TailCommand tailCommand = new TailCommand();

        addOptionsTo(tailCommand);
        addOperatorsTo(tailCommand);

        return tailCommand;
    }

    private void addOperatorsTo(TailCommand tailCommand) {
        //designed for one operator only!
        if(operators.size()>0) {
            String operatorName = operators.remove(0);
            List<String> operatorParameters = operators;
            Operator operator = new OperatorBuilder()
                                        .with(operatorName)
                                        .withParameters(operatorParameters)
                                        .build();

            tailCommand.addOperator(operator);
        }
    }

    private void addOptionsTo(TailCommand tailCommand) {
        if(options.keySet().contains("l")) {
            tailCommand = new TailCommand() {
                @Override
                public void setDefineLineCountOption(String value) {
                    super.setNUMBER_OF_LINES(Integer.parseInt(value));
                }
            };

//            tailCommand.setDefineLineCountOption(options.get("l"));
        }
        if(options.keySet().contains("n")) {
            tailCommand.setShowLineNumberOption(true);
        }
    }

}