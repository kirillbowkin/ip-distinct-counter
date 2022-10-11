package kirill.bowkin.ipCounter;

import kirill.bowkin.exception.FileReadException;
import kirill.bowkin.util.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Кирилл
 */
public class HllIpCounterTest {

    HllIpCounter hllIpCounter;
    Path path;
    Stream<String> ipStream;

    @Before
    public void setUp() throws Exception {
        hllIpCounter = (HllIpCounter) IpCounters.hll();
        path = Paths.get("src/test/resources/ip.txt");
    }

    @Test
    public void shouldReturn4IfFileExists() throws FileReadException {
        var ipStream = FileReader.read(path);
        int count = hllIpCounter.count(ipStream);
        assertEquals(4, count);
    }
}