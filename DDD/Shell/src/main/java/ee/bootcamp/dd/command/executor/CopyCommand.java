package ee.bootcamp.dd.command.executor;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class CopyCommand implements Command {

    @Override
    public String execute(List<String> inputParameters) {
        String response;
        String sourceFileName = inputParameters.get(0);
        String targetFileName = inputParameters.get(1);
        Path sourceFile = FileSystems.getDefault().getPath("C:\\", sourceFileName);
        Path targetFile = FileSystems.getDefault().getPath("C:\\", targetFileName);

        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
            response = sourceFileName + " successfully copied to " + targetFileName;
        }
        catch (IOException e) {
            e.printStackTrace();
            response = e.toString();
        }

        return response;
    }
}
