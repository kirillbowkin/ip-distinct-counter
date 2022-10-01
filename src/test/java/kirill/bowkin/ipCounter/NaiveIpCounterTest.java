package kirill.bowkin.ipCounter;

import kirill.bowkin.exception.FileReadException;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * @author Кирилл
 */
public class NaiveIpCounterTest {

    NaiveIpCounter naiveIpCounter;
    Path path;
    @Before
    public void setUp() throws Exception {
        naiveIpCounter = (NaiveIpCounter) IpCounters.naive();
        path = Paths.get("ip.txt");
    }

    @Test
    public void shouldReturn4IfFileExists() {
        int count = naiveIpCounter.count(path);
        assertEquals(4, count);
    }

    @Test(expected = FileReadException.class)
    public void shouldThrowExceptionIfFileNotExists() {
        naiveIpCounter.count(Paths.get("fjkds.txt"));
    }
}