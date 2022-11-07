package kirill.bowkin.util;

import com.google.common.hash.Hashing;
import net.agkn.hll.HLL;

/**
 * @author Кирилл
 */
public class HllFillers {
    public static HllFiller hllFiller() {
        return new HllFiller(new HLL(14, 5), Hashing.murmur3_128());
    }
}
