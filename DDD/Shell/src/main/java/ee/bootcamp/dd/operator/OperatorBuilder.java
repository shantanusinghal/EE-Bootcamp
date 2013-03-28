package ee.bootcamp.dd.operator;

import ee.bootcamp.dd.operator.builder.IOperatorBuilder;
import ee.bootcamp.dd.operator.builder.RedirectionOperatorBuilder;
import ee.bootcamp.dd.operator.executor.Operator;

import java.util.HashMap;
import java.util.List;

public class OperatorBuilder {

    private HashMap<String, IOperatorBuilder> allOperatorsBuilder;
    private IOperatorBuilder operatorBuilder;
    private List<String> parameters;

    public OperatorBuilder() {
        populateOperatorBuilderList();
    }

    public boolean contains(String inputToken) {
        return allOperatorsBuilder.containsKey(inputToken);
    }

    public OperatorBuilder with(String operator) {
        this.operatorBuilder = allOperatorsBuilder.get(operator);
        return this;
    }

    public OperatorBuilder withParameters(List<String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public Operator build() {
        return operatorBuilder
                .withParameters(parameters)
                .build();
    }

    private void populateOperatorBuilderList() {
        allOperatorsBuilder = new HashMap<String, IOperatorBuilder>();
        allOperatorsBuilder.put(">", new RedirectionOperatorBuilder());
    }
}
