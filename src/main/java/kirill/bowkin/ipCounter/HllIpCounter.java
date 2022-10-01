package kirill.bowkin.ipCounter;

import com.google.common.hash.HashFunction;
import kirill.bowkin.exception.FileReadException;
import net.agkn.hll.HLL;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author Кирилл
 */
public class HllIpCounter implements IpCounter {

    private final HLL hll;
    private final HashFunction hashFunction;

    public HllIpCounter(HLL hll, HashFunction hashFunction) {
        this.hll = hll;
        this.hashFunction = hashFunction;
    }

    @Override
    public int count(Path path) {
        try (Stream<String> s = Files.lines(path)) {
            s.forEach(ip -> {
                long hashedValue = hashFunction.newHasher().putBytes(ip.getBytes(StandardCharsets.UTF_8)).hash().asLong();
                hll.addRaw(hashedValue);
            });
        } catch (IOException e) {
            throw new FileReadException(String.format("Error occurred while reading the file: %s", path), e.getCause());
        }

        return (int) hll.cardinality();
    }

    @Override
    public String toString() {
        return "Hll counter";
    }
}
