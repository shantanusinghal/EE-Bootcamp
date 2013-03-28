package ee.bootcamp.dd.operator.builder;

import ee.bootcamp.dd.operator.executor.Operator;
import ee.bootcamp.dd.operator.executor.RedirectionOperator;

import java.util.List;

public class RedirectionOperatorBuilder implements IOperatorBuilder {

    private String parameter;

    @Override
    public IOperatorBuilder withParameters(List<String> parameters) {
        parameter = parameters.get(0);
        return this;
    }

    @Override
    public Operator build() {
        return new RedirectionOperator(parameter);
    }
}
