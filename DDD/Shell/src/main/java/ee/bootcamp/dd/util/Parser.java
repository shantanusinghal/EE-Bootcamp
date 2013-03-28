package ee.bootcamp.dd.util;

import ee.bootcamp.dd.operator.OperatorBuilder;
import ee.bootcamp.dd.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    String command = new String();
    List<String> options = new ArrayList<>();
    List<String> parameters = new ArrayList<>();
    List<String> operators = new ArrayList<>();

    public Input parse(String userInput) {
        initializeComponents();

        String optionsRegExp = "-[a-zA-Z]+\\s+\\d*";
        List<String> inputTokens = getInputTokens(userInput, optionsRegExp);

        extractCommand(inputTokens);
        extractOptions(userInput, optionsRegExp);
        int indexOfOperator = extractParameters(inputTokens);
        extractOperators(inputTokens, indexOfOperator);

        return new Input(command, options, parameters, operators);
    }

    private void initializeComponents() {
        command = new String();
        options = new ArrayList<>();
        parameters = new ArrayList<>();
        operators = new ArrayList<>();
    }

    private List<String> getInputTokens(String userInput, String optionsRegExp) {
        List<String> inputs = new ArrayList<>();
        for (String input : Arrays.asList(userInput.replaceAll(optionsRegExp, "").split(" "))) {
            if(input.length()!=0)
                inputs.add(input);
        }
        return inputs;
    }

    private void extractCommand(List<String> inputTokens) {
        command = inputTokens.remove(0);
    }

    private void extractOptions(String userInput, String optionsRegExp) {
        Matcher matcher = Pattern.compile(optionsRegExp).matcher(userInput);
        while(matcher.find()) {
            options.add(matcher.group(0));
        }
    }

    private int extractParameters(List<String> inputTokens) {
        OperatorBuilder operatorBuilder = new OperatorBuilder();
        for (String inputToken : inputTokens) {
            if(operatorBuilder.contains(inputToken))
                return inputTokens.indexOf(inputToken);
            parameters.add(inputToken);
        }
        return -1;
    }

    private void extractOperators(List<String> inputTokens, int indexOfOperator) {
        if(indexOfOperator>0) {
            operators = inputTokens.subList(indexOfOperator, inputTokens.size());
        }
    }
}
