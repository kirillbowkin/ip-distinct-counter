package kirill.bowkin.ipCounter;

import kirill.bowkin.exception.FileReadException;
import kirill.bowkin.util.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * @author Кирилл
 */
public class NaiveIpCounterTest {

    NaiveIpCounter naiveIpCounter;
    Path path;

    @Before
    public void setUp() throws Exception {
        naiveIpCounter = (NaiveIpCounter) IpCounters.naive();
        path = Paths.get("src/test/resources/ip.txt");
    }

    @Test
    public void shouldReturn4IfFileExists() throws FileReadException {
        var ipStream = FileReader.read(path);
        int count = naiveIpCounter.countUnique(ipStream);
        assertEquals(4, count);
    }
}