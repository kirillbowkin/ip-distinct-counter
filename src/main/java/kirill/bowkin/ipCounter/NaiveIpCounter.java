package kirill.bowkin.ipCounter;

import kirill.bowkin.exception.FileReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author Кирилл
 */
public class NaiveIpCounter implements IpCounter {
    @Override
    public int count(Path path) {
        try(Stream<String> s = Files.lines(path)) {
            return (int)s.distinct().count();
        } catch (IOException e) {
            throw new FileReadException(String.format("Error occurred while reading the file: %s", path), e.getCause());
        }
    }

    @Override
    public String toString() {
        return "Naive counter";
    }
}
