package explore.topics.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UncheckedExceptions {
    public void readFile(Path targetFile) {
        try {
            byte[] bytes = Files.readAllBytes(targetFile);
        } catch (IOException e) {
            throw new MyUncheckException("Unable to read file content. File: "
                    + targetFile, e);
        }
    }
}

class MyUncheckException extends RuntimeException {
    public MyUncheckException(String targetFile, IOException e) {
    }
}