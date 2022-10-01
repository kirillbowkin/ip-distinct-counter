package kirill.bowkin.ipCounter;

import com.google.common.hash.Hashing;
import net.agkn.hll.HLL;

/**
 * @author Кирилл
 */
public class IpCounters {
    public static IpCounter naive() {
        return new NaiveIpCounter();
    }

    public static IpCounter hll() {
        return new HllIpCounter(new HLL(14, 5), Hashing.murmur3_128());
    }
}
