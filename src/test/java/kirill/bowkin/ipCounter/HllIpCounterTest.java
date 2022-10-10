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
public class HllIpCounterTest {

    HllIpCounter hllIpCounter;
    Path path;

    @Before
    public void setUp() throws Exception {
        hllIpCounter = (HllIpCounter) IpCounters.hll();
        path = Paths.get("src/test/resources/ip.txt");
    }

    @Test
    public void shouldReturn4IfFileExists() {
        int count = hllIpCounter.count(path);
        assertEquals(4, count);
    }

    @Test(expected = FileReadException.class)
    public void shouldThrowExceptionIfFileNotExists() {
        hllIpCounter.count(Paths.get("fjkds.txt"));
    }
}