package kirill.bowkin.util;

import kirill.bowkin.exception.FileReadException;
import org.junit.Test;

import java.nio.file.Path;

/**
 * @author Кирилл
 */
public class FileReaderTest {

    @Test(expected = FileReadException.class)
    public void shouldFailWithExceptionIfFIleNotExists() throws FileReadException {
        FileReader.read(Path.of("fsdfjsdk.txt"));
    }
}