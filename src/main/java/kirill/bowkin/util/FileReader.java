package kirill.bowkin.util;

import kirill.bowkin.exception.FileReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author Кирилл
 */
public abstract class FileReader {

    public static Stream<String> read(Path path) throws FileReadException {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new FileReadException("Failed to read file", e.getCause());
        }
    }
}
