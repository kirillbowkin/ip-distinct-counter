package kirill.bowkin.ipCounter;

import kirill.bowkin.util.HllFiller;

import java.util.stream.Stream;

/**
 * @author Кирилл
 */
public class HllIpCounter implements IpCounter {

    // Don't really like this name
    private final HllFiller hllFiller;

    public HllIpCounter(HllFiller hllFiller) {
        this.hllFiller = hllFiller;
    }

    @Override
    public int count(Stream<String> s) {
         hllFiller.fill(s);
         return (int) hllFiller.getCardinality();
    }

    @Override
    public String toString() {
        return "Hll counter";
    }
}
