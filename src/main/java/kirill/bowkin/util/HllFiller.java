package kirill.bowkin.util;

import com.google.common.hash.HashFunction;
import net.agkn.hll.HLL;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

/**
 * @author Кирилл
 */
public class HllFiller {

    private final HLL hll;
    private final HashFunction hashFunction;

    public HllFiller(HLL hll, HashFunction hashFunction) {
        this.hll = hll;
        this.hashFunction = hashFunction;
    }

    public void fill(Stream<String> s) {
        s.forEach(ip -> {
            long hashedValue = hashFunction.newHasher().putBytes(ip.getBytes(StandardCharsets.UTF_8)).hash().asLong();
            hll.addRaw(hashedValue);
        });
    }

    public long getCardinality() {
        return hll.cardinality();
    }
}
