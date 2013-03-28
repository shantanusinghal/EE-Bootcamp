package ee.bootcamp.dd.operator.executor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RedirectionOperator implements Operator {

    private final String targetFileName;

    public RedirectionOperator(String targetFileName) {
        this.targetFileName = targetFileName;
    }

    @Override
    public List<String> execute(List<String> input) {
        Path file = FileSystems.getDefault().getPath("C:\\", targetFileName);

        try {
            Files.write(file, input, Charset.defaultCharset());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> response = new ArrayList<>();
        response.add("Command successful");
        return response;
    }
}
