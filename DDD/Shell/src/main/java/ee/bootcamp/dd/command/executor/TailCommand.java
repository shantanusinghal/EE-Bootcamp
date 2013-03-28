package ee.bootcamp.dd.command.executor;

import com.sun.deploy.util.StringUtils;
import ee.bootcamp.dd.operator.executor.Operator;
import ee.bootcamp.dd.option.Option;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class TailCommand implements Command {

    public void setNUMBER_OF_LINES(int NUMBER_OF_LINES) {
        this.NUMBER_OF_LINES = NUMBER_OF_LINES;
    }

    private int NUMBER_OF_LINES;
    private List<Option> options;
    private List<Operator> operators;
    private final int DEFAULT_NUMBER_OF_LINES = 10;
    private boolean nOptionIsSelected;

    public void setNOptionIsSelected(boolean nOptionIsSelected) {
        this.nOptionIsSelected = nOptionIsSelected;
    }

    public TailCommand() {
        nOptionIsSelected = false;
        options = new ArrayList<>();
        operators = new ArrayList<>();
        NUMBER_OF_LINES = DEFAULT_NUMBER_OF_LINES;
    }




    public void setDefineLineCountOption(String value) {
        NUMBER_OF_LINES = Integer.parseInt(value);
    }

    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    public String execute(List<String> inputParameters) {
        String fileName = inputParameters.get(0);
        Path file = FileSystems.getDefault().getPath("C:\\", fileName);
        List<String> fileContents = new ArrayList<>();

        try {
            fileContents = Files.readAllLines(file, Charset.defaultCharset());
            fileContents = addPrefixTo(fileContents);
        }
        catch (IOException e) {
            return "Error occurred while processing: " + e.getMessage();
        }

        List<String> response = fileContents.subList(fileContents.size() - NUMBER_OF_LINES, fileContents.size());

        for (Operator operator : operators) {
            response = operator.execute(response);
        }

        return StringUtils.join(response, "\n");
    }




    public void setShowLineNumberOption(boolean value) {
        nOptionIsSelected = value;
    }

    private List<String> addPrefixTo(List<String> fileContents) {
        if (nOptionIsSelected) {
            List<String> fileContentWithLineNumbers = new ArrayList<>();
            for(int index=0; index<fileContents.size(); index++) {
                fileContentWithLineNumbers.add( (index+1) + " " + fileContents.get(index));
            }
            return fileContentWithLineNumbers;
        }
        return fileContents;
    }
}