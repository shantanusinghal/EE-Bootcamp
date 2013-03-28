package ee.bootcamp.dd.operator.builder;

import ee.bootcamp.dd.operator.executor.Operator;

import java.util.List;

public interface IOperatorBuilder {

    public IOperatorBuilder withParameters(List<String> options);

    public Operator build();

}
